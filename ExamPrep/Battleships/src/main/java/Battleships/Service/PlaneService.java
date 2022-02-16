package Battleships.Service;

import Battleships.models.entity.Ship;
import Battleships.models.service.ShipServiceModel;
import Battleships.models.view.ShipModelView;

import java.util.List;

public interface PlaneService {
    void addToDB(ShipServiceModel map);

    List<ShipModelView> findEnemyShips();

    List<ShipModelView> findMineShips();

    List<ShipModelView> findAll();

    Ship findByName(String name);

    void removeFromDB(long id);

    void dealDmg(long health,long id);
}
