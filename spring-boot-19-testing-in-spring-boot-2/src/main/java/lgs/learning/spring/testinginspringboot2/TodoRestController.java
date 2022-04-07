package lgs.learning.spring.testinginspringboot2;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TodoRestController {
    private final TodoService todoService;

    @GetMapping("/todo")
    public List<Todo> findAll() {
        return todoService.getAll();
    }
}
