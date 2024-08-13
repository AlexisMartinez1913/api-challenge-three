package jagarcia.apichallengethree.mapper;

import jagarcia.apichallengethree.dtos.FootballPlayerDTO;
import jagarcia.apichallengethree.models.FootballPlayer;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T17:31:43-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
public class AutoFootballPlayerMapperImpl implements AutoFootballPlayerMapper {

    @Override
    public FootballPlayerDTO mapToFootballPlayerDto(FootballPlayer footballPlayer) {
        if ( footballPlayer == null ) {
            return null;
        }

        FootballPlayerDTO footballPlayerDTO = new FootballPlayerDTO();

        footballPlayerDTO.setId( footballPlayer.getId() );
        footballPlayerDTO.setName( footballPlayer.getName() );
        footballPlayerDTO.setAge( footballPlayer.getAge() );
        footballPlayerDTO.setPosition( footballPlayer.getPosition() );
        footballPlayerDTO.setNationality( footballPlayer.getNationality() );
        footballPlayerDTO.setTeam( footballPlayer.getTeam() );

        return footballPlayerDTO;
    }

    @Override
    public FootballPlayer mapToFootballPlayer(FootballPlayerDTO footballPlayerDTO) {
        if ( footballPlayerDTO == null ) {
            return null;
        }

        FootballPlayer footballPlayer = new FootballPlayer();

        footballPlayer.setId( footballPlayerDTO.getId() );
        footballPlayer.setName( footballPlayerDTO.getName() );
        footballPlayer.setAge( footballPlayerDTO.getAge() );
        footballPlayer.setPosition( footballPlayerDTO.getPosition() );
        footballPlayer.setNationality( footballPlayerDTO.getNationality() );
        footballPlayer.setTeam( footballPlayerDTO.getTeam() );

        return footballPlayer;
    }
}
