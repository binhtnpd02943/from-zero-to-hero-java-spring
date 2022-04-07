package lgs.learning.spring.testinginspringboot2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;

	public int countTodo() {
		return todoRepository.findAll().size();
	}

	public Todo getTodo(int id) {
		return todoRepository.findById(id);
	}

	public List<Todo> getAll() {
		return todoRepository.findAll();
	}
}
