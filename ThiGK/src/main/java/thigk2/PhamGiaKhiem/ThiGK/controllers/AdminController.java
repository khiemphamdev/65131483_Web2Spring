package thigk2.PhamGiaKhiem.ThiGK.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import thigk2.PhamGiaKhiem.ThiGK.models.Category;
import thigk2.PhamGiaKhiem.ThiGK.models.Product;
import thigk2.PhamGiaKhiem.ThiGK.services.CategoryService;
import thigk2.PhamGiaKhiem.ThiGK.services.ProductService;


@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/admin")
    public String getAdminDashboard(ModelMap m) {
        m.addAttribute("dsSanPham", productService.getAll());
        m.addAttribute("dsLoai", categoryService.getAll());

        return "admin";
    }

    @GetMapping("/admin/product/add")
    public String showAddForm(ModelMap m) {
        m.addAttribute("product", new Product()); // Tạo đối tượng rỗng
        m.addAttribute("dsLoai", categoryService.getAll()); // Lấy ds loại để đổ vào dropdown
        return "addProduct"; // Tên file HTML
    }
    @GetMapping("/admin/category/add")
    public String addCate(ModelMap m) {
        m.addAttribute("category", new Category()); // Tạo đối tượng rỗng
        return "addCategory"; // Tên file HTML
    }
    // Lưu hoặc cập nhật Sản phẩm
    @PostMapping("/admin/product/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/admin";
    }

    // Lưu hoặc cập nhật Loại sản phẩm
    @PostMapping("/admin/category/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        return "redirect:/admin";
    }

    // Xóa Sản phẩm
    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/admin"; 
    }

    // Xóa Loại sản phẩm
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id) {
        categoryService.delete(id);
        return "redirect:/admin"; 
    }

    // Trang chỉnh sửa Sản phẩm
    @GetMapping("/admin/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, ModelMap m) {
        Product p = productService.getById(id);
        if (p == null) {
            return "redirect:/admin?error=notfound";
        }
        m.addAttribute("product", p);
        m.addAttribute("dsLoai", categoryService.getAll()); // Để chọn lại loại sản phẩm
        
        return "updateProduct"; // Tên file HTML để sửa sản phẩm
    }
 // Trang chỉnh sửa Sản phẩm
    @GetMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable("id") int id, ModelMap m) {
        Category c = categoryService.getById(id);
        if (c == null) {
            return "redirect:/admin?error=notfound";
        }
        m.addAttribute("category", c);
      
        return "updateCategory"; // Tên file HTML để sửa sản phẩm
    }
}
