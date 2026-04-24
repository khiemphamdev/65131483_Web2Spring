package thigk2.PhamGiaKhiem.ThiGK.services;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import thigk2.PhamGiaKhiem.ThiGK.models.Category;
import thigk2.PhamGiaKhiem.ThiGK.repositories.CategoryRepository;



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
