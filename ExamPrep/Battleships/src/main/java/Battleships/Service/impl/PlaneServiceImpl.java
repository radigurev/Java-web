package Battleships.Service.impl;

import Battleships.Service.CategoryService;
import Battleships.Service.PlaneService;
import Battleships.Service.UserService;
import Battleships.models.entity.Ship;
import Battleships.models.service.ShipServiceModel;
import Battleships.models.view.ShipModelView;
import Battleships.repository.ShipRepository;
import Battleships.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final HttpSession httpSession;
    private final UserService userService;
    private final CurrentUser  currentUser;
    private final CategoryService categoryService;
    public PlaneServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, HttpSession httpSession, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.httpSession = httpSession;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }

    @Override
    public void addToDB(ShipServiceModel map) {
        Ship ship=modelMapper.map(map, Ship.class);
        ship.setUser(userService.findById(currentUser.getId()));
        ship.setCategory(categoryService.findByName(map.getCategory()));
        shipRepository.saveAndFlush(ship);
    }

    @Override
    public List<ShipModelView> findEnemyShips() {
        return shipRepository.findAllByUserNot(userService.findById(currentUser.getId()))
                .stream().map(ship -> modelMapper.map(ship,ShipModelView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipModelView> findMineShips() {
        return shipRepository.findAllByUser(userService.findById(currentUser.getId()))
                .stream().map(ship -> modelMapper.map(ship,ShipModelView.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ShipModelView> findAll() {
        return shipRepository.findAll().stream()
                .map(ship -> modelMapper.map(ship,ShipModelView.class))
                .collect(Collectors.toList());
    }

    @Override
    public Ship findByName(String name) {
        return shipRepository.findByName(name).orElse(null);
    }

    @Override
    public void removeFromDB(long id) {
        shipRepository.deleteById(id);
    }

    @Override
    public void dealDmg(long health, long id) {
        shipRepository.setShipHealth(health,id);
    }

}
