package exercise.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController {


    private final JdbcTemplate jdbc;


    @PostMapping(path = "")
    public void createPerson(@RequestBody Map<String, Object> person) {
        String query = "INSERT INTO person (first_name, last_name) VALUES (?, ?)";
        jdbc.update(query, person.get("first_name"), person.get("last_name"));
    }

    // BEGIN
    @PostMapping(path = "/people/")
    public List<Map<String, Object>> showPersons(){
        String query = "SELECT * FROM PERSON ";
        return jdbc.queryForList(query);
    }
    @PostMapping(path = "/people/{id}")
    public Map<String, Object> showPerson(@PathVariable long id){
        String query = "SELECT * FROM PERSON WHERE id = ?";
        return jdbc.queryForMap(query);
    }
    // END
}
