package ntu.phamgiakhiem.WebBanDienThoai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	 @GetMapping("/products")
	    public String Product() {
	        return "product";
	    }

}
