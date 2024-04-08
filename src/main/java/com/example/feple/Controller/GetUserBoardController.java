package com.example.feple.Controller;

import com.example.feple.Entity.GetUserBoardEntity;
import com.example.feple.Repository.GetUserBoardRepository;
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
@RequestMapping(value = "/getuserboards")
public class GetUserBoardController {
    private final GetUserBoardRepository getuserboardRepository;

    @GetMapping("/previews")
    public ResponseEntity<List<GetUserBoardEntity>> getpreviewsGetUserBoard(){
        List<GetUserBoardEntity> getuserboards = getuserboardRepository.findTop4ByOrderByDatetimeDesc();
        if (getuserboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(getuserboards);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<GetUserBoardEntity>> getAllGetUserBoard(){
        List<GetUserBoardEntity> getuserboards = getuserboardRepository.findAll();
        if (getuserboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(getuserboards);
        }
    }

    @PostMapping("/save")
    public void GetUserBoardSave(@RequestBody GetUserBoardEntity getuserBoardEntity){
        getuserboardRepository.save(getuserBoardEntity);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateGetUserBoard(@RequestBody GetUserBoardEntity updatedGetUserBoard){
        Long id = updatedGetUserBoard.getId();

        GetUserBoardEntity existingGetUserBoard = getuserboardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("GetUserBoard not found with id: " + id));

        existingGetUserBoard.setNickname(updatedGetUserBoard.getNickname());
        existingGetUserBoard.setPostname(updatedGetUserBoard.getPostname());
        existingGetUserBoard.setContent(updatedGetUserBoard.getContent());
        existingGetUserBoard.setComments(updatedGetUserBoard.getComments());
        existingGetUserBoard.setHeart(updatedGetUserBoard.getHeart());
        existingGetUserBoard.setFavorite(updatedGetUserBoard.getFavorite());
        existingGetUserBoard.setDatetime(updatedGetUserBoard.getDatetime());
        getuserboardRepository.save(existingGetUserBoard);

        return ResponseEntity.ok().build();
    }
}
