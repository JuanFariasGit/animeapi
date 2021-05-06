package one.digitalinnovation.animeapi.mapper;

import one.digitalinnovation.animeapi.dto.request.CategoryDTO;
import one.digitalinnovation.animeapi.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toModel(CategoryDTO categoryDTO);

    CategoryDTO toDTO(Category category);
}
