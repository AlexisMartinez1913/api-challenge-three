package jagarcia.apichallengethree.services;

import jagarcia.apichallengethree.dtos.FootballPlayerDTO;
import jagarcia.apichallengethree.models.FootballPlayer;
import jagarcia.apichallengethree.repositories.IFootballPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FootballPlayerService {
    @Autowired
    IFootballPlayerRepository iFootballPlayerRepository;


    //agregar
    public FootballPlayerDTO addFootballPlayer(FootballPlayer footballPlayerData) throws Exception {
        try {
            FootballPlayer savedFootballPlayer = iFootballPlayerRepository.save(footballPlayerData);
            // Convertir  a DTO y devolverlo
            return convertToDTO(savedFootballPlayer);
        } catch (Exception exception) {
            throw  new Exception(exception.getMessage());
        }
    }


    //listar todos

    public List<FootballPlayerDTO> getAllFootballPlayers() throws Exception {
        try {
            List<FootballPlayer> footballPlayerList = iFootballPlayerRepository.findAll();
            return convertToDTOList(footballPlayerList);
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    //listar dado un id

    public FootballPlayerDTO getFootballPlayerById(Integer id) throws Exception {
        try {
            Optional<FootballPlayer> footballPlayerOptional= iFootballPlayerRepository.findById(id);
            if (footballPlayerOptional.isPresent()) {
                FootballPlayer footballPlayer = footballPlayerOptional.get();
                return convertToDTO(footballPlayer);
            } else {
                throw new Exception("Football player not found");
            }
        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    //actualizar
    public FootballPlayerDTO updateFootballPlayer(Integer id, FootballPlayer footballPlayer) throws Exception {
        Optional<FootballPlayer> optionalFootballPlayer = iFootballPlayerRepository.findById(id);
        if (optionalFootballPlayer.isPresent()) {
            FootballPlayer existingFootballPlayer = optionalFootballPlayer.get();

            //se actualizan los nuevos campos
            existingFootballPlayer.setName(footballPlayer.getName());
            existingFootballPlayer.setAge(footballPlayer.getAge());
            existingFootballPlayer.setPosition(footballPlayer.getPosition());
            existingFootballPlayer.setNationality(footballPlayer.getNationality());
            existingFootballPlayer.setTeam(footballPlayer.getTeam());
            FootballPlayer modifiedFootballPlayer = iFootballPlayerRepository.save(existingFootballPlayer);
            return convertToDTO(modifiedFootballPlayer);
        } else {
            throw new Exception("Football player not found");
        }
    }

    //eliminar

    public void deleteFootballPlayer(Integer id) throws Exception {
        Optional<FootballPlayer> footballPlayerOptional = iFootballPlayerRepository.findById(id);
        if (footballPlayerOptional.isPresent()) {
            iFootballPlayerRepository.deleteById(id);
        } else {
            throw new Exception("Football player not found");
        }
    }






    //convertir entidad a dto
    public FootballPlayerDTO convertToDTO(FootballPlayer footballPlayer) {
        FootballPlayerDTO dto = new FootballPlayerDTO();
        dto.setId(footballPlayer.getId());
        dto.setName(footballPlayer.getName());
        dto.setAge(footballPlayer.getAge());
        dto.setPosition(footballPlayer.getPosition());
        dto.setNationality(footballPlayer.getNationality());
        dto.setTeam(footballPlayer.getTeam());
        return dto;
    }

    public List<FootballPlayerDTO> convertToDTOList(List<FootballPlayer> footballPlayerList) {
        return footballPlayerList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
