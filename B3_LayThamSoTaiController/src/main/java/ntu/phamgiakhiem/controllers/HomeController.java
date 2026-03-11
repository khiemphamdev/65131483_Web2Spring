package ntu.phamgiakhiem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String B3(@RequestParam("mssv") String mssv, @RequestParam("ten") String ten, ModelMap m)
	{
		m.addAttribute("ten", ten);
		m.addAttribute("mssv", mssv);
		return "index";
	}
}