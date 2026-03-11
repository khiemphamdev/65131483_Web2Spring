package ntu.phamgiakhiem.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ntu.phamgiakhiem.model.Product;

@Controller
public class HomeController {
	@GetMapping("/products")
	public String showProduct(ModelMap model) {
		 List<Product> products = Arrays.asList(
			        new Product(1L, "Laptop Dell", 1500.0),
			        new Product(2L, "Mouse Logitech", 25.0),
			        new Product(3L, "Bàn phím cơ", 80.0)
			    );
	    model.addAttribute("products", products);
	    return "product-list";
	}
}
