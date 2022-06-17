// YouTube reference - https://www.youtube.com/watch?v=EYc5oBLYi24

import java.util.*;


import java.text.ParseException;
import java.text.SimpleDateFormat;

class Bus {
    private int busNo;
    private boolean ac;
    private int capacity; // get and set methods should be defined as we have used private access modifier
                          // to return values to the other classes

    Bus(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
    }

    public int getCapacity() { // getter methods - accessor method
        return capacity;
    }

    public int setCapacity(int cap) { // setter methods - mutator method
        this.capacity = cap;
        return cap;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public void setAV(boolean val) {
        ac = val;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " ,Ac: " + ac + " ,Total Capacity: " + capacity);
    }
}

class Booking {
    String passengerName;
    int busNo;
    Date date;
    String dateInput;

    Booking(String passengerName, int busNo, Date date) { // wrong date format to throw exception,
                                                          // even we can use try/catch block. We
                                                          // can
        // also be Exception instead of ParseException
        this.passengerName = passengerName;
        this.busNo = busNo;
        this.date = date;
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity = 0;
        for (Bus bus : buses) {
            if (bus.getBusNo() == busNo) { // busNo comes from the booking object invocation
                capacity = bus.getCapacity();
                capacity = bus.setCapacity(--capacity);
            }
        }
        int booked = 0;
        for (Booking b : bookings) {
            if (b.busNo == busNo && b.date.equals(date)) { // same date and same bus so increment the booked counter
                booked++;
            }
        }

        return booked < capacity ? true : false;
    }

    void displayBookingInfo() {

        System.out.println("Passenger Name      bus No      Date");
        System.out.println(passengerName + "                " + busNo + "           " + date);
    }

}

class BusReservationSystem {
    public static void main(String[] args) throws Exception { // can also be Exception
        // System.out.println("god help me");
        System.out.println("_________WELCOME TO BUS RESERVATION SYSTEM_________");
        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1, true, 2)); // create new bus object and add to the buses list
        buses.add(new Bus(2, true, 50));
        buses.add(new Bus(3, false, 48));

        // int buscnt = 0;
        int userOpt = 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Available Buses List");
        for (Bus b : buses) {
            b.displayBusInfo();
        }
        int check = 0;
        System.out.println();
        while (true) {
            System.out.println("1.Book\n2.Display Booking\n3.Bus Details\n4.Cancel Ticket");

            userOpt = in.nextInt();
            if (userOpt == 1) {
                check = 1;
                System.out.println("Enter the name of the passenger: ");
                String passengerName = in.next();
                System.out.println("Enter bus no: ");
                int busNo = in.nextInt();

                int buscheck = 0;
                while (true) {
                    for (Bus bs : buses) {
                        if (bs.getBusNo() == busNo) {
                            buscheck = 1;
                        }
                    }
                    if (buscheck == 0) {
                        System.out.println("Invalid Bus No, Please try again!");
                    } else {
                        break;
                    }
                    System.out.println("Enter Bus No");
                    busNo = in.nextInt();
                    // break;

                }

                System.out.println("Enter date dd-mm-yyyy");
                String dateInput = in.next();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // capital MM as it is used for Month.
                                                                                  // small
                                                                                  // mm is used for minutes
                Date date = dateFormat.parse(dateInput);

                Booking booking = new Booking(passengerName, busNo, date);
                if (booking.isAvailable(bookings, buses)) {
                    bookings.add(booking);
                    System.out.println("Your booking is confirmed");
                    System.out.println();

                } else {
                    System.out.println("Sorry. Bus is full. Try another bus or date");
                }
            }
            if (userOpt == 2) {
                if (bookings.size() == 0) {
                    System.out.println("No bookings Done!");
                    System.out.println("Please book a ticket!!");
                    System.out.println();
                }
                for (Booking book : bookings) {
                    book.displayBookingInfo();
                }
            }

            if (userOpt == 3) {
                for (Bus bus : buses) {
                    bus.displayBusInfo();
                }
            }
            // cancel ticket
            if (userOpt == 4) {
                if (check == 0) {
                    System.out.println("Please book a ticket to cancel!");
                    System.out.println();
                    continue;
                }
                System.out.println("Enter Bus No");
                int busdelNo = in.nextInt();
                int buscheck = 0;
                for (Bus bs : buses) {
                    if (bs.getBusNo() == busdelNo) {
                        buscheck = 1;
                    }
                }
                if (buscheck == 0) {
                    System.out.println("Invalid Bus No, Please try again!");
                }
                for (Bus bus : buses) {
                    if (bus.getBusNo() == busdelNo) {
                        int cap = bus.getCapacity();
                        bus.setCapacity(++cap);
                        break;
                    }
                }
                for (Booking book : bookings) {
                    if (book.busNo == busdelNo) {
                        bookings.remove(busdelNo - 1);
                        System.out.println("Ticket cancelled Successfully!");
                        break;
                    }
                }
                // }
            }
            if (userOpt >= 4) {
                System.out.println("Invalid input!");
                System.out.println("Try again!");
                System.out.println();
            }
        }
    }
}