package com.example;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class SecondController {

    @ModelAttribute
    public void bindCommonAttributes(Model model) {
        String value = "bind2";
        model.addAttribute("secondBindAction", value);
        model.addAttribute("currentBindAction", value);
    }

    @ModelAttribute
    public void takeOver(HttpServletRequest source, Model dest) {
        Arrays.asList("beforeBindAction", "beforeAction")
                .forEach(name -> dest.addAttribute(name, source.getAttribute(name)));
    }

    @GetMapping("/action2")
    public String action2(Model model,
                          @ModelAttribute("beforeBindAction") String beforeBindAction,
                          @ModelAttribute("beforeAction") String beforeAction,
                          @ModelAttribute("currentBindAction") String currentBindAction) {
        model.addAttribute("beforeBindActionFromArgument", beforeBindAction);
        model.addAttribute("currentBindActionFromArgument", currentBindAction);
        model.addAttribute("beforeActionFromArgument", beforeAction);
        model.addAttribute("secondAction", "action2");
        return "home";
    }

    @ModelAttribute
    public void takeOverAll(HttpServletRequest source, Model dest) {
        Collections.list(source.getAttributeNames())
                .forEach(name -> dest.addAttribute(name, source.getAttribute(name)));
    }

    @GetMapping("/confirm")
    public String confirm(@ModelAttribute(binding = false) DemoForm form, @ModelAttribute("org.springframework.validation.BindingResult.demoForm") BindingResult bindingResult) {
        System.out.println("---- confirm ----");
        System.out.println(form);
        System.out.println(bindingResult);
        System.out.println(bindingResult.hashCode());
        return "home";
    }

}
