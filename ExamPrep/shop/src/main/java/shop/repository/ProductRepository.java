package shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import shop.models.entity.Product;
import shop.models.entity.enums.CategoriesEnumName;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("SELECT SUM(p.price) FROM Product p")
    BigDecimal findTotalSum();

    List<Product> findAllByCategory_Name(CategoriesEnumName name);
}
