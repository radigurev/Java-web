package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import shop.models.entity.Product;
import shop.models.entity.enums.CategoriesEnumName;
import shop.models.service.ProductServiceModel;
import shop.models.view.ProductViewModel;
import shop.repository.ProductRepository;
import shop.service.CategoryService;
import shop.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel map) {
        Product product= modelMapper.map(map,Product.class);
        product.setCategory(categoryService.findCategory(map.getCategory()));

        productRepository.saveAndFlush(product);
    }

    @Override
    public BigDecimal TotalSum() {
        BigDecimal sum= productRepository.findTotalSum();
        BigDecimal zero=new BigDecimal(0);
        if (sum!=null && sum.compareTo(zero)==1)
            return sum;
        else
            return zero;
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoriesEnumName name) {
        return productRepository.findAllByCategory_Name(name)
                .stream()
                .map(product -> modelMapper.map(product,ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
