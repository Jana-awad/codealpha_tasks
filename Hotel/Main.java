package Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();

        
        hotel.addRoom(new Room(101, "Single", 50.0, "Available"));
        hotel.addRoom(new Room(102, "Double", 80.0, "Available"));
        hotel.addRoom(new Room(201, "Suite", 150.0, "Available"));

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. Search available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View all reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter room category (Single, Double, Suite): ");
                    String category = scanner.nextLine();
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String checkIn = scanner.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String checkOut = scanner.nextLine();

                    hotel.searchAvailableRooms(category, checkIn, checkOut);
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter check-in date (YYYY-MM-DD): ");
                    String resCheckIn = scanner.nextLine();
                    System.out.print("Enter check-out date (YYYY-MM-DD): ");
                    String resCheckOut = scanner.nextLine();

                    hotel.makeReservation(guestName, roomNumber, resCheckIn, resCheckOut);
                    break;

                case 3:
                    hotel.viewReservations();
                    break;

                case 4:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
