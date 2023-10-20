package exercise;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public List<Post> index(@RequestParam (defaultValue = "1") Integer page, @RequestParam (defaultValue = "10") Integer limit) {
        return  posts.stream().skip((page - 1) * limit).limit(limit).toList();
    }
    @GetMapping("/posts/{id}")
    public Optional<Post> show(@PathVariable String id) {
        var post = posts.stream().filter(post1 -> post1.getId().equals(id)).findFirst();
        return post;
    }
    @PostMapping("/posts")
    public Post create(@RequestBody Post post) {
        posts.add(post);
        return post;
    }
    @PutMapping("/post/{id}")
    public Post update(@PathVariable String id, @RequestBody Post data) {
        var isPostExist = posts.stream().filter(post -> post.getId().equals(id)).findFirst();
        if (isPostExist.isPresent()) {
            var post = isPostExist.get();
            post.setId(data.getId());
            post.setBody(data.getBody());
            post.setTitle(data.getTitle());
        }
        return data;
    }
    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(post -> post.getId().equals(id));
    }
    // END
}