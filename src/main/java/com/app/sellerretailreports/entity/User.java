package com.app.sellerretailreports.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "users")
public class User {
    @Id
    private String id;
    private String email;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String password;
    private String firstName;
    private String lastName;
}
