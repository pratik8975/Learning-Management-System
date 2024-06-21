package com.sms.controllers;

import com.sms.entities.Assignment;
import com.sms.entities.Course;
import com.sms.entities.Trainer;
import com.sms.entities.User;
import com.sms.entities.dto.requests.TrainerRequest;
import com.sms.entities.dto.responses.MessageResponse;
import com.sms.entities.dto.responses.TrainerResponse;
import com.sms.entities.dto.responses.UserResponseTable;
import com.sms.services.AssignmentServiceImpl;
import com.sms.services.CourseServiceImpl;
import com.sms.services.TrainerServiceImpl;
import com.sms.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/choose-access")
public class ChooseAccessController {

    private static final String nullMessage = "Null values are not allowed.";
    private static final String trainerSaved = "Trainer saved with success.";
    private static final String trainerUpdated = "Trainer updated with success.";
    private static final String deletedMessage = "Trainer deleted with success.";

    @Autowired
    private UserDetailsServiceImpl userService;

    @Autowired
    private CourseServiceImpl courseService;

    @Autowired
    private AssignmentServiceImpl assignmentService;

    @Autowired
    private TrainerServiceImpl trainerService;

    @Autowired
    PasswordEncoder encoder;



    @GetMapping("/all")
    public String allAccess() {
        return "Learn without limits";
    }

    @GetMapping("/user")
//    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<?> userAccess() {

        List<Course> courses = new ArrayList<>();
        List<Assignment> assignments = new ArrayList<>();
        courses = courseService.findAllCourses();
        assignments = assignmentService.findAllAssignments();
        return new ResponseEntity(new UserResponseTable(courses, assignments), HttpStatus.OK);
    }

    @GetMapping("/mod")
//    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Administrator Dashboard";
    }

    @PostMapping("/trainer")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> save(@RequestBody TrainerRequest trainerRequest) {
        if (null != trainerRequest) {
            trainerRequest.setPassword(encoder.encode(trainerRequest.getPassword()));
            trainerService.save(trainerRequest);
            return (new ResponseEntity(new MessageResponse(trainerSaved),
                    HttpStatus.CREATED));
        } else {
            return (new ResponseEntity(new MessageResponse(nullMessage),
                    HttpStatus.BAD_REQUEST));
        }
    }

    @GetMapping("/trainer/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getTrainerById(@PathVariable int id) {

        return (new ResponseEntity(setTrainerResponse(id),
                HttpStatus.OK));
    }

    public TrainerResponse setTrainerResponse(int id) {
        User user = userService.findById(id);
        Trainer trainer = trainerService.findById(id);
        TrainerResponse trainerResponse = new TrainerResponse();

        trainerResponse.setId(id);
        trainerResponse.setEmail(user.getEmail());
        trainerResponse.setFirstName(user.getFirstName());
        trainerResponse.setLastName(user.getLastName());
        trainerResponse.setSubject(trainer.getSubbject());
        return (trainerResponse);
    }

    @DeleteMapping("/trainer/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        userService.delete(id);
        return (new ResponseEntity(new MessageResponse(deletedMessage),
                HttpStatus.OK));
    }

    @PutMapping("/trainer/{id}")
    public ResponseEntity<?> update(@PathVariable int id,
            @RequestBody TrainerRequest trainerRequest) {
        trainerRequest.setPassword(encoder.encode(trainerRequest.getPassword()));
        trainerService.update(id, trainerRequest);
        return (new ResponseEntity(new MessageResponse(trainerUpdated),
                HttpStatus.OK));
    }

}
