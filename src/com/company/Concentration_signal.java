package com.company;

import java.util.Observable;

public class Concentration_signal extends Observable {
    private String level;

    Concentration_signal(){
        level="Normal";
    }

    public void setlevel(String level) {
        level = this.level;
        //notify observer of change
        setChanged();
        notifyObservers();
    }

}
