package lgs.learning.spring.thymeleaf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/profile")
    public String profile(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Nguyen Van An"));
        profile.add(new Info("nickname", "lốddaf"));
        profile.add(new Info("gmail", "annv14@fsoft.com.vn"));
        profile.add(new Info("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Info("website", "https://lgs.me"));

        // Đưa thông tin vào Model
        model.addAttribute("lgsProfile", profile);

        // TRả về template profile.html
        return "profile";
    }
}
