package org.example.Passanger;

import org.example.Space.Pluto;

public class Human extends Passenger{
    public Human(String name) {
        super(name);
    }

    @Override
    public void getMeal(Passenger passenger) {
    }

    @Override
    public String toString() {
        return "Human " + getName();
    }

    @Override
    public String plutoBelief(Pluto pluto) {
        return pluto + "is a moon";
    }


}


