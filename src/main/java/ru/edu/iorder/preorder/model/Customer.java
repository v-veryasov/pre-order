package ru.edu.iorder.preorder.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    @Column
//    private String login;
//    @Column
//    private String password;
//    @Column(name = "first_name")
//    private String firstName;
//    @Column(name = "middle_name")
//    private String middleName;
//    @Column(name = "last_name")
//    private String lastName;
//    @Column
//    private String email;
//    @Column(name = "registration_date")
//    private Instant registrationDate;
//    @Column(name = "last_activity_date")
//    private Instant lastActivityDate;
}

