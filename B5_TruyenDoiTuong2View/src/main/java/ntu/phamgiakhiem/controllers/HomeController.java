package ntu.phamgiakhiem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ntu.phamgiakhiem.Model.Product;

@Controller
public class HomeController {
	@GetMapping("/product")
	public String showProduct(ModelMap model) {
	    Product product = new Product(1L, "Laptop Dell", 1500.0);
	    model.addAttribute("product", product);
	    return "product-detail";
	}
}
