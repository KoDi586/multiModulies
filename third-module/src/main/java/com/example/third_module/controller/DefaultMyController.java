package com.example.third_module.controller;

import com.example.third_module.model.MyModel;
import com.example.third_module.service.MyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DefaultMyController {

    @Value("${server.ip1}")
    private String serverIp1;
    @Value("${server.ip2}")
    private String serverIp2;

    private final MyService myService;

    @GetMapping
    public String myFirst(Model model) {
        return "index";
    }

    @GetMapping(value = "get-list")
    public String getList(Model model) {
        List<MyModel> wholeList = myService.getWholeList();
        model.addAttribute("params", wholeList);
        log.info("list size is {}", wholeList.size());
        return "catalogue/list";
    }


    @GetMapping(value = "web-with-images")
    public String getImageSite(Model model) {
        model.addAttribute("myDescription", "мое изображение через 5 лет кача");
        return "catalogue/image";
    }

    @GetMapping(value = "wade-koichi")
    public String getWadeKoichi(Model model) {
        model.addAttribute("header2", "this is already prototip");
        return "catalogue/wade_koichi_2";
    }

    @GetMapping(value = "koichi-with-two-themes")
    public String getKoichiWithTwoThemes(Model model) {
        model.addAttribute("serverIp1", serverIp1);
        model.addAttribute("serverIp2", serverIp2);
        model.addAttribute("header1", "try click on logo");
        return "catalogue/wade_koichi_with_two_theme";
    }

    @GetMapping(value = "why")
    public String whyUDoing() {
        return "catalogue/why_clicking_more";
    }
}
