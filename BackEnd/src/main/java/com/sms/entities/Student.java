
package com.sms.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Integer id;
    
    @Basic(optional = false)
    @Column(name = "tuition_fees", nullable = false)
    private long tuitionFees; 
    
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private com.sms.entities.User user;
      
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();  

    public Student() {
    }

    public Student(Integer id, long tuitionFees, com.sms.entities.User user) {
        this.id = id;
        this.tuitionFees = tuitionFees;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(long tuitionFees) {
        this.tuitionFees = tuitionFees;
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
        sb.append("Student{");
        sb.append("id=").append(id);
        sb.append(", tuitionFees=").append(tuitionFees);
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
