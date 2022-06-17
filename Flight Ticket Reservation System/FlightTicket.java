import java.util.*;

class Flight {
    // id for flight which is alloted everytime a new Flight Object is created
    static int id = 0;
    int flightID;
    // Amdvailabel number of tickets currently in flight
    int tickets;
    // current price
    int price;
    // string list of all passenger details for printing
    ArrayList<String> passengerDetails;
    // list of all passenger IDs
    ArrayList<Integer> passengerIDs;
    // list of number of tickets booked by every passenger ID
    ArrayList<Integer> bookedTicketsPerPassenger;
    // list of cost paid by every passenger ID, used to calculate refund while
    // cancelling
    ArrayList<Integer> passengerCost;

    // constructor to set values
    public Flight() {
        tickets = 50;
        price = 5000;
        id = id + 1;
        flightID = id;
        passengerDetails = new ArrayList<String>();
        passengerIDs = new ArrayList<Integer>();
        bookedTicketsPerPassenger = new ArrayList<Integer>();
        passengerCost = new ArrayList<Integer>();
    }

    // add passenger details to flight
    public void addPassengerDetails(String passengerDetail, int numberOfTickets, int passengerID) {
        passengerDetails.add(passengerDetail);
        passengerIDs.add(passengerID);
        passengerCost.add(price * numberOfTickets);

        // updating price using logic in the problem statement
        price += 200 * numberOfTickets;

        // updating available number of tickets
        tickets -= numberOfTickets;
        bookedTicketsPerPassenger.add(numberOfTickets);
        System.out.println("Booked Successfully!");

    }

    // cancel tickets booked by a passenger ID
    public void cancelTicket(int passengerID) {
        // find the index to remove from all lists
        int indexToRemove = passengerIDs.indexOf(passengerID);
        if (indexToRemove < 0) {
            System.out.println("Passenger ID not found!");
            return;
        }
        int ticketsToCancel = bookedTicketsPerPassenger.get(indexToRemove);

        // increase number of available tickets
        tickets += ticketsToCancel;
        // change price to new value after cancellation
        price -= 200 * ticketsToCancel;

        // calculate refund
        System.out.println("Refund Amount after cancel : " + passengerCost.get(indexToRemove));

        // remove details of passenger from all lists
        bookedTicketsPerPassenger.remove(indexToRemove);
        passengerIDs.remove(Integer.valueOf(passengerID));
        passengerDetails.remove(indexToRemove);
        passengerCost.remove(indexToRemove);

        System.out.println("Cancelled Booked Tickets Successfully!");

    }

    // functions to print details about flights and passengers
    public void flightSummary() {
        System.out.println("Flight ID " + flightID + " --" + "Remaining Tickets " + tickets + " --" +
                "Current Ticket Price " + price);
    }

    public void printDetails() {
        System.out.println("Flight ID " + flightID + "->");
        for (String detail : passengerDetails)
            System.out.println(detail);
    }

}

class FlightTicket {
    // function to book tickets in flight
    public static void book(Flight currentFlight, int tickets, int passengerID) {
        String passengerDetail = "";
        // create detail about the passenger with the ID
        passengerDetail = "Passenger ID " + passengerID + " -- " + " Number of Tickets Booked "
                + tickets + " -- " + "Total cost " + currentFlight.price * tickets;
        // add passenger detail to flight object
        currentFlight.addPassengerDetails(passengerDetail, tickets, passengerID);

        currentFlight.flightSummary();
        currentFlight.printDetails();

    }

    // function to cancel the booked tickets by the particular passenger
    public static void cancel(Flight currentFlight, int passengerID) {
        // calling cancel function on the flight object
        currentFlight.cancelTicket(passengerID);
        currentFlight.flightSummary();
        currentFlight.printDetails();
    }

    // function to print flightdetails
    public static void print(Flight f) {
        f.printDetails();
    }

    public static void main(String[] args) {
        // create 2 flights for now with id 1 and 2
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 2; i++)
            flights.add(new Flight());

        // unique ID for passenger allotted during every booking
        int passengerID = 1;

        // get choice from user
        while (true) {
            System.out.println("1. Book 2. Cancel 3. Print");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            // based on choice call different functions
            switch (choice) {
                // book
                case 1: {
                    System.out.println("Enter Flight ID");
                    int fid = sc.nextInt();

                    // check if flight id is valid
                    if (fid > flights.size()) {
                        System.out.println("Invalid flight ID");
                        break;
                    }
                    // find the corresponding flight
                    Flight currentFlight = null;
                    for (Flight f : flights) {
                        if (f.flightID == fid) {
                            currentFlight = f;
                            f.flightSummary();
                            break;
                        }
                    }

                    System.out.println("Enter number of tickets");
                    int t = sc.nextInt();

                    // check if availabilty is there
                    if (t > currentFlight.tickets) {
                        System.out.println("Not Enough Tckets");
                        break;
                    }
                    // call book function to book tickets
                    book(currentFlight, t, passengerID);

                    // increment passenger ID so that next booking will have different passenger ID
                    // value
                    passengerID = passengerID + 1;
                    break;
                }
                // cancel
                case 2: {
                    System.out.println("Enter flight ID and passenger ID to cancel booking");
                    int fid = sc.nextInt();

                    // check if flight id is valid
                    if (fid > flights.size()) {
                        System.out.println("Invalid flight ID");
                        break;
                    }
                    // find the corresponding flight
                    Flight currentFlight = null;
                    for (Flight f : flights) {
                        if (f.flightID == fid) {
                            currentFlight = f;
                            break;
                        }
                    }
                    // get passengerID from passenger to find the booking
                    int id = sc.nextInt();

                    // call the cancel Booking
                    cancel(currentFlight, id);
                    break;
                }
                // print details of flight along with passenger details
                case 3: {
                    // loop though all available flights
                    for (Flight f : flights) {
                        // check if flight has atleast 1 passenger detail
                        if (f.passengerDetails.size() == 0) {
                            System.out.println("No passenger Details for  - Flight " + f.flightID);

                        } else
                            print(f);
                    }

                    break;
                }
                default: {
                    break;
                }
            }
        }

    }
}