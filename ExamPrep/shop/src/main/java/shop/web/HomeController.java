package shop.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shop.models.entity.enums.CategoriesEnumName;
import shop.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("user")==null)
            return "index";

        model.addAttribute("totalSum",productService.TotalSum())
                .addAttribute("drinks",productService.findAllProductsByCategory(CategoriesEnumName.DRINK))
                .addAttribute("food",productService.findAllProductsByCategory(CategoriesEnumName.FOOD))
                .addAttribute("households",productService.findAllProductsByCategory(CategoriesEnumName.HOUSEHOLD))
                .addAttribute("other",productService.findAllProductsByCategory(CategoriesEnumName.OTHER));

        return "home";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

}
