package one.digitalinnovation.animeapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "TB_ANIMES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    private int totalEpisode;

    private int currentEpisode;

    private LocalDateTime lastView;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Category> categories;
}
