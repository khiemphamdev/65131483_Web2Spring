package ntu.phamgiakhiem.QLSanPham.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import ntu.phamgiakhiem.QLSanPham.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {}