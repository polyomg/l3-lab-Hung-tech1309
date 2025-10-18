package com.poly.lab5.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    /** Đọc Cookie object từ request */
    public Cookie get(String name) {
        if (request.getCookies() == null) return null;
        for (Cookie c : request.getCookies()) {
            if (c.getName().equals(name)) return c;
        }
        return null;
    }

    /** Đọc value cookie, trả "" nếu không có */
    public String getValue(String name) {
        Cookie c = get(name);
        return (c == null) ? "" : c.getValue();
    }

    /** Tạo và gửi cookie (hours: thời hạn tính bằng giờ) */
    public Cookie add(String name, String value, int hours) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");
        cookie.setMaxAge(hours * 3600); // hours -> giây
        response.addCookie(cookie);
        return cookie;
    }

    /** Xóa cookie (gửi cookie có maxAge = 0) */
    public void remove(String name) {
        Cookie cookie = new Cookie(name, "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }
}
