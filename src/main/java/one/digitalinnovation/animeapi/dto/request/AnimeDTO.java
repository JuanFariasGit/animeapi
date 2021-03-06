package one.digitalinnovation.animeapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimeDTO {

    private Long id;

    @NotEmpty
    @Size(min = 4, max = 200)
    private String name;

    private int totalEpisode;

    private int currentEpisode;

    private LocalDateTime lastView = LocalDateTime.now();

    private List<CategoryDTO> categories;
}
