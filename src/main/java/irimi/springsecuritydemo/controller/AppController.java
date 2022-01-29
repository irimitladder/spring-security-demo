package irimi.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String showHomePage() {
        return "home";
    }

    @GetMapping("/system")
    public String showSystemMainPage() {
        return "redirect:/system/info";
    }

    @GetMapping("/system/info")
    public String showSystemInfoPage() {
        return "system-info";
    }

    @GetMapping("/leaders")
    public String showLeadersPage() {
        return "leaders";
    }

    @GetMapping("/userAuthentication")
    public String showUserAuthenticationPage() {
        return "user-authentication";
    }

    @GetMapping("/accessDenied")
    public String showAccessDeniedPage() {
        return "access-denied";
    }
}
