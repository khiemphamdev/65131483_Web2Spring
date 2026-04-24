package thiGK.ntu65131483.DemoBaoMatCoBan.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	 @GetMapping("/")
	    public String HomePage() {
	        return "homepage";
	    }
	 
	 @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	 
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/products")
    public String SanPham() {
        return "SanPham";
    }
    @GetMapping("/admin/")
    public String admin() {
        return "admin";
    }
  
}
