package lgs.learning.spring.specification;

import java.util.Collection;

import org.springframework.data.jpa.domain.Specification;

import lgs.learning.spring.specification.User.UserType;
import lgs.learning.spring.specification.User_;

public final class UserSpecification {
	/*
	 * Lấy ra user có UserType chỉ định
	 * 
	 * @param type
	 * 
	 * @return
	 */
	public static Specification<User> hasType(UserType type) {
		return (root, query, cb) -> cb.equal(root.get(User_.TYPE), type);
	}

	/*
	 * Lấy ra user có id chỉ định
	 * 
	 * @param userId
	 * 
	 * @return
	 */
	public static Specification<User> hasId(long userId) {
		return (root, query, cb) -> cb.equal(root.get(User_.ID), userId);
	}

	/*
	 * Lấy ra user nằm trong tập ID chỉ định
	 * 
	 * @param userIds
	 * 
	 * @return
	 */
	public static Specification<User> hasIdIn(Collection<Long> userIds) {
		return (root, query, cb) -> root.get(User_.ID).in(userIds);
	}
}
