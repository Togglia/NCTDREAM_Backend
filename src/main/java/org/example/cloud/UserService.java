package org.example.cloud;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.dto.RegistReq;
import org.example.cloud.dto.UserReq;
import org.example.cloud.dto.UserRes;
import org.example.cloud.exception.isExistedException;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;

    public UserRes login(UserReq userReq){
        Optional<User> opt = userRepository.findMemberByUserId(userReq.getUserId());
        if(opt.isEmpty()){
            log.info("ID 정보가 없습니다");
            return UserRes.builder()
                    .flag(0)
                    .build();
        }
        User member = opt.get();
        if(!member.getPassword().equals(userReq.getPassword())){
            log.info("잘못된 비밀번호입니다");
            return UserRes.builder()
                    .flag(1)
                    .build();
        }

        return UserRes.builder()
                .flag(2)
                .email(member.getEmail())
                .userName(member.getUserName())
                .password(member.getPassword())
                .build();
    }

    public void regist(RegistReq registReq){

        User user = User.builder()
                .userId(registReq.getUserId())
                .userName(registReq.getUserName())
                .email(registReq.getEmail())
                .gender(registReq.getGender())
                .password(registReq.getPassword())
                .build();
        userRepository.save(user);
    }

    public boolean check(String userId){
        return userRepository.existsUserByUserId(userId);
    }
}
