package kr.co.ckdgns.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.ckdgns.users.service.UserService;
import kr.co.ckdgns.vo.Users;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "signup"; // signup.jsp로 이동
    }

    @PostMapping("/signup")
    public String signup(Users user) {
        return ""; // 로그인 페이지로 리다이렉트
    }

    @GetMapping("/loginform")
    public String login() {
        return "loginform"; // login.jsp로 이동
    }
    
    @PostMapping("/login")
    public String login(@RequestParam String user_id, @RequestParam String user_password, Model model) {
//    	UserDetails  user = userService.login(user_id, user_password);
//        if (user != null) {
//            // 인증 객체 생성
//            Authentication auth = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
//            SecurityContextHolder.getContext().setAuthentication(auth);
//            return "/index"; // 로그인 성공 후 리다이렉트
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "/loginform"; // 로그인 실패 시 로그인 페이지로 돌아감
//        }
    	// 로그인 시도
        UserDetails userDetails = userService.loadUserByUsername(user_id);
        String url = "";

        // 사용자 검증
        if (userDetails != null && userService.checkPassword(user_password, userDetails.getPassword())) {
            // 인증 객체 생성
            Authentication auth = new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth);

            // 역할에 따라 리다이렉트
            if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            	url =  "redirect:/admin"; // 관리자 페이지로 리다이렉트
            } else if (userDetails.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            	url = "redirect:/user"; // 사용자 페이지로 리다이렉트
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "loginform"; // 로그인 실패 시 로그인 페이지로 돌아감
        }
        return url;
    }

}