import java.util.*;

class Taxi {

    static int taxicount = 0; // taxi number
    int id;
    boolean booked; // taxi booked or not
    char currentSpot; // where taxi is now
    int freeTime; // when taxi becomes free
    int totalEarnings; // total earnings of taxi
    List<String> trips; // all details of all trips by this taxi

    public Taxi() {
        booked = false;
        currentSpot = 'A';// start point A
        freeTime = 6;// example 6 AM
        totalEarnings = 0;
        trips = new ArrayList<String>();
        taxicount = taxicount + 1; // everytime new taxi is created a new id will be assigned
        id = taxicount;
    }

    public void setDetails(boolean booked, char currentSpot, int freeTime, int totalEarnings, String tripDetail) {
        this.booked = booked;
        this.currentSpot = currentSpot;
        this.freeTime = freeTime;
        this.totalEarnings = totalEarnings;
        this.trips.add(tripDetail);
    }

    public void printDetails() {
        // print all trips details
        System.out.println("Taxi - " + this.id + " Total Earnings - " + this.totalEarnings);
        System.out.println("TaxiID    BookingID    CustomerID    From    To    PickupTime    DropTime    Amount");
        for (String trip : trips) {
            System.out.println(id + "          " + trip);
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public void printTaxiDetails() {
        // print total earningand taxi details like current location and free time
        System.out.println("Taxi - " + this.id + " Total Earnings - " + this.totalEarnings + " Current spot - "
                + this.currentSpot + " Free Time - " + this.freeTime);
    }

}

class TaxiBooking {
    public static void bookTaxi(int customerID, char pickupPoint, char dropPoint, int pickupTime,
            List<Taxi> freeTaxis) {
        // to find nearest
        int min = 999;

        // distance between pickup and drop
        int distanceBetweenpickUpandDrop = 0;

        // this trip earning
        int earning = 0;

        // when taxi will be free next
        int nextfreeTime = 0;

        // where taxi is after trip is over
        char nextSpot = 'Z';

        // booked taxi
        Taxi bookedTaxi = null;

        // all details of current trip as string
        String tripDetail = "";

        for (Taxi t : freeTaxis) {
            int distanceBetweenCustomerAndTaxi = Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) * 15;
            if (distanceBetweenCustomerAndTaxi < min) {
                bookedTaxi = t;
                // distance between pickup and drop = (drop - pickup) * 15KM
                distanceBetweenpickUpandDrop = Math.abs((dropPoint - '0') - (pickupPoint - '0')) * 15;
                // trip earning = 100 + (distanceBetweenpickUpandDrop-5) * 10
                earning = (distanceBetweenpickUpandDrop - 5) * 10 + 100;

                // drop time calculation
                int dropTime = pickupTime + distanceBetweenpickUpandDrop / 15; //or it can also be coded as --> Math.abs((dropPoint - '0') - (pickupPoint - '0'))

                // when taxi will be free next
                nextfreeTime = dropTime;

                // taxi will be at drop point after trip
                nextSpot = dropPoint;

                // creating trip detail
                tripDetail = customerID + "               " + customerID + "          " + pickupPoint + "      "
                        + dropPoint + "       " + pickupTime + "          " + dropTime + "           " + earning;
                min = distanceBetweenCustomerAndTaxi;
            }

        }

        // setting corresponding details to allotted taxi
        bookedTaxi.setDetails(true, nextSpot, nextfreeTime, bookedTaxi.totalEarnings + earning, tripDetail);
        // BOOKED SUCCESSFULLY
        System.out.println("Taxi " + bookedTaxi.id + " booked");

    }

    public static List<Taxi> createTaxis(int n) {
        List<Taxi> taxis = new ArrayList<Taxi>();
        // create taxis
        for (int i = 1; i <= n; i++) {
            // Taxi t = new Taxi();
            taxis.add(new Taxi());
        }
        return taxis;
    }

    public static List<Taxi> getFreeTaxis(List<Taxi> taxis, int pickupTime, char pickupPoint) {
        List<Taxi> freeTaxis = new ArrayList<Taxi>();
        for (Taxi t : taxis) {
            // taxi should be free
            // taxi should have enough time to reach customer before pickuptime
            if (t.freeTime <= pickupTime
                    && (Math.abs((t.currentSpot - '0') - (pickupPoint - '0')) <= pickupTime - t.freeTime))
                freeTaxis.add(t);
        }
        return freeTaxis;
    }

    public static void main(String[] args) {

        // create 4 taxis
        List<Taxi> taxis = createTaxis(4);

        Scanner s = new Scanner(System.in);
        int id = 1;

        while (true) {
            System.out.println("0 - > Book Taxi");
            System.out.println("1 - > Print Taxi details");
            int choice = s.nextInt();
            switch (choice) {
                case 0: {
                    // get details from customers

                    // int customerID = id;
                    System.out.println("Enter Pickup point");
                    char pickupPoint = s.next().charAt(0);
                    System.out.println("Enter Drop point");
                    char dropPoint = s.next().charAt(0);
                    System.out.println("Enter Pickup time");
                    int pickupTime = s.nextInt();

                    // check if pickup and drop points are valid
                    if (pickupPoint < 'A' || dropPoint > 'F' || pickupPoint > 'F' || dropPoint < 'A') {
                        System.out.println("Valid pickup and drop are A, B, C, D, E, F. Exitting");
                        return;
                    }
                    // get all free taxis that can reach customer on or before pickup time
                    List<Taxi> freeTaxis = getFreeTaxis(taxis, pickupTime, pickupPoint);

                    // no free taxi means we cannot allot, exit!
                    if (freeTaxis.size() == 0) {
                        System.out.println("No Taxi can be alloted. Exitting");
                        return;
                    }

                    // sort taxis based on earnings
                    Collections.sort(freeTaxis, (a, b) -> a.totalEarnings - b.totalEarnings);
                    // 3,4,2 - > 2,3,4

                    // get free Taxi nearest to us
                    bookTaxi(id, pickupPoint, dropPoint, pickupTime, freeTaxis);
                    id++;
                    break;
                }
                case 1: {
                    // two functions to print details
                    for (Taxi t : taxis)
                        t.printTaxiDetails();
                    for (Taxi t : taxis)
                        t.printDetails();
                    break;
                }
                default:
                    return;
            }

        }

    }
}