package com.example.feple.Controller;

import com.example.feple.Entity.FreeBoardEntity;
import com.example.feple.Repository.FreeBoardRepository;
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
@RequestMapping(value = "/freeboards")
public class FreeBoardController {
    private final FreeBoardRepository freeboardRepository;

    @GetMapping("/previews")
    public ResponseEntity<List<FreeBoardEntity>> getpreviewsFreeBoard(){
        List<FreeBoardEntity> freeboards = freeboardRepository.findTop4ByOrderByDatetimeDesc();
        if (freeboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(freeboards);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<FreeBoardEntity>> getAllFreeBoard(){
        List<FreeBoardEntity> freeboards = freeboardRepository.findAll();
        if (freeboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(freeboards);
        }
    }

    @PostMapping("/save")
    public void FreeBoardSave(@RequestBody FreeBoardEntity freeBoardEntity){
        freeboardRepository.save(freeBoardEntity);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateFreeBoard(@RequestBody FreeBoardEntity updatedFreeBoard){
        Long id = updatedFreeBoard.getId();

        FreeBoardEntity existingFreeBoard = freeboardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("FreeBoard not found with id: " + id));

        existingFreeBoard.setNickname(updatedFreeBoard.getNickname());
        existingFreeBoard.setPostname(updatedFreeBoard.getPostname());
        existingFreeBoard.setContent(updatedFreeBoard.getContent());
        existingFreeBoard.setComments(updatedFreeBoard.getComments());
        existingFreeBoard.setHeart(updatedFreeBoard.getHeart());
        existingFreeBoard.setFavorite(updatedFreeBoard.getFavorite());
        existingFreeBoard.setDatetime(updatedFreeBoard.getDatetime());
        freeboardRepository.save(existingFreeBoard);

        return ResponseEntity.ok().build();
    }
}
