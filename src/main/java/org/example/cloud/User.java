package org.example.cloud;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    private String userId;

    private String gender;

    private String userName;

    private String email;

    private String password;

    @Builder
    public User(String userId, String gender, String userName, String email, String password){
        this.userId = userId;
        this.gender = gender;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
