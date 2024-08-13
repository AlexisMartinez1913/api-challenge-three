package jagarcia.apichallengethree.mapper;

import jagarcia.apichallengethree.dtos.FootballPlayerDTO;
import jagarcia.apichallengethree.models.FootballPlayer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoFootballPlayerMapper {
    AutoFootballPlayerMapper MAPPER = Mappers.getMapper(AutoFootballPlayerMapper.class);

    FootballPlayerDTO mapToFootballPlayerDto(FootballPlayer footballPlayer);
    FootballPlayer mapToFootballPlayer(FootballPlayerDTO footballPlayerDTO);
}
