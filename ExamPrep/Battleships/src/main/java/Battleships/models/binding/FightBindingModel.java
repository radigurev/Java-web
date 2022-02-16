package Battleships.models.binding;

import Battleships.models.view.ShipModelView;

public class FightBindingModel {
    private String attackShip;
    private String defendShip;

    public FightBindingModel() {
    }

    public String getAttackShip() {
        return attackShip;
    }

    public void setAttackShip(String attackShip) {
        this.attackShip = attackShip;
    }

    public String getDefendShip() {
        return defendShip;
    }

    public void setDefendShip(String defendShip) {
        this.defendShip = defendShip;
    }
}
