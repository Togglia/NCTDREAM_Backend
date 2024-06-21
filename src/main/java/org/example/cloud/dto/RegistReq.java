package org.example.cloud.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistReq {
    private String userId;
    private String gender;
    private String userName;
    private String email;
    private String password;
}
