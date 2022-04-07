package lgs.learning.spring.testinginspringboot;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import lgs.learning.spring.testinginspringboot.Todo;
import lgs.learning.spring.testinginspringboot.TodoRepository;
import lgs.learning.spring.testinginspringboot.TodoService;

@RunWith(SpringRunner.class)
public class TodoServiceTest2 {

	/*
	 * Cách này sử dụng @TestConfiguration Nó chỉ tạo ra Bean trong Context test này
	 * mà thôi Tiết kiệm thời gian hơn khi sử dụng @SpringBootTest (vì phải load hết
	 * Bean lên mà không dùng đến)
	 */
	@TestConfiguration
	public static class TodoServiceTest2Configuration {

		/*
		 * Tạo ra trong Context một Bean TodoService
		 */
		@Bean
		TodoService todoService() {
			return new TodoService();
		}
	}

	@MockBean
	TodoRepository todoRepository;

	@Autowired
	private TodoService todoService;

	@Before
	public void setUp() {
		Mockito.when(todoRepository.findAll()).thenReturn(IntStream.range(0, 10)
				.mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i)).collect(Collectors.toList()));

	}

	@Test
	public void testCount() {
		Assert.assertEquals(10, todoService.countTodo());
	}

}
