package com.poly.lab1.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HinhChuNhatController {

    @Autowired
    private HttpServletRequest request;

    // Hiển thị form tính toán
    @GetMapping("/hinhchunhat/form")
    public String form() {
        return "hinhchunhat"; // trỏ tới hinhchunhat.html
    }

    // Xử lý tính toán
    @PostMapping("/hinhchunhat/calc")
    public String calc(Model model) {
        try {
            double length = Double.parseDouble(request.getParameter("length"));
            double width = Double.parseDouble(request.getParameter("width"));

            double area = length * width;
            double perimeter = 2 * (length + width);

            if(width > length) {
                double temp = length;
                length = width;
                width = temp;
            }



            model.addAttribute("message",
                    "Chu vi = " + "(" +length + "+" +width + ")" + "*2" + "="+ perimeter + ", Diện tích = " + area );
        } catch (Exception e) {
            model.addAttribute("message", "Vui lòng nhập số hợp lệ!");
        }
        return "hinhchunhat";
    }
}
