package ParkingLot.exceptions;

public class TicketNotFoundException extends RuntimeException{
    public TicketNotFoundException() {
    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
