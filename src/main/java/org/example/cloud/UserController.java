package org.example.cloud;

import lombok.RequiredArgsConstructor;
import org.example.cloud.dto.RegistReq;
import org.example.cloud.dto.UserReq;
import org.example.cloud.dto.UserRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserReq userReq){
        UserRes res = userService.login(userReq);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/regist")
    public ResponseEntity<?> registUser(@RequestBody RegistReq registReq){
        userService.regist(registReq);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<?> checkUser(@RequestBody RegistReq registReq){
        return new ResponseEntity<>(userService.check(registReq.getUserId()),HttpStatus.OK);
    }


}
