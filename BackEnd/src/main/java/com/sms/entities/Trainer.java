package com.sms.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "subbject", nullable = false, length = 255)
    private String subbject;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private com.sms.entities.User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "trainers_courses",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Trainer> trainers = new HashSet<>();

    public Trainer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubbject() {
        return subbject;
    }

    public void setSubbject(String subbject) {
        this.subbject = subbject;
    }

    public com.sms.entities.User getUser() {
        return user;
    }

    public void setUser(com.sms.entities.User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Trainer{");
        sb.append("user_id=").append(id);
        sb.append(", subbject=").append(subbject);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }

}
