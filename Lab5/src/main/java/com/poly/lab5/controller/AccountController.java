package com.poly.lab5.controller;

import com.example.demo.service.CookieService;
import com.example.demo.service.ParamService;
import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    CookieService cookieService;

    @Autowired
    ParamService paramService;

    @Autowired
    SessionService sessionService;

    @GetMapping("/login")
    public String login1(Model model) {
        // nếu có cookie user, prefill username
        String remembered = cookieService.getValue("user");
        model.addAttribute("remembered", remembered);
        return "account/login";
    }

    @PostMapping("/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);

        if ("poly".equals(un) && "123".equals(pw)) {
            // đăng nhập thành công
            sessionService.set("username", un);

            if (rm) {
                cookieService.add("user", un, 10 * 24);
            } else {
                cookieService.remove("user");
            }

            // ✅ lưu thông báo vào session và quay lại trang chủ
            sessionService.set("msg", "Đăng nhập thành công!");
            return "redirect:/";
        } else {
            model.addAttribute("msg", "Đăng nhập thất bại!");
            model.addAttribute("remembered", cookieService.getValue("user"));
            return "account/login";
        }
    }
}
