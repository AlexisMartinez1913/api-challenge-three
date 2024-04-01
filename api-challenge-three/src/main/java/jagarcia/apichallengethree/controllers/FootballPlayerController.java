package jagarcia.apichallengethree.controllers;

import jagarcia.apichallengethree.dtos.errorsDTO.FootballPlayerErrorDTO;
import jagarcia.apichallengethree.models.FootballPlayer;
import jagarcia.apichallengethree.services.FootballPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/footballplayers")
public class FootballPlayerController {
    @Autowired
    private FootballPlayerService footballPlayerService;

    @PostMapping()
    public ResponseEntity<?> saveFootballPlayer(@RequestBody FootballPlayer footballPlayerData) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(this.footballPlayerService.addFootballPlayer(footballPlayerData));

        } catch (Exception exception) {
            FootballPlayerErrorDTO errorDTO = new FootballPlayerErrorDTO();
            errorDTO.setErrorMessage(exception.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getAllFootballPlayers() {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.footballPlayerService.getAllFootballPlayers());
        } catch( Exception error){

            FootballPlayerErrorDTO errorDTO = new FootballPlayerErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getFootballPlayerById(@PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.footballPlayerService.getFootballPlayerById(id));
        }catch( Exception error){

            FootballPlayerErrorDTO errorDTO = new FootballPlayerErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorDTO.getErrorMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFootballPlayer (@RequestBody FootballPlayer footballPlayerData, @PathVariable Integer id) {
        try{
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.footballPlayerService.updateFootballPlayer(id, footballPlayerData));
        }catch( Exception error){

            FootballPlayerErrorDTO errorDTO = new FootballPlayerErrorDTO();
            errorDTO.setErrorMessage(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDTO.getErrorMessage());
        }
    }

    //eliminar futbolista
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFootballPlayer(@PathVariable Integer id) {
        try {
            footballPlayerService.deleteFootballPlayer(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
    }
}
