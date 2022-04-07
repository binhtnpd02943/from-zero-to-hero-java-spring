package lgs.learning.hibernate.customvalidation;

import lombok.Data;

@Data
public class User {
    // Đánh dấu field lgsId sẽ cần validate bởi @lgsId
    @LgsId
    private String lgsId;
}
