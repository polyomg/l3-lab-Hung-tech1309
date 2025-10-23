// src/main/java/com/example/demo/service/AccountService.java
package com.poly.lab8.service;

import com.example.demo.entity.Account;

public interface AccountService {
    Account findById(String username);
}