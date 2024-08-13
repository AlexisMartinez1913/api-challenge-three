package jagarcia.apichallengethree.services.Impl;

import jagarcia.apichallengethree.dtos.FootballPlayerDTO;
import jagarcia.apichallengethree.exception.ResourceNotFoundException;
import jagarcia.apichallengethree.mapper.AutoFootballPlayerMapper;
import jagarcia.apichallengethree.models.FootballPlayer;
import jagarcia.apichallengethree.repositories.IFootballPlayerRepository;
import jagarcia.apichallengethree.services.FootballPlayerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FootballPlayerServiceImpl implements FootballPlayerService {

    private IFootballPlayerRepository footballPlayerRepository;

    @Override
    public FootballPlayerDTO createFootballPlayer(FootballPlayerDTO footballPlayer) {
        FootballPlayer footballPlayer1 = AutoFootballPlayerMapper.MAPPER.mapToFootballPlayer(footballPlayer);
        FootballPlayer savedFootballPlayer = footballPlayerRepository.save(footballPlayer1);
        return AutoFootballPlayerMapper.MAPPER.mapToFootballPlayerDto(savedFootballPlayer);
    }

    @Override
    public FootballPlayerDTO getFootballPlayerById(Integer id) {
        FootballPlayer footballPlayer = footballPlayerRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("FootballPlayer", "Id", id)
        );
        return AutoFootballPlayerMapper.MAPPER.mapToFootballPlayerDto(footballPlayer);
    }

    @Override
    public List<FootballPlayerDTO> getAllFootballPlayers() {
        List<FootballPlayer> footballPlayerList = footballPlayerRepository.findAll();

        return footballPlayerList.stream().map((footballPlayer ->
                AutoFootballPlayerMapper.MAPPER.mapToFootballPlayerDto(footballPlayer))).
                collect(Collectors.toList());
    }

    @Override
    public FootballPlayerDTO updateFootballPlayer(FootballPlayerDTO footballPlayerDto) {
        FootballPlayer existingFootballPlayer = footballPlayerRepository.findById(footballPlayerDto.getId())
                .orElseThrow(() -> new  ResourceNotFoundException("FootballPlayer", "Id", footballPlayerDto.getId()));
        existingFootballPlayer.setName(footballPlayerDto.getName());
        existingFootballPlayer.setAge(footballPlayerDto.getAge());
        existingFootballPlayer.setPosition(footballPlayerDto.getPosition());
        existingFootballPlayer.setNationality(footballPlayerDto.getNationality());
        existingFootballPlayer.setTeam(footballPlayerDto.getTeam());
        FootballPlayer updatedFootballPlayer = footballPlayerRepository.save(existingFootballPlayer);


        return AutoFootballPlayerMapper.MAPPER.mapToFootballPlayerDto(updatedFootballPlayer);
    }

    @Override
    public void deleteFootballPlayer(Integer id) {
        FootballPlayer existingFootballPlayer = footballPlayerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("FootballPlayer", "Id", id)
                );
        footballPlayerRepository.deleteById(id);

    }
}
