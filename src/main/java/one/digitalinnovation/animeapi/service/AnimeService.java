package one.digitalinnovation.animeapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.animeapi.dto.request.AnimeDTO;
import one.digitalinnovation.animeapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.animeapi.entity.Anime;
import one.digitalinnovation.animeapi.exception.AnimeNotFoundException;
import one.digitalinnovation.animeapi.mapper.AnimeMapper;
import one.digitalinnovation.animeapi.repository.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AnimeService {

    private AnimeRepository animeRepository;

    private final AnimeMapper animeMapper = AnimeMapper.INSTANCE;

    public MessageResponseDTO createAnime(AnimeDTO animeDTO) {
        Anime animeToSave = animeMapper.toModel(animeDTO);

        Anime savedAnime = animeRepository.save(animeToSave);
        return createMessageResponse(savedAnime.getId(), "Created anime with ID ");
    }

    public List<AnimeDTO> listAll() {
        List<Anime> animes = animeRepository.findAll();
        return animes.stream()
                .map(animeMapper::toDTO)
                .collect(Collectors.toList());
    }

    public AnimeDTO findById(Long id) throws AnimeNotFoundException {
        Anime anime = verifyIfExists(id);
        return animeMapper.toDTO(anime);
    }

    public MessageResponseDTO updateById(Long id, AnimeDTO animeDTO) throws AnimeNotFoundException {
        verifyIfExists(id);

        Anime animeToUpdate = animeMapper.toModel(animeDTO);

        Anime updateAnime = animeRepository.save(animeToUpdate);
        return createMessageResponse(updateAnime.getId(), "Updated anime with ID ");
    }

    public void delete(Long id) throws AnimeNotFoundException {
        verifyIfExists(id);
        animeRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Anime verifyIfExists(Long id) throws AnimeNotFoundException {
        return animeRepository.findById(id)
                .orElseThrow(() -> new AnimeNotFoundException(id));
    }
}
