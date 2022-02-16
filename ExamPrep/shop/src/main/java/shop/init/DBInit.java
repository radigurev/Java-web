package shop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import shop.service.CategoryService;

@Component
public class DBInit implements CommandLineRunner {
    private final CategoryService categoryService;

    public DBInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.addCategories();
    }
}
