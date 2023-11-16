package exercise.service;

import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    // BEGIN
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorMapper mapper;

    public List<AuthorDTO> getAll() {
        var authors = authorRepository.findAll();
        var result = authors.stream()
                .map(mapper::map)
                .toList();
        return result;
    }
    public AuthorDTO create(AuthorCreateDTO dto) {
        var author = mapper.map(dto);
        authorRepository.save(author);
        return mapper.map(author);
    }
    public AuthorDTO findById(Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return mapper.map(author);
    }
    public AuthorDTO update(AuthorUpdateDTO dto, Long id) {
        var author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found"));
        mapper.update(dto, author);
        authorRepository.save(author);
        return mapper.map(author);
    }
    public void delete(Long id) {
        authorRepository.deleteById(id);
    }
    // END
}
