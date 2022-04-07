package lgs.learning.spring.helloprimaryqualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Girl {

	// Đánh dấu để Spring inject một đối tượng Outfit vào đây
	Outfit outfit;

	// Spring sẽ inject outfit thông qua Constructor đầu tiên
	// Ngoài ra, nó sẽ tìm Bean có @Qualifier("naked") trong context để ịnject
	public Girl(@Qualifier("naked") Outfit outfit) {
		this.outfit = outfit;
	}

	// GET
	// SET

	// Sử dụng trên method cũng được
	// @Autowired
	// public void setOutfit(Outfit outfit){
	// this.outfit = outfit;
	// }
}
