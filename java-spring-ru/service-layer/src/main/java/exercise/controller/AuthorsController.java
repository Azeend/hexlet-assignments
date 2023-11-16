package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.dto.BookCreateDTO;
import exercise.mapper.BookMapper;
import exercise.service.AuthorService;
import exercise.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<AuthorDTO> index() {
        return authorService.getAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO show(@PathVariable long id) {
        return authorService.findById(id);
    }
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    AuthorDTO create(@Valid @RequestBody AuthorCreateDTO dto) {
        return authorService.create(dto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    AuthorDTO update(@Valid @RequestBody AuthorUpdateDTO dto, @PathVariable long id) {
        return authorService.update(dto, id);
    }
    @DeleteMapping("")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable long id) {
        authorService.delete(id);
    }
    // END
}
