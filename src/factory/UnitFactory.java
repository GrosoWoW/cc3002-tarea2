package factory;

import model.items.IEquipableItem;
import model.units.*;
import model.map.Field;

import java.util.ArrayList;
import java.util.List;


public class UnitFactory{

    Field mapa;

    public UnitFactory(Field mapa){

        this.mapa = mapa;

    }
    public Alpaca createAlpaca(int hitPoints, int x, int y, IEquipableItem... items){

        return new Alpaca(hitPoints, 1, mapa.getCell(x,y), items);

    }


    public Archer createArcher(int hitPoints, int x, int y, IEquipableItem... items){

        return new Archer(hitPoints, 1, mapa.getCell(x,y), items);
    }


    public Cleric createCleric(int hitPoints, int x, int y, IEquipableItem... items){

        return new Cleric(hitPoints, 1, mapa.getCell(x,y), items);
    }


    public Fighter createFighter(int hitPoints, int x, int y, IEquipableItem... items){

        return new Fighter(hitPoints, 1, mapa.getCell(x,y), items);
    }


    public Hero createHero(int hitPoints, int x, int y, IEquipableItem... items){

        return new Hero(hitPoints, 1, mapa.getCell(x,y), items);
    }

    public Sorcerer createSorcerer(int hitPoints, int x, int y, IEquipableItem... items){

        return new Sorcerer(hitPoints, 1, mapa.getCell(x,y), items);
    }

    public SwordMaster createSwordMaster(int hitPoints, int x, int y, IEquipableItem... items){

        return new SwordMaster(hitPoints, 1, mapa.getCell(x,y), items);
    }








}
