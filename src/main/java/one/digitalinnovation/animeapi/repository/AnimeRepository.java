package one.digitalinnovation.animeapi.repository;

import one.digitalinnovation.animeapi.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}
