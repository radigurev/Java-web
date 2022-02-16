package Battleships.web;

import Battleships.Service.PlaneService;
import Battleships.models.binding.ShipBindingModel;
import Battleships.models.entity.Ship;
import Battleships.models.service.ShipServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/ships")
public class PlaneController {
    private final ModelMapper modelMapper;
    private final PlaneService planeService;

    public PlaneController(ModelMapper modelMapper, PlaneService planeService) {
        this.modelMapper = modelMapper;
        this.planeService = planeService;
    }

    @ModelAttribute
    public ShipBindingModel shipBindingModel(){
        return new ShipBindingModel();
    }

    @GetMapping("/add")
    public String addPlane(HttpSession httpSession){
        if(httpSession.getAttribute("user")==null)
            return "redirect:/users/login";
        return "ship-add";
    }
    @PostMapping("/add")
    public String addShip(@Valid ShipBindingModel shipBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("shipBindingModel",shipBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipBindingModel",bindingResult);
            return "redirect:add";
        }
        Ship ship=planeService.findByName(shipBindingModel.getName());
        if(ship!=null)
            return "redirect:add";

        planeService.addToDB(modelMapper.map(shipBindingModel, ShipServiceModel.class));

        return "redirect:/";
    }
}
