package org.example.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.example.Passanger.Human;
import org.example.Passanger.Martians;
import org.example.Passanger.Passenger;
import org.example.Seat.HumanSeat;
import org.example.Seat.HumanSeatFullException;
import org.example.Seat.MartianSeatFullException;

import org.example.Seat.Seat;
import org.junit.jupiter.api.Test;

class SpaceShipTest {
    @Test
    void testCreateShipSeat() {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(1, 1);

        // Act
        spaceShip.createShipSeat();

        // Assert
        List<Seat> seatStructure = spaceShip.getSeatStructure();
        assertEquals(2, seatStructure.size());
        Seat getResult = seatStructure.get(0);
        assertFalse(getResult.isBooked());
        Seat getResult2 = seatStructure.get(1);
        assertFalse(getResult2.isBooked());
        assertNull(getResult2.getPassenger());
        assertNull(getResult.getPassenger());
    }

    @Test
    void testBookHumanSeat() throws HumanSeatFullException {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(1, 1);
        Human passenger = new Human("Name");

        // Act
        spaceShip.bookHumanSeat(passenger);

        // Assert
        assertTrue(passenger.isHasPassengerBookedSeat());
        assertSame(passenger, spaceShip.getSeatStructure().get(0).getPassenger());
    }
    @Test
    void testBookHumanSeatIsFullException() {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(0, 1);

        // Act and Assert
        assertThrows(HumanSeatFullException.class,
                () -> spaceShip.bookHumanSeat(new Human("Name")));
    }
    @Test
    void testBookMartianSeat() throws MartianSeatFullException {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(1, 1);
        Martians passenger = new Martians("Name");

        // Act
        spaceShip.bookMartianSeat(passenger);

        // Assert
        assertTrue(passenger.isHasPassengerBookedSeat());
        assertSame(passenger, spaceShip.getSeatStructure().get(1).getPassenger());
    }

    @Test
    void testBookMartianSeatIsFullException()  {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(1, 0);

        // Act and Assert
        assertThrows(MartianSeatFullException.class,
                () -> spaceShip.bookMartianSeat(new Martians("Name")));
    }

    @Test
    void testGetSeatType() {
        // Arrange
        SpaceShip spaceShip = new SpaceShip(1, 1);

        // Act and Assert
        assertNull(spaceShip.getSeatType(new Human("Name")));
    }
    @Test
    void testGetSeatType2() {
        // Arrange, Act and Assert
        assertTrue((new SpaceShip(1, 1)).getSeatType(null) instanceof HumanSeat);
    }
}

