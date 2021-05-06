package one.digitalinnovation.animeapi.repository;

import one.digitalinnovation.animeapi.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
