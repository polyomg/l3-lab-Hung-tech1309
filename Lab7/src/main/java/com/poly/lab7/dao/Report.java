package com.poly.lab7.dao;

import com.poly.lab7.entity.Category;

public interface Report {
    Category getGroup();
    Double getSum();
    Long getCount();
}