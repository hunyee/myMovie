package kr.co.ckdgns.common;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@GetMapping("/")
	public String index(Model model, Authentication authentication) {
		if (authentication != null) {
            model.addAttribute("username", authentication.getName());
            model.addAttribute("roles", authentication.getAuthorities());
        }
        return "index"; // index.html로 반환
	}
	
	@GetMapping("/user")
    public String userHome() {
        return "user/userHome"; // userHome.jsp
    }

    @GetMapping("/admin")
    public String adminHome() {
        return "admin/adminHome"; // adminHome.jsp
    }
	
}
