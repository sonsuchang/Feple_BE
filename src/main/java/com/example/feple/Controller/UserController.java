package com.example.feple.Controller;

import com.example.feple.Entity.UserEntity;
import com.example.feple.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getMyInfo(){
        List<UserEntity> userinfo = userRepository.findAll();
        if (userinfo.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(userinfo);
        }
    }

    @PostMapping("/save")
    public void userSave(@RequestBody UserEntity userEntity){
        userRepository.save(userEntity);
    }
}