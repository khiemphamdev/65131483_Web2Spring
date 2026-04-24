package thigk2.PhamGiaKhiem.ThiGK.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import thigk2.PhamGiaKhiem.ThiGK.models.Product;
import thigk2.PhamGiaKhiem.ThiGK.services.CategoryService;
import thigk2.PhamGiaKhiem.ThiGK.services.ProductService;


@Controller
@RequestMapping("/products") // Tiền tố cho tất cả các link trong class này
public class HomeController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    // 1. Hiển thị danh sách tất cả sản phẩm (Trang người dùng)
    @GetMapping
    public String listAllProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        model.addAttribute("categories", categoryService.getAll());
        return "index"; // Trả về file product-list.html trong thư mục templates
    }
 // Lấy sản phẩm theo loại
    @GetMapping("/category/{id}")
    public String listProductsByCategory(@PathVariable("id") Integer categoryId, Model model) {
        model.addAttribute("products", productService.getProductsByCategoryId(categoryId));
        model.addAttribute("categories", categoryService.getAll());
        model.addAttribute("selectedCatId", categoryId); // Để đánh dấu loại đang chọn
        return "index"; 
    }

    // 2. Xem chi tiết một sản phẩm
    @GetMapping("/detail/{id}")
    public String showDetail(@PathVariable("id") int id, Model model) {
        Product p = productService.getById(id);
        if (p == null) {
            return "redirect:/products"; // Trả về danh sách nếu không thấy sản phẩm
        }
        model.addAttribute("products", p);
        return "product_detail";
    }
}