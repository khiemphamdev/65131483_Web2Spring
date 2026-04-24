package ntu.phamgiakhiem.QLSanPham.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ntu.phamgiakhiem.QLSanPham.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {}