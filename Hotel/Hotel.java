package Hotel;

import java.util.ArrayList;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Hotel {
ArrayList<Room>rooms=new ArrayList<>();
ArrayList<Reservation>reservations=new ArrayList<>();

public void addRoom(Room room) {
	rooms.add(room);
}
public void addReservation(Reservation reservation) {
	reservations.add(reservation);
}
public void searchAvailableRooms(String category,String checkIn,String checkOut){
	System.out.println("Available rooms in category "+category+ ":");
	for(Room room:rooms) {
	if(room.category.equalsIgnoreCase(category)&&isRoomAvailable(room,checkIn,checkOut)) {
		System.out.println("Room number: "+room.roomNb+" ,price per night: "+room.pricePerNight);
	}
}
}
private boolean isRoomAvailable(Room room,String checkIn,String checkOut) {
	for(Reservation res:reservations) {
		if(res.room.roomNb==room.roomNb) {
			if(datesOverlap(checkIn,checkOut,res.checkInDate,res.checkOutDate)) {
				return false;
			}
		}
	}
	return true;
}
private boolean datesOverlap(String start1,String end1,String start2,String end2) {
	return!(end1.compareTo(start2)<=0 || start1.compareTo(end2)>=0);
}

public void makeReservation(String guestName, int roomNumber, String checkInStr, String checkOutStr) {
  
    Room selectedRoom = null;
    for (Room r : rooms) {
        if (r.roomNb == roomNumber) {
            selectedRoom = r;
            break;
        }
    }
    
    if (selectedRoom == null) {
        System.out.println("Room number " + roomNumber + " does not exist.");
        return;
    }
    

    if (!isRoomAvailable(selectedRoom, checkInStr, checkOutStr)) {
        System.out.println("Room " + roomNumber + " is not available for the given dates.");
        return;
    }
    

    LocalDate checkIn = LocalDate.parse(checkInStr);
    LocalDate checkOut = LocalDate.parse(checkOutStr);
    long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
    
    if (nights <= 0) {
        System.out.println("Check-out date must be after check-in date.");
        return;
    }
    
    double totalPrice = nights * selectedRoom.pricePerNight;
    
 
    Reservation newReservation = new Reservation(selectedRoom, checkInStr, checkOutStr, guestName, totalPrice);
    reservations.add(newReservation);
    
    System.out.println("Reservation successful!");
    System.out.println(newReservation);
}
public void viewReservations() {
    if (reservations.isEmpty()) {
        System.out.println("No reservations found.");
        return;
    }
    
    System.out.println("Current Reservations:");
    for (Reservation res : reservations) {
        System.out.println(res);
        System.out.println("------------------------");
    }
}

}