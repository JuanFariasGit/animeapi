package one.digitalinnovation.animeapi.mapper;

import one.digitalinnovation.animeapi.dto.request.AnimeDTO;
import one.digitalinnovation.animeapi.entity.Anime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnimeMapper {
    AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);

    Anime toModel(AnimeDTO animeDTO);

    AnimeDTO toDTO(Anime anime);
}
