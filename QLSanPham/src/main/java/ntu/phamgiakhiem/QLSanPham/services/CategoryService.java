package ntu.phamgiakhiem.QLSanPham.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ntu.phamgiakhiem.QLSanPham.models.Category;
import ntu.phamgiakhiem.QLSanPham.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> getAll() { 
        return categoryRepo.findAll(); 
    }

    public Category getById(int id) { 
        return categoryRepo.findById(id).orElse(null); 
    }

    public void save(Category c) { 
        categoryRepo.save(c); 
    }

    public void delete(int id) { 
        categoryRepo.deleteById(id); 
    }
}