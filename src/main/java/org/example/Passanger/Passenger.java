package org.example.Passanger;

import org.example.Seat.Seat;
import org.example.Space.Pluto;

public abstract class Passenger {
    private String name;

    private boolean hasPassengerBookedSeat = false ;

    public boolean isHasPassengerBookedSeat() {
        return hasPassengerBookedSeat;
    }

    public void setHasPassengerBookedSeat(boolean hasPassengerBookedSeat) {
        this.hasPassengerBookedSeat = hasPassengerBookedSeat;
    }

    private Seat passengerSeat;



    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract void getMeal(Passenger passenger);

    @Override
    public String toString() {
        return "Passenger " + name;
    }

    public abstract String plutoBelief(Pluto pluto);

    public void setPassengerSeat(Seat passengerSeat) {
        this.passengerSeat = passengerSeat;
    }
}






