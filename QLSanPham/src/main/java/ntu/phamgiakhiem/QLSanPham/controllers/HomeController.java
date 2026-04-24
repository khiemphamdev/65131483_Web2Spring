package ntu.phamgiakhiem.QLSanPham.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ntu.phamgiakhiem.QLSanPham.models.Product;
import ntu.phamgiakhiem.QLSanPham.services.ProductService;

@Controller
@RequestMapping("/products") // Tiền tố cho tất cả các link trong class này
public class HomeController {

    @Autowired
    private ProductService productService;

    // 1. Hiển thị danh sách tất cả sản phẩm (Trang người dùng)
    @GetMapping("")
    public String listProducts(Model model) {
        model.addAttribute("dsSanPham", productService.getAll());
        return "product_list"; // Tên file HTML: product_list.html
    }

    // 2. Xem chi tiết một sản phẩm
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Product p = productService.getById(id);
        if (p == null) {
            return "redirect:/products"; // Trả về danh sách nếu không thấy sản phẩm
        }
        model.addAttribute("sp", p);
        return "product_detail";
    }
}
