package com.example.feple.Controller;

import com.example.feple.Entity.HotBoardEntity;
import com.example.feple.Repository.HotBoardRepository;
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
@RequestMapping(value = "/hotboards")
public class HotBoardController {
    private final HotBoardRepository hotboardRepository;

    @GetMapping("/previews")
    public ResponseEntity<List<HotBoardEntity>> getpreviewsHotBoard(){
        List<HotBoardEntity> hotboards = hotboardRepository.findTop4ByOrderByDatetimeDesc();
        if (hotboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hotboards);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotBoardEntity>> getAllHotBoard(){
        List<HotBoardEntity> hotboards = hotboardRepository.findAll();
        if (hotboards.isEmpty()){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(hotboards);
        }
    }

    @PostMapping("/save")
    public void HotBoardSave(@RequestBody HotBoardEntity hotBoardEntity){
        hotboardRepository.save(hotBoardEntity);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateHotBoard(@RequestBody HotBoardEntity updatedHotBoard){
        Long id = updatedHotBoard.getId();

        HotBoardEntity existingHotBoard = hotboardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HotBoard not found with id: " + id));

        existingHotBoard.setNickname(updatedHotBoard.getNickname());
        existingHotBoard.setPostname(updatedHotBoard.getPostname());
        existingHotBoard.setContent(updatedHotBoard.getContent());
        existingHotBoard.setHeart(updatedHotBoard.getHeart());
        existingHotBoard.setFavorite(updatedHotBoard.getFavorite());
        existingHotBoard.setDatetime(updatedHotBoard.getDatetime());
        hotboardRepository.save(existingHotBoard);

        return ResponseEntity.ok().build();
    }
}
