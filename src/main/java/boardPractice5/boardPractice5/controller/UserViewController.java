package boardPractice5.boardPractice5.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    // 진짜 화면만 보여줌!

    // save
    @GetMapping("/login")
    public String loginPage() {return "user/login";}
    // login
    @GetMapping("/signup")
    public String signup() {
        return "/user/signup";
    }

    //
}
