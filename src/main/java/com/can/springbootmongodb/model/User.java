package com.can.springbootmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "users")
public class User {
    @Id
    private String id;
    @Size(min = 2,max = 30)
    @NotEmpty
    private String firstName;
    @Size(min = 2,max = 30)
    @NotEmpty
    private String lastName;
    @Size(min = 10,max = 35)
    @Email
    @NotEmpty
    private String email;
    @NotEmpty

    private String nationalityId;
    @Past
    @NotNull
    private Date dateOfBirth;
    @CreatedDate
    private Date createdDate;
    private boolean isActive = true;

}
