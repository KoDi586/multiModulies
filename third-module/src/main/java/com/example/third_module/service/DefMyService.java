package com.example.third_module.service;

import com.example.third_module.model.MyModel;
import com.example.third_module.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefMyService implements MyService {

    private final MyRepository myRepository;

    @Override
    public List<MyModel> getWholeList() {
        return myRepository.findAll();
    }
}
