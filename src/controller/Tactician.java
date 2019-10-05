package controller;

import java.util.List;

public class Tactician {

    private final String name;
    List playerUnit;

    public Tactician(String name){

        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public List getPlayerUnit(){
        return this.playerUnit;


    }


}
