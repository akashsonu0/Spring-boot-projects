package in.pwskills.akash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.akash.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
