package com.poly.lab5.controller;

import com.example.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    SessionService sessionService;

    @RequestMapping("/")
    public String home(Model model) {
        // Lấy thông báo đăng nhập nếu có
        String msg = sessionService.get("msg");
        if (msg != null) {
            model.addAttribute("msg", msg);
            sessionService.remove("msg"); // hiển thị 1 lần rồi xoá
        }
        return "/home"; // trỏ đến templates/home/index.html
    }
}
