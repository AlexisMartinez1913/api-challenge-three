package jagarcia.apichallengethree.services;

import jagarcia.apichallengethree.dtos.FootballPlayerDTO;

import java.util.List;

public interface FootballPlayerService {
    FootballPlayerDTO createFootballPlayer(FootballPlayerDTO footballPlayer);
    FootballPlayerDTO getFootballPlayerById(Integer id);
    List<FootballPlayerDTO> getAllFootballPlayers();
    FootballPlayerDTO updateFootballPlayer(FootballPlayerDTO footballPlayer);
    void deleteFootballPlayer(Integer id);
}
