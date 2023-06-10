package boardPractice5.boardPractice5.controller;

import boardPractice5.boardPractice5.dto.AddUserRequest;
import boardPractice5.boardPractice5.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    // save일때 어떻게 작동
    @PostMapping("/user")
    public String save(@RequestBody AddUserRequest request) {
        userService.save(request);
        return "redirect:/login";
    }

    // 로그아웃일때 어떻게 작동
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request,response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect/login";
    }
}
