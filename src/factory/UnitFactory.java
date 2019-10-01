package factory;

import model.items.IEquipableItem;
import model.units.*;
import model.map.Field;

import java.util.List;


public class UnitFactory{

    Field mapa;

    public UnitFactory(Field mapa){

        this.mapa = mapa;

    }
    public void createAlpaca(){

    }

    public Archer createArcher(int hitPoints, IEquipableItem items){

        return new Archer(hitPoints, 1, mapa.getCell(0,0), items);
    }
    public Cleric createCleric(int hitPoints, IEquipableItem items){

        return new Cleric(hitPoints, 1, mapa.getCell(0,0), items);
    }
    public Fighter createFighter(int hitPoints, IEquipableItem items){

        return new Fighter(hitPoints, 1, mapa.getCell(0,0), items);
    }
    public Hero createHero(int hitPoints, IEquipableItem items){

        return new Hero(hitPoints, 1, mapa.getCell(0,0), items);
    }
    public Sorcerer createSorcerer(int hitPoints, IEquipableItem items){

        return new Sorcerer(hitPoints, 1, mapa.getCell(0,0), items);
    }






}
