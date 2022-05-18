package demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

enum Color {
    BLACK, GREEN, RED, YELLOW;
}

enum Spot {
    Elevator_A, Elevator_B, Elevator_C, Elevator_D;
}

enum Status {
    parked, un_parked;
}

class Car {
    private String registrationNumber;
    private Color color;

    public Car(String registrationNumber, Color color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color=" + color +
                '}';
    }
}

class Ticket {
    private String ticketNumber = String.format("%d", new Date().getTime());
    private Car car;
    private Spot spot;
    private Date checkIn = new Date();
    private Date checkOut;
    private Status status;

    public Ticket(Car car, Spot spot) {
        this.car = car;
        this.spot = spot;
        this.status = Status.parked;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Car getCar() {
        return car;
    }

    public Spot getSpot() {
        return spot;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", car=" + car +
                ", spot=" + spot +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", status=" + status +
                '}';
    }
}

public class ParkingDemo {
    public static void main(String[] args) {
        List<Ticket> parkingInfo = new ArrayList();
        parkingInfo.add(new Ticket(new Car("DG-123", Color.BLACK), Spot.Elevator_A));
        parkingInfo.add(new Ticket(new Car("DG-124", Color.GREEN), Spot.Elevator_A));
        parkingInfo.add(new Ticket(new Car("DG-125", Color.RED), Spot.Elevator_B));
        parkingInfo.add(new Ticket(new Car("DG-126", Color.YELLOW), Spot.Elevator_A));
        parkingInfo.add(new Ticket(new Car("DG-127", Color.BLACK), Spot.Elevator_C));
        parkingInfo.add(new Ticket(new Car("DG-124", Color.YELLOW), Spot.Elevator_A));

        System.out.println("\nRegistration numbers of all cars of a particular Color. : " + Color.BLACK);
        List<String> registrationNumbers = getRegistrationNumbers(parkingInfo, Color.BLACK);
        printData(registrationNumbers);

        System.out.println("\nTicket number in which a car with a given registration number is placed : " + "DG-124");
        Optional<Ticket> carInfo = getParkingInfoByRegistrationNumber(parkingInfo, "DG-124");
        carInfo.ifPresent(System.out::println);

        System.out.println("\nTicket numbers of all ticket where a car of a particular color is placed. : " + Color.BLACK);
        List<String> ticketNumbers = getTickets(parkingInfo, Color.BLACK);
        printData(ticketNumbers);

    }

    private static Optional<Ticket> getParkingInfoByRegistrationNumber(List<Ticket> parkingPlace, String registrationNumber) {
        return parkingPlace
                .stream()
                .filter(ticket -> ticket.getCar().getRegistrationNumber().equals(registrationNumber))
                .findFirst();
    }

    private static List<String> getRegistrationNumbers(List<Ticket> parkingPlace, Color color) {
        return getParkingInfoByColor(parkingPlace, color)
                .stream().map(ticket -> ticket.getCar().getRegistrationNumber())
                .collect(Collectors.toList());
    }

    private static List<String> getTickets(List<Ticket> parkingPlace, Color color) {
        return getParkingInfoByColor(parkingPlace, color)
                .stream().map(Ticket::getTicketNumber)
                .collect(Collectors.toList());
    }

    private static List<Ticket> getParkingInfoByColor(List<Ticket> parkingPlace, Color color) {
        return parkingPlace
                .stream()
                .filter(ticket -> ticket.getCar().getColor() == color)
                .collect(Collectors.toList());
    }

    private static void printData(List<?> collect) {
        collect.forEach(System.out::println);
    }
}

