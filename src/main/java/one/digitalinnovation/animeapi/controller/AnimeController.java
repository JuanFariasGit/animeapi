package one.digitalinnovation.animeapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import one.digitalinnovation.animeapi.dto.request.AnimeDTO;
import one.digitalinnovation.animeapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.animeapi.exception.AnimeNotFoundException;
import one.digitalinnovation.animeapi.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/animes")
@Api(value = "AnimeAPI")
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimeController {

    private final AnimeService animeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adiciona um anime")
    public MessageResponseDTO createAnime(@RequestBody @Valid AnimeDTO animeDTO) {
        return animeService.createAnime(animeDTO);
    }

    @GetMapping
    @ApiOperation("Retorna uma lista de animes")
    public List<AnimeDTO> listAll() {
        return animeService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna um anime unico")
    public AnimeDTO findById(@PathVariable Long id) throws AnimeNotFoundException {
        return animeService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza um anime")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid AnimeDTO animeDTO)
            throws AnimeNotFoundException {
        return animeService.updateById(id, animeDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Deleta um anime")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws AnimeNotFoundException {
        animeService.delete(id);
    }
}
