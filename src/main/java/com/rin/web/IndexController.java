package com.rin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("host", "index界面动态绑定");
        modelMap.addAttribute("mon", 300);
        return "index";
    }
}
