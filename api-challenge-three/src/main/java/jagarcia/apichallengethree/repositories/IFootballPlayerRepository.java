package jagarcia.apichallengethree.repositories;

import jagarcia.apichallengethree.models.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IFootballPlayerRepository extends JpaRepository<FootballPlayer, Integer> {
}
