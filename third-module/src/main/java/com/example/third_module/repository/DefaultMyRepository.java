package com.example.third_module.repository;

import com.example.third_module.model.MyModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class DefaultMyRepository implements MyRepository {


    private final List<MyModel> models;

    public DefaultMyRepository() {
        models = new ArrayList<>();
        IntStream.range(10,20).forEach(
                iter -> models.add(new MyModel(iter, "description of number %d".formatted(iter)))
        );
    }

    @Override
    public List<MyModel> findAll() {
        return Collections.unmodifiableList(models);
    }
}
