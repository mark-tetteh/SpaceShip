package org.example.Model;

import org.example.Passanger.Human;
import org.example.Passanger.Martians;
import org.example.Passanger.Passenger;
import org.example.Seat.*;

import java.util.ArrayList;
import java.util.List;

public class SpaceShip {
    private List<Seat> seatStructure ;
    private final int maxCapacity ;
    private final int humanCapacity ;
    private final int martianCapacity;
    private int nextFreeHumanSeat ;
    private int nextFreeMartianSeat ;

    public SpaceShip(int humanCapacity , int martianCapacity) {
        this.maxCapacity = humanCapacity + martianCapacity;
        this.humanCapacity = humanCapacity ;
        this.martianCapacity = martianCapacity;
        this.nextFreeMartianSeat = humanCapacity;
        createShipSeat();
    }
    public void createShipSeat(){
        seatStructure = new ArrayList<>(maxCapacity);
        for(int i = 0 ; i < humanCapacity ; i++){
            seatStructure.add(new HumanSeat(i));
        }
        for (int i = humanCapacity ; i < maxCapacity ; i++)
            seatStructure.add(new MartianSeat(i));
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
    public int getHumanCapacity() {
        return humanCapacity;
    }
    public int getMartianCapacity() {
        return martianCapacity;
    }

    public void bookHumanSeat(Passenger passenger) throws HumanSeatFullException{
        if (passenger instanceof Human ){
            if(nextFreeHumanSeat < humanCapacity){
                seatStructure.get(nextFreeHumanSeat).setPassenger(passenger);
                passenger.setHasPassengerBookedSeat(true);
                nextFreeHumanSeat++;
            }
            else{
                throw new HumanSeatFullException("human seat is full");
            }
        }
    }
    public void bookMartianSeat(Passenger passenger) throws MartianSeatFullException {
        if (passenger instanceof Martians ){
            if(nextFreeMartianSeat <maxCapacity){
                seatStructure.get(nextFreeMartianSeat).setPassenger(passenger);
                passenger.setHasPassengerBookedSeat(true);
                nextFreeMartianSeat ++;
            }
            else {
                throw new MartianSeatFullException("Martian seat is Full");
            }
        }
    }
    public Seat getSeatType(Passenger passenger){
        for(Seat seat: seatStructure){
            if(seat.getPassenger() == passenger){
                return seat;
            }
        }
        return null;
    }

    public List<Seat> getSeatStructure() {
        return seatStructure ;
    }
}

