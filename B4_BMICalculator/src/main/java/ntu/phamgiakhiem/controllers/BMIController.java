package ntu.phamgiakhiem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BMIController {

    @GetMapping("/bmi")
    public String formBMI() {
        return "BMI";
    }

    @PostMapping("/bmi")
    public String tinhBMI(@RequestParam("weight") double weight,
            			@RequestParam("height") double height,
                          ModelMap model) {

        double result = weight / (height * height);
        String text;
        if(result < 18.5) text = "Gầy";
		else if(result >= 18.5 && result < 25) text = "Bình thường";
		else text = "Béo phì";
        String bmi = String.format("%.2f", result);
        model.addAttribute("bmi", bmi);
        model.addAttribute("text", text);

        return "BMI";
    }
}
