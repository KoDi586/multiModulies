package com.example.third_module.controller;

import com.example.third_module.model.MyModel;
import com.example.third_module.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/koichi")
public class DefaultMyController {

    private final MyService myService;

    @GetMapping
    public String myFirst(Model model) {
        return "index";
    }

    @GetMapping(value = "/get-list")
    public String getList(Model model) {
        List<MyModel> wholeList = myService.getWholeList();
        model.addAttribute("params", wholeList);
        log.info("list size is {}", wholeList.size());
        return "catalogue/list";
    }

    @GetMapping(value = "/two-themes")
    public String getKoichiWithTwoThemes(Model model) {
        model.addAttribute("header1", "try click on logo");
        return "catalogue/wade_koichi_with_two_theme";
    }

    @GetMapping(value = "/why")
    public String whyUDoing() {
        return "catalogue/why_clicking_more";
    }
}
