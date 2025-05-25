package Hotel;

public class Reservation {
Room room;
String checkInDate;
String checkOutDate;
String paymentStatus;
String guestName;
double totalPrice;

public Reservation(Room room, String checkInDate, String checkOutDate, String guestName, double totalPrice) {
    this.room = room;
    this.checkInDate = checkInDate;
    this.checkOutDate = checkOutDate;
    this.guestName = guestName;
    this.totalPrice = totalPrice;
    this.paymentStatus = "Pending"; 
}


public void makePayment() {
    this.paymentStatus = "Paid";
}


@Override
public String toString() {
    return "Reservation Details:\n" +
           "Guest: " + guestName + "\n" +
           "Room Number: " + room.roomNb + " (" + room.category + ")\n" +
           "Check-in Date: " + checkInDate + "\n" +
           "Check-out Date: " + checkOutDate + "\n" +
           "Total Price: $" + totalPrice + "\n" +
           "Payment Status: " + paymentStatus;
}
}