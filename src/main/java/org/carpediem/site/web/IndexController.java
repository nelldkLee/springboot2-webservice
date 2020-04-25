package org.carpediem.site.web;

import lombok.RequiredArgsConstructor;
import org.carpediem.site.config.auth.LoginUser;
import org.carpediem.site.config.auth.dto.SessionUser;
import org.carpediem.site.service.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        System.out.println("index page");
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/register")
    public String postsRegister() {
        System.out.println("posts register pages");
        return "posts-register";
    }

    @GetMapping("/posts/modify/{id}")
    public String postsModify(@PathVariable Long id, Model model) {
        System.out.println("posts modify pages");
        model.addAttribute("post", postsService.findById(id));
        return "posts-modify";
    }

}
