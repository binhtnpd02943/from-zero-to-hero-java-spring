package lgs.learning.spring.customconditional;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

/* Class kế thừa AnyNestedCondition sẽ chấp nhận mọi
* điều kiện @Conditional bên trong nó*/
public class WindowOrMacRequired extends AnyNestedCondition {

	public WindowOrMacRequired() {
		super(ConfigurationPhase.REGISTER_BEAN);
	}

	/*
	 * Bạn phải định nghĩa các Điều kiện bên trong class kế thừa AnyNestedCondition
	 */
	@Conditional(WindowRequired.class)
	public class RunOnWindow {
	}

	/*
	 * Lúc này, cả 2 điều kiện Window và Mac sẽ được kết hợp vs nhau khi kiểm tra,
	 * nếu thoả mãn 1 trong 2 là đc
	 */
	@Conditional(MacRequired.class)
	public class RunOnMac {
	}
}
