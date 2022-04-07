package lgs.learning.spring.testinginspringboot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lgs.learning.spring.testinginspringboot.Todo;
import lgs.learning.spring.testinginspringboot.TodoRestController;
import lgs.learning.spring.testinginspringboot.TodoService;

@RunWith(SpringRunner.class)
// Bạn cần cung cấp lớp Controller cho @WebMvcTest
@WebMvcTest(TodoRestController.class)
public class TodoRestControllerTest {
	/*
	 * Đối tượng MockMvc do Spring cung cấp Có tác dụng giả lập request, thay thế
	 * việc khởi động Server
	 */
	@Autowired
	MockMvc mvc;

	@MockBean
	TodoService todoService;

	@Test
	public void testFindAll() throws Exception {
		// Tạo ra một List<Todo> 10 phần tử
		List<Todo> allTodos = IntStream.range(0, 10).mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
				.collect(Collectors.toList());

		// giả lập todoService trả về List mong muốn
		given(todoService.getAll()).willReturn(allTodos);

		mvc.perform(get("/api/v1/todo").contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
				.andExpect(status().isOk()) // Mong muốn Server trả về status 200
				.andExpect(jsonPath("$", hasSize(10))) // Hi vọng server trả về List độ dài 10
				.andExpect(jsonPath("$[0].id", is(0))) // Hi vọng phần tử trả về đầu tiên có id = 0
				.andExpect(jsonPath("$[0].title", is("title-0"))) // Hi vọng phần tử trả về đầu tiên có title =
																	// "title-0"
				.andExpect(jsonPath("$[0].detail", is("detail-0")));
	}
}