package ParkingLot.exceptions;

public class ParkingSpotNotFoundForVehicleException extends RuntimeException{
    public ParkingSpotNotFoundForVehicleException() {
    }

    public ParkingSpotNotFoundForVehicleException(String message) {
        super(message);
    }
}
