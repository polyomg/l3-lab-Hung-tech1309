package com.poly.lab5.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {

    @Autowired
    HttpSession session;

    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        Object v = session.getAttribute(name);
        if (v == null) return null;
        return (T) v;
    }

    public void set(String name, Object value) {
        session.setAttribute(name, value);
    }

    public void remove(String name) {
        session.removeAttribute(name);
    }
}
