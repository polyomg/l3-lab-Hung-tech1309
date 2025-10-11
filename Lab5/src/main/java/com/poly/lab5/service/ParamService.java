package com.poly.lab5.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ParamService {

    @Autowired
    HttpServletRequest request;

    @Autowired
    ServletContext application; // để chuyển path ảo -> thực tế

    public String getString(String name, String defaultValue) {
        String v = request.getParameter(name);
        return (v == null) ? defaultValue : v;
    }

    public int getInt(String name, int defaultValue) {
        String v = request.getParameter(name);
        if (v == null || v.isEmpty()) return defaultValue;
        try {
            return Integer.parseInt(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public double getDouble(String name, double defaultValue) {
        String v = request.getParameter(name);
        if (v == null || v.isEmpty()) return defaultValue;
        try {
            return Double.parseDouble(v);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    public boolean getBoolean(String name, boolean defaultValue) {
        String v = request.getParameter(name);
        if (v == null || v.isEmpty()) return defaultValue;
        return Boolean.parseBoolean(v);
    }

    public Date getDate(String name, String pattern) {
        String v = request.getParameter(name);
        if (v == null || v.isEmpty()) return null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(v);
        } catch (ParseException e) {
            throw new RuntimeException("Invalid date format for parameter " + name + ": " + v);
        }
    }

    /**
     * Lưu file upload vào thư mục path (tính từ webroot)
     * @param file MultipartFile upload
     * @param path đường dẫn ảo (ví dụ "/uploads")
     * @return File đã lưu hoặc null nếu không có file
     */
    public File save(MultipartFile file, String path) {
        try {
            if (file == null || file.isEmpty()) return null;

            String realPath = application.getRealPath(path);
            // Nếu realPath null (embedded container), lưu vào working dir /uploads
            if (realPath == null) {
                realPath = new File(".").getAbsolutePath() + File.separator + (path.startsWith("/") ? path.substring(1) : path);
            }
            File dir = new File(realPath);
            if (!dir.exists()) dir.mkdirs();

            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            File saved = new File(dir, filename);
            file.transferTo(saved);
            return saved;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
