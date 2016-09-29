package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class FirstController {

    @ModelAttribute
    public void bindCommonAttributes(Model model) {
        String value = "bind1";
        model.addAttribute("firstBindAction", value);
        model.addAttribute("beforeBindAction", value);
    }

    @ModelAttribute
    public DemoForm setUpForm() {
        return new DemoForm();
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("action", "home");
        model.addAttribute("nowDate", LocalDate.now());
        return "home";
    }

    @GetMapping("/action1")
    public String action1(Model model) {
        String value = "action1";
        model.addAttribute("firstAction", value);
        model.addAttribute("beforeAction", value);
        return "forward:/action2";

    }

    @GetMapping("/validate")
    public String action1(@Validated DemoForm form, BindingResult bindingResult) {
        System.out.println("---- validate ----");
        System.out.println(form);
        System.out.println(bindingResult);
        System.out.println(bindingResult.hashCode());
        return "forward:/confirm";
    }

}
