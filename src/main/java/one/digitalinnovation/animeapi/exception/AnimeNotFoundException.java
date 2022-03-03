package one.digitalinnovation.animeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AnimeNotFoundException extends Exception {
    public AnimeNotFoundException(Long id) {
        super("Anime not found with ID " + id);
    }
}
