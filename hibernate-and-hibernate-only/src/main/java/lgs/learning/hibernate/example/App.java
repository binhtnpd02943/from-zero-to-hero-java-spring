package lgs.learning.hibernate.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
//      Mọi thao tác với DB bắt từ từ một session
		Session session = factory.getCurrentSession();

		try {
//          session phải mở transaction trước khi thực hiện
			session.getTransaction().begin();

			String jpql = "Select e from " + Todo.class.getName() + " e ";

			System.out.println(jpql);

			// Tạo đối tượng Query.
			Query<Todo> query = session.createQuery(jpql, Todo.class);

			// Thực hiện truy vấn.
			List<Todo> todos = query.getResultList();

			for (Todo todo : todos) {
				System.out.println(todo);
			}

			// Commit là thực hiện mọi thay đổi xuống DB nếu có
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			// Rollback trong trường hợp có lỗi xẩy ra.
			session.getTransaction().rollback();
		}
	}

}
