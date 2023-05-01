package org.example.Seat;

import org.example.Passanger.Passenger;

public abstract class Seat {

    private int Id ;
    private boolean isBooked;

    private Passenger passenger ;

    public Seat(int Id) {
        this.isBooked = isBooked;
        this.passenger = passenger;
    }

    public int getId() {
        return Id;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }
}
