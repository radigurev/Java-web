package Battleships.web;

import Battleships.Service.PlaneService;
import Battleships.models.binding.FightBindingModel;
import Battleships.models.entity.Ship;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class HomeController {

    private final PlaneService planeService;


    public HomeController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @ModelAttribute
    public FightBindingModel fightBindingModel(){
        return new FightBindingModel();
    }

    @GetMapping("/")
    public String homePage(HttpSession httpSession, Model model){
        if(httpSession.getAttribute("user")==null)
            return "index";

        model.addAttribute("enemyShips",planeService.findEnemyShips())
                .addAttribute("myShips",planeService.findMineShips())
                .addAttribute("findAll",planeService.findAll());

        return "home";
    }

    @PostMapping("/")
    public String home(@Valid FightBindingModel fightBindingModel, RedirectAttributes redirectAttributes){
        Ship attackShip = planeService.findByName(fightBindingModel.getAttackShip());
        Ship defendShip = planeService.findByName(fightBindingModel.getDefendShip());

        System.out.println();
        long health=defendShip.getHealth()-attackShip.getPower();

        if(health<=0){
            planeService.removeFromDB(defendShip.getId());
        }else
            planeService.dealDmg(health, defendShip.getId());

        return "redirect:/";
    }
}
