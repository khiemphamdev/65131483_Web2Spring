package ntu.phamgiakhiem.QLSanPham.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntu.phamgiakhiem.QLSanPham.models.Product;
import ntu.phamgiakhiem.QLSanPham.repositories.CategoryRepository;
import ntu.phamgiakhiem.QLSanPham.repositories.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepo;

    public List<Product> getAll() { return ProductRepo.findAll(); }
    public Product getById(int id) { return ProductRepo.findById(id).orElse(null);  }
    public void save(Product p) { ProductRepo.save(p); }
    public void delete(int id) { ProductRepo.deleteById(id); }
    
}
