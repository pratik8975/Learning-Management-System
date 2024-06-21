package com.spring.boot.controllers;

import com.spring.boot.config.security.jwt.JwtUtils;
import com.spring.boot.entities.ERole;
import com.spring.boot.entities.Role;
import com.spring.boot.entities.User;
import com.spring.boot.entities.dto.requests.ForgotPasswordRequest;
import com.spring.boot.entities.dto.requests.LoginRequest;
import com.spring.boot.entities.dto.requests.ResetPasswordRequest;
import com.spring.boot.entities.dto.requests.SignupRequest;
import com.spring.boot.entities.dto.responses.JwtResponse;
import com.spring.boot.entities.dto.responses.MessageResponse;
import com.spring.boot.repository.RoleRepository;
import com.spring.boot.repository.UserRepository;
import com.spring.boot.services.UserDetailsImpl;
import com.spring.boot.services.UserDetailsServiceImpl;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.validation.Valid;

import com.spring.boot.repository.PasswordResetTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordResetTokenRepository passwordRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserDetailsServiceImpl userService;

    /**
     * 
     * @param loginRequest
     * @return HTTPS request
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        //check if the user exists 
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());
            return new ResponseEntity(new JwtResponse(jwt,
                    userDetails.getId(), userDetails.getUsername(), roles), HttpStatus.OK);
        } catch (AuthenticationException authenticationException) {
            /**
             * @Description We catch the bad request that there is inside
             * AuthenticationManager because we did not had any body when there
             * was no user
             *
             */
            return new ResponseEntity("Username or password are incorrect.", HttpStatus.BAD_REQUEST);
        }

    }
    /**
     * @param signUpRequest
     * @return HTTPS Status
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (null != signUpRequest) {
            if (true) {

                if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                    return ResponseEntity
                            .badRequest()
                            .body(new MessageResponse("Error: Email is already in use!"));
                }
                User user = new User(signUpRequest.getEmail(),
                        encoder.encode(signUpRequest.getPassword()),
                        signUpRequest.getFirstName(),
                        signUpRequest.getLastName());

                Set<String> strRoles = signUpRequest.getRole();
                Set<Role> roles = new HashSet<>();

                if (strRoles == null) {
                    Role userRole = roleRepository.findByRole(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
                } else {
                    findRole(strRoles, roles);
                }
                user.setRoles(roles);
                userRepository.save(user);
                return new ResponseEntity(new MessageResponse("User registered successfully!"), HttpStatus.CREATED);
            } else {
                return new ResponseEntity(new MessageResponse("Users first or"
                        + " last name must not be null"), HttpStatus.BAD_REQUEST);

            }

        } else {
            return new ResponseEntity(new MessageResponse("User must not be null"), HttpStatus.BAD_REQUEST);
        }
    }
    
    /** 
    * @param strRoles
    * @param roles 
    */    
    public void findRole(Set<String> strRoles, Set<Role> roles) {
        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByRole(ERole.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(adminRole);

                    break;
                case "mod":
                    Role modRole = roleRepository.findByRole(ERole.ROLE_MODERATOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(modRole);

                    break;
                default:
                    Role userRole = roleRepository.findByRole(ERole.ROLE_USER)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                    roles.add(userRole);
            }
        });
    }

    /**
     * @param forgotPasswordRequest
     * @return
     */
    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest) {
        String response = "";
        String resetPasswordlink = userService.forgotPassword(forgotPasswordRequest.getEmail());

        if (!resetPasswordlink.startsWith("Invalid")) {

            try {
                response = "http://localhost:3000/reset-password?token=" + resetPasswordlink;
                sendEmail(forgotPasswordRequest.getEmail(), response);
                response = "We have sent a reset password link to your email. Please check.";

                return new ResponseEntity(new MessageResponse(response), HttpStatus.CREATED);

            } catch (UnsupportedEncodingException | MessagingException e) {
                return new ResponseEntity("Error while sending email.", HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity(new MessageResponse(response), HttpStatus.OK);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {
        String response = userService.resetPassword(
                resetPasswordRequest.getToken(),
                encoder.encode(resetPasswordRequest.getPassword()));
        if (response.contains("success")) {
            return new ResponseEntity(new MessageResponse(response), HttpStatus.OK);
        } else if (response.contains("expired")) {
            return new ResponseEntity(new MessageResponse(response), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(new MessageResponse(response), HttpStatus.BAD_REQUEST);

    }

    public void sendEmail(String recipientEmail, String link)
            throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("coodle.masters@gmail.com", "Coodle Support");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

}
