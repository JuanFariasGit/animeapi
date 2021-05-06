package one.digitalinnovation.animeapi.service;

import lombok.AllArgsConstructor;
import one.digitalinnovation.animeapi.dto.request.CategoryDTO;
import one.digitalinnovation.animeapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.animeapi.entity.Category;
import one.digitalinnovation.animeapi.exception.CategoryNotFoundException;
import one.digitalinnovation.animeapi.mapper.CategoryMapper;
import one.digitalinnovation.animeapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public MessageResponseDTO createCategory(CategoryDTO categoryDTO) {
        Category categoryToSave = categoryMapper.toModel(categoryDTO);

        Category savedCategory = categoryRepository.save(categoryToSave);
        return createMessageResponse(savedCategory.getId(), "Created category with ID ");
    }

    public List<CategoryDTO> listAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(categoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CategoryDTO findById(Long id) throws CategoryNotFoundException {
        Category category = verifyIfExists(id);
        return categoryMapper.toDTO(category);
    }

    public MessageResponseDTO updateById(Long id, CategoryDTO categoryDTO) throws CategoryNotFoundException {
        verifyIfExists(id);

        Category categoryToUpdate = categoryMapper.toModel(categoryDTO);

        Category updateCategory = categoryRepository.save(categoryToUpdate);
        return createMessageResponse(updateCategory.getId(), "Updated category with ID ");
    }

    public void delete(Long id) throws CategoryNotFoundException {
        verifyIfExists(id);
        categoryRepository.deleteById(id);
    }

    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private Category verifyIfExists(Long id) throws CategoryNotFoundException {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }
}
