package thigk2.PhamGiaKhiem.ThiGK.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thigk2.PhamGiaKhiem.ThiGK.models.Product;
import thigk2.PhamGiaKhiem.ThiGK.repositories.ProductRepository;




@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepo;

    public List<Product> getAll() { return ProductRepo.findAll(); }
    public Product getById(int id) { return ProductRepo.findById(id).orElse(null);  }
    public void save(Product p) { ProductRepo.save(p); }
    public void delete(int id) { ProductRepo.deleteById(id); }
    public List<Product> getProductsByCategoryId(Integer categoryId) {
     
        return ProductRepo.findByCategory_Id(categoryId);
    }
    
}
