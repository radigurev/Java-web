package shop.service;

import shop.models.entity.Product;
import shop.models.entity.enums.CategoriesEnumName;
import shop.models.service.ProductServiceModel;
import shop.models.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void add(ProductServiceModel map);

    BigDecimal TotalSum();

    List<ProductViewModel> findAllProductsByCategory(CategoriesEnumName name);

    void buyById(Long id);

    void buyAll();
}
