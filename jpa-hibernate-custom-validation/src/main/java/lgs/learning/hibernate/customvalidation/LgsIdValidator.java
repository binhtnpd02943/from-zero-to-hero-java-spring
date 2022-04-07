package lgs.learning.hibernate.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LgsIdValidator implements ConstraintValidator<LgsId, String> {
    private static final String lgs_PREFIX = "lgs://";

         // Kiểm tra tính hợp lệ của trường được đánh dấu bởi @lgsId
        @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null || s.isEmpty()) return false;

        return s.startsWith(lgs_PREFIX);
    }
}
