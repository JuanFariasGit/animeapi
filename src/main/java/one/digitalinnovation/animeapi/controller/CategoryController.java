package one.digitalinnovation.animeapi.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import one.digitalinnovation.animeapi.dto.request.CategoryDTO;
import one.digitalinnovation.animeapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.animeapi.exception.CategoryNotFoundException;
import one.digitalinnovation.animeapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Api(value = "AnimeAPI", tags = {"Category"})
@CrossOrigin("*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Adiciona uma categoria")
    public MessageResponseDTO createCategory(@RequestBody @Valid CategoryDTO categoryDTO) {
        return categoryService.createCategory(categoryDTO);
    }

    @GetMapping
    @ApiOperation("Retorna uma lista de categorias")
    public List<CategoryDTO> listAll() {
        return categoryService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Retorna uma única categoria")
    public CategoryDTO findById(@PathVariable Long id) throws CategoryNotFoundException {
        return categoryService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Atualiza uma categoria")
    public MessageResponseDTO updateById(@PathVariable Long id,@RequestBody @Valid CategoryDTO categoryDTO)
            throws CategoryNotFoundException {
        return categoryService.updateById(id, categoryDTO);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Exclui uma categoria, mas, só é possivel se a mesma não estiver sedo utilizada por nenhum anime")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws CategoryNotFoundException {
        categoryService.delete(id);
    }
}
