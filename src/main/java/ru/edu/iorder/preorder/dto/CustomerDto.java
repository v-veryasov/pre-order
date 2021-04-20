package ru.edu.iorder.preorder.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    private String login;
//    private String password;
//    private String firstName;
//    private String middleName;
//    private String lastName;
//    private String email;
//    private Instant registrationDate;
//    private Instant lastActivityDate;
}
