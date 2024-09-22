package com.example.third_module.repository;

import com.example.third_module.model.MyModel;

import java.util.List;

public interface MyRepository {
    List<MyModel> findAll();
}
