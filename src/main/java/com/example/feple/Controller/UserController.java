package com.example.feple.Controller;

import com.example.feple.Entity.UserEntity;
import com.example.feple.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getUserInfo(){
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

    @GetMapping("/followartist/{uid}")
    public ResponseEntity<List<String>> getFollowArtistByUid(@PathVariable String uid) {
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getFollow_artist());
    }

    @PatchMapping("/followartist/{uid}")
    public ResponseEntity<String> updateFollowArtistByUid(@PathVariable String uid, @RequestBody String ArtistName){
        UserEntity userEntity = userRepository.findByUid(uid);
        List<String> newFollowArtist = userEntity.getFollow_artist();
        newFollowArtist.add(ArtistName);
        userEntity.setFollow_artist(newFollowArtist);
        userRepository.save(userEntity);
        return ResponseEntity.ok("FollowArtist updated successfully");
    }

    @GetMapping("/nickname/{uid}")
    public ResponseEntity<String> getNicknameByUid(@PathVariable String uid) {
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getNickname());
    }

    @PatchMapping("/nickname/{uid}")
    public ResponseEntity<String> updateNicknameByUid(@PathVariable String uid, @RequestBody String newNickname) {
        UserEntity userEntity = userRepository.findByUid(uid);
        userEntity.setNickname(newNickname);
        userRepository.save(userEntity);
        return ResponseEntity.ok("Nickname updated successfully");
    }

    @GetMapping("/postnum/{uid}")
    public ResponseEntity<Long> getPostnumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getPost_num());
    }

    @PatchMapping("/postnum/{uid}")
    public ResponseEntity<String> updatePostnumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newPost_num = userEntity.getPost_num() + 1;
        userEntity.setPost_num(newPost_num);
        return ResponseEntity.ok("Postnum updated successfully");
    }

    @GetMapping("/commentnum/{uid}")
    public ResponseEntity<Long> getCommentnumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getComment_num());
    }

    @PatchMapping("/commentnum/{uid}")
    public ResponseEntity<String> updateCommentnumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newComment_num = userEntity.getComment_num() + 1;
        userEntity.setComment_num(newComment_num);
        return ResponseEntity.ok("Commentnum updated successfully");
    }

    @GetMapping("/bookmarknum/{uid}")
    public ResponseEntity<Long> getBookmarknumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getBookmark_num());
    }

    @PatchMapping("/bookmarknum/{uid}")
    public ResponseEntity<String> updateBookmarknumByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newBookmark_num = userEntity.getBookmark_num() + 1;
        userEntity.setBookmark_num(newBookmark_num);
        return ResponseEntity.ok("Bookmarknum updated successfully");
    }

    @GetMapping("/level/{uid}")
    public ResponseEntity<Long> getLevelByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getLevel());
    }

    @PatchMapping("/level/{uid}")
    public ResponseEntity<String> updateLevelByUid(@PathVariable String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newLevel = userEntity.getLevel() + 1; //TODO Level 업데이트 어떻게 해야할지 생각해야함
        userEntity.setPost_num(newLevel);
        return ResponseEntity.ok("Level updated successfully");
    }
}