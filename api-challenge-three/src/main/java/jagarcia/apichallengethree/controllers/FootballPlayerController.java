package jagarcia.apichallengethree.controllers;


import jagarcia.apichallengethree.dtos.FootballPlayerDTO;
import jagarcia.apichallengethree.models.FootballPlayer;
import jagarcia.apichallengethree.services.FootballPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/footballplayers")
public class FootballPlayerController {
    private FootballPlayerService footballPlayerService;

    @PostMapping
    public ResponseEntity<FootballPlayerDTO> createFootballPlayer(@RequestBody FootballPlayerDTO footballPlayerDTO) {
        FootballPlayerDTO savedFootballPlayer = footballPlayerService.createFootballPlayer(footballPlayerDTO);
        return new ResponseEntity<>(savedFootballPlayer, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<FootballPlayerDTO> getFootballPlayerById(@PathVariable("id") Integer id) {
        FootballPlayerDTO footballPlayerDTO = footballPlayerService.getFootballPlayerById(id);
        return new ResponseEntity<>(footballPlayerDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FootballPlayerDTO>> getAllFootballPlayers() {
        List<FootballPlayerDTO> footballPlayerDTOS = footballPlayerService.getAllFootballPlayers();
        return new ResponseEntity<>(footballPlayerDTOS, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<FootballPlayerDTO> updateFootballPlayer(@PathVariable("id") Integer id,
                                                                  @RequestBody FootballPlayerDTO footballPlayerDTO) {
        footballPlayerDTO.setId(id);
        FootballPlayerDTO updatedFootballPlayer = footballPlayerService.updateFootballPlayer(footballPlayerDTO);
        return new ResponseEntity<>(updatedFootballPlayer, HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteFootballPlayer(@PathVariable("id") Integer id) {
        footballPlayerService.deleteFootballPlayer(id);
        return new ResponseEntity<>("FootballPlayer successfully deleted!", HttpStatus.OK);
    }

}
