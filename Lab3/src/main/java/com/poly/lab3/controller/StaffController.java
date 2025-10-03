package com.poly.lab3.controller;

import com.poly.lab3.entity.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StaffController {

    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("staff1@gmail.com")
                .fullname("PRXAnhLong")
                .photo("Faker_2020_interview.jpg")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "staff-detail";
    }

    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("staff1@gmail.com").fullname("PRXAnhLong").photo("Faker_2020_interview.jpg").level(0).build(),
                Staff.builder().id("staff2@gmail.com").fullname("Nguyễn Hoàng Gia Hưng").photo("Faker_2020_interview.jpg").level(1).build(),
                Staff.builder().id("staff3@gmail.com").fullname("Nguyễn Tấn Dũng").photo("Faker_2020_interview.jpg").level(2).build(),
                Staff.builder().id("staff4@gmail.com").fullname("Phạm Đăng Khoa").photo("Faker_2020_interview.jpg").level(2).build(),
                Staff.builder().id("staff5@gmail.com").fullname("Lê Hoàng Chấn Kiệt").photo("Faker_2020_interview.jpg").level(1).build(),
                Staff.builder().id("staff6@gmail.com").fullname("Nguyễn Hoàng Gia Bảo").photo("Faker_2020_interview.jpg").level(0).build()
        );
        model.addAttribute("list", list);
        return "staff-list";
    }

    @RequestMapping("/staff/status")
    public String status(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("staff1@gmail.com").fullname("PRXAnhLong").level(0).build(),
                Staff.builder().id("staff2@gmail.com").fullname("Nguyễn Hoàng Gia Hưng").level(1).build(),
                Staff.builder().id("staff3@gmail.com").fullname("Nguyễn Tấn Dũng").level(2).build(),
                Staff.builder().id("staff4@gmail.com").fullname("Phạm Đăng Khoa").level(2).build(),
                Staff.builder().id("staff5@gmail.com").fullname("Lê Hoàng Chấn Kiệt").level(1).build(),
                Staff.builder().id("staff6@gmail.com").fullname("Nguyễn Hoàng Gia Bảo").level(0).build()
        );
        model.addAttribute("list", list);
        return "list-status";
    }

    @RequestMapping("/staff/controls")
    public String controls(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("staff1@gmail.com").fullname("PRXAnhLong").level(0).build(),
                Staff.builder().id("staff2@gmail.com").fullname("Nguyễn Hoàng Gia Hưng").level(1).build(),
                Staff.builder().id("staff3@gmail.com").fullname("Nguyễn Tấn Dũng").level(2).build(),
                Staff.builder().id("staff4@gmail.com").fullname("Phạm Đăng Khoa").level(2).build(),
                Staff.builder().id("staff5@gmail.com").fullname("Lê Hoàng Chấn Kiệt").level(1).build(),
                Staff.builder().id("staff6@gmail.com").fullname("Nguyễn Hoàng Gia Bảo").level(0).build()
        );
        model.addAttribute("list", list);
        return "list-controls";
    }
}
