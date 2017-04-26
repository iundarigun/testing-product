package br.com.devcave.product.repository;

import br.com.devcave.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByCategory_id(Long id);

    List<Product> findByPriceLessThanEqual(BigDecimal price);
}
