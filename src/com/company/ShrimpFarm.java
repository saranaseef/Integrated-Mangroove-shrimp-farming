package com.company;

import java.util.ArrayList;

public class ShrimpFarm {
    ArrayList<Concentration_signal> O2 = new ArrayList<>();
    ArrayList<Concentration_signal> CO2 = new ArrayList<>();
    ArrayList<Concentration_signal> NPK = new ArrayList<>();
    ArrayList<Concentration_signal> PH = new ArrayList<>();
    ArrayList<GateController> gates = new ArrayList<>();

    ShrimpFarm(){
        //Initialize all of the gates in the region and add them as observers
        for (int i = 0; i <= O2.size(); i++) {
            O2.set(i, new Concentration_signal());
            CO2.set(i, new Concentration_signal());
            NPK.set(i, new Concentration_signal());
            PH.set(i, new Concentration_signal());
        }
        for (int i = 0; i <= gates.size(); i++) {
            gates.set(i, new GateController(i+1));
            O2.get(i).addObserver(gates.get(i));
            CO2.get(i).addObserver(gates.get(i));
            NPK.get(i).addObserver(gates.get(i));
            PH.get(i).addObserver(gates.get(i));
            i++;
        }


    }

    void updateGate(int gateNumber){
        //update gate state if any of the signals change
        if(O2.get(gateNumber-1).hasChanged()|| CO2.get(gateNumber-1).hasChanged()|| NPK.get(gateNumber-1).hasChanged()|| PH.get(gateNumber-1).hasChanged())
            gates.get(gateNumber-1).update(O2.get(gateNumber-1),O2);
    }

}
