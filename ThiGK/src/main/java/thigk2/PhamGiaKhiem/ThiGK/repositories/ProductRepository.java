package thigk2.PhamGiaKhiem.ThiGK.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import thigk2.PhamGiaKhiem.ThiGK.models.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {
	List<Product> findByCategory_Id(Integer categoryId);
}
