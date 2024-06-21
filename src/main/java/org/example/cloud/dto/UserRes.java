package org.example.cloud.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRes {

    private int flag;
    private String email;
    private String userName;
    private String password;

}
