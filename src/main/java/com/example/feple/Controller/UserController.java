package com.example.feple.Controller;

import com.example.feple.Entity.UserEntity;
import com.example.feple.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUserInfo(){
        List<UserEntity> userinfo = userRepository.findAll();
        if (userinfo.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(userinfo);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<UserEntity> getUserInfo(@RequestParam String uid) {
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity);
    }

    @PostMapping("/save")
    public void userSave(@RequestBody UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @GetMapping("/followartist")
    public ResponseEntity<List<String>> getFollowArtistByUid(@RequestParam String uid) {
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getFollow_artist());
    }

    @PatchMapping("/followartist")
    public ResponseEntity<String> updateFollowArtistByUid(@RequestParam String uid, @RequestBody String ArtistName){
        UserEntity userEntity = userRepository.findByUid(uid);
        List<String> newFollowArtist = userEntity.getFollow_artist();
        newFollowArtist.add(ArtistName);
        userEntity.setFollow_artist(newFollowArtist);
        userRepository.save(userEntity);
        return ResponseEntity.ok("FollowArtist updated successfully");
    }

    @GetMapping("/nickname")
    public ResponseEntity<String> getNicknameByUid(@RequestParam String uid) {
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getNickname());
    }

    @PatchMapping("/nickname")
    public ResponseEntity<String> updateNicknameByUid(@RequestParam String uid, @RequestBody String newNickname) {
        UserEntity userEntity = userRepository.findByUid(uid);
        userEntity.setNickname(newNickname);
        userRepository.save(userEntity);
        return ResponseEntity.ok("Nickname updated successfully");
    }

    @GetMapping("/postnum")
    public ResponseEntity<Long> getPostnumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getPost_num());
    }

    @PatchMapping("/postnum")
    public ResponseEntity<String> updatePostnumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newPost_num = userEntity.getPost_num() + 1;
        userEntity.setPost_num(newPost_num);
        return ResponseEntity.ok("Postnum updated successfully");
    }

    @GetMapping("/commentnum")
    public ResponseEntity<Long> getCommentnumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getComment_num());
    }

    @PatchMapping("/commentnum")
    public ResponseEntity<String> updateCommentnumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newComment_num = userEntity.getComment_num() + 1;
        userEntity.setComment_num(newComment_num);
        return ResponseEntity.ok("Commentnum updated successfully");
    }

    @GetMapping("/bookmarknum")
    public ResponseEntity<Long> getBookmarknumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getBookmark_num());
    }

    @PatchMapping("/bookmarknum")
    public ResponseEntity<String> updateBookmarknumByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newBookmark_num = userEntity.getBookmark_num() + 1;
        userEntity.setBookmark_num(newBookmark_num);
        return ResponseEntity.ok("Bookmarknum updated successfully");
    }

    @GetMapping("/level")
    public ResponseEntity<Long> getLevelByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        return ResponseEntity.ok(userEntity.getLevel());
    }

    @PatchMapping("/level")
    public ResponseEntity<String> updateLevelByUid(@RequestParam String uid){
        UserEntity userEntity = userRepository.findByUid(uid);
        Long newLevel = userEntity.getLevel(); //TODO Level 업데이트 어떻게 해야할지 생각해야함
        userEntity.setPost_num(newLevel);
        return ResponseEntity.ok("Level updated successfully");
    }
}