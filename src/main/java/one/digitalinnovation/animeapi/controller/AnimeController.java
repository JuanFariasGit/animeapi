package one.digitalinnovation.animeapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.animeapi.dto.request.AnimeDTO;
import one.digitalinnovation.animeapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.animeapi.entity.Anime;
import one.digitalinnovation.animeapi.exception.AnimeNotFoundException;
import one.digitalinnovation.animeapi.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/anime")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimeController {

    private AnimeService animeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createAnime(@RequestBody @Valid AnimeDTO animeDTO) {
        return animeService.createAnime(animeDTO);
    }

    @GetMapping
    public List<AnimeDTO> listAll() {
        return animeService.listAll();
    }

    @GetMapping("/{id}")
    public AnimeDTO findById(@PathVariable Long id) throws AnimeNotFoundException {
        return animeService.findById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid AnimeDTO animeDTO)
            throws AnimeNotFoundException {
        return animeService.updateById(id, animeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AnimeNotFoundException {
        animeService.delete(id);
    }
}
