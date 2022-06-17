import java.util.*;

//far --->Farmer
//ret --->Retailer
class farmer {
    int farID;
    String farName;
    String farLocation;
    long farContact;

    farmer(int farID, String farName, String farLocation, long farContact) {
        this.farID = farID;
        this.farName = farName;
        this.farLocation = farLocation;
        this.farContact = farContact;
    }

    void displayFarmerDetails() {
        System.out.println(farID + "        " + farName + "         " + farLocation + "         " + farContact);
    }

}

class retailer {
    int retID;
    String retName;
    String retAddress;
    int retContact;
    int retDistance;

    retailer(int retID, String retName, String retAddress, int retContact, int retDistance) {
        this.retID = retID;
        this.retName = retName;
        this.retAddress = retAddress;
        this.retContact = retContact;
        this.retDistance = retDistance;
    }

    void displayRetailerDetails() {
        System.out.println(
                retID + "      " + retName + "     " + retAddress + "      " + retContact + "      " + retDistance);
    }
}

class cropsavailable {
    int cropID;
    String cropName;
    int cropfreshness;
    String cropLocation;
    int farmerID;

    cropsavailable(int cropID, String cropName, int cropfreshness, String cropLocation, int farmerID) {
        this.cropID = cropID;
        this.cropName = cropName;
        this.cropfreshness = cropfreshness;
        this.cropLocation = cropLocation;
        this.farmerID = farmerID;
    }

    void printCropDetails() {
        System.out.println(cropID + "     " + cropName + "       " + cropfreshness + "        " + cropLocation
                + "        " + farmerID);
    }
}

class bidding {
    int bidID;
    int bidValidity;
    String bidName;
    int openingPrice;
    int closingPrice;

    bidding(int bidID, int bidValidity, String bidName, int openingPrice, int closingPrice) {
        this.bidID = bidID;
        this.bidValidity = bidValidity;
        this.bidName = bidName;
        this.openingPrice = openingPrice;
        this.closingPrice = closingPrice;
    }

    void printBidDetails() {
        System.out.println(
                bidID + "      " + bidValidity + "     " + bidName + "     " + openingPrice + "    " + closingPrice);
    }
}

class bidRetailer {
    int bidID;
    int hisprice;
    String cropName;
    int farmerID;
    int cropID;
    int retID;

    bidRetailer(int bidID, int hisprice, String cropName, int farmerID, int cropID, int retID) {
        this.bidID = bidID;
        this.hisprice = hisprice;
        this.cropName = cropName;
        this.farmerID = farmerID;
        this.cropID = cropID;
        this.retID = retID;
    }

    void printBidRetDetails() {
        System.out
                .println(bidID + "      " + hisprice + "       " + cropName + "     " + farmerID + "       " + cropID
                        + "     " + retID);
    }
}

class transcationHistory {
    int transID;
    int retID;
    int biddedPrice;
    int farmerID;

    transcationHistory(int transID, int retID, int biddedPrice, int farmerID) {
        this.transID = transID;
        this.retID = retID;
        this.biddedPrice = biddedPrice;
        this.farmerID = farmerID;
    }

    void printTranscationDetails() {
        System.out.println(transID + "        " + retID + "       " + biddedPrice + "     " + farmerID);
    }

}

class farmerRetailDistribution {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<farmer> farList = new ArrayList<>();
        List<retailer> retList = new ArrayList<>();
        List<cropsavailable> cropList = new ArrayList<>();
        List<bidding> bidAvailableList = new ArrayList<>();
        List<bidRetailer> bidRetailerList = new ArrayList<>();
        List<transcationHistory> transList = new ArrayList<>();

        // adding data to farmer list
        farList.add(new farmer(1, "Daya", "Madurai", 790400959));
        farList.add(new farmer(2, "Siva", "Chennai", 789654123));
        farList.add(new farmer(3, "Shobana", "trivandrum", 701005963));
        farList.add(new farmer(4, "Hari", "Madurai", 984325365));
        farList.add(new farmer(5, "Anand", "Madurai", 596531147));

        // adding data to retailer list
        retList.add(new retailer(1, "kumaresh", "Madurai", 789221452, 5));
        retList.add(new retailer(2, "Abijith", "Bangalore", 89562147, 15));
        retList.add(new retailer(3, "Eniyan", "Cuddlore", 596523148, 24));
        retList.add(new retailer(4, "Tarun", "Coibatore", 59654781, 60));
        retList.add(new retailer(5, "Manoj", "Karaikudi", 329856417, 45));

        // adding data to crop list
        cropList.add(new cropsavailable(1, "Carrot", 5, "Madurai", 1));
        cropList.add(new cropsavailable(2, "Beetroot", 6, "Chennai", 2));
        cropList.add(new cropsavailable(3, "Paddy", 20, "Madurai", 3));

        // adding data to bid Available List
        bidAvailableList.add(new bidding(1, 2, "March Bid", 500, 1000));
        bidAvailableList.add(new bidding(2, 3, "April Bid", 1000, 2000));
        bidAvailableList.add(new bidding(3, 4, "June Bid", 1200, 4000));

        // adding data to bid Retailer List
        bidRetailerList.add(new bidRetailer(1, 600, "Carrot", 1, 1, 1));
        bidRetailerList.add(new bidRetailer(2, 800, "Carrot", 1, 1, 2));
        bidRetailerList.add(new bidRetailer(3, 950, "Carrot", 1, 1, 3));

        while (true) {
            System.out.println();
            System.out.println("Welcome to Farmer Retail Distribution");
            System.out.println("Enter ur choice");
            System.out.println(
                    "1.Farmer\n2.Retailer\n3.Display Farmer Details\n4.Display Retailer Details\n5.Crops Available for Bidding\n6.Show Bidding\n7.Show Retailer Bidding\n8.Start Bidding\n9.Transaction Details\n10.Search Transcation");
            int userChoice = in.nextInt();

            if (userChoice == 1) {

            } else if (userChoice == 2) {

            } else if (userChoice == 3) {
                System.out.println("FarmerID    FarmerName      Farmer Location     Farmer Contact");
                for (farmer far : farList) {
                    far.displayFarmerDetails();
                }
                System.out.println();
            } else if (userChoice == 4) {
                System.out.println(
                        "RetailerID      RetailerName        RetailerAddress     RetailerContact     Retailer Distance");
                for (retailer ret : retList) {
                    ret.displayRetailerDetails();
                }
                System.out.println();
            } else if (userChoice == 5) {
                System.out.println("CropID      CropName        CropFreshness       CropLocation        FarmerName");
                for (cropsavailable crop : cropList) {
                    crop.printCropDetails();
                }
                System.out.println();
            } else if (userChoice == 6) {
                System.out.println("BidID       BidValidity     BidName     BasePice");
                for (bidding bid : bidAvailableList) {
                    bid.printBidDetails();
                }
                System.out.println();
            }

            else if (userChoice == 7) {
                System.out.println("Bid ID      HisPrice        CropName    FarmerID     CropID");
                for (bidRetailer bitret : bidRetailerList) {
                    bitret.printBidRetDetails();
                }
                System.out.println();
            } else if (userChoice == 8) {
                System.out.println("Started Bidding");
                int maxBid = 0;
                int retID = 0;
                int transID = 0;
                int farmerID = 0;
                for (bidRetailer bids : bidRetailerList) {
                    if (bids.hisprice > maxBid) {
                        maxBid = bids.hisprice;
                        retID = bids.retID;
                        farmerID = bids.farmerID;
                    }
                }
                transID++;
                System.out.println();
                System.out.println("BID Results");
                System.out.println("Retailer ID: " + retID);
                System.out.println("His Bid Price: " + maxBid);
                System.out.println("Farmer ID: " + farmerID);
                transList.add(new transcationHistory(transID, retID, maxBid, farmerID));

            } else if (userChoice == 9) {
                System.out.println("Transcation Details");
                System.out.println("TransactionID\tRetailerID\tBiddedPrice\tfarmerID");
                for (transcationHistory trans : transList) {
                    trans.printTranscationDetails();
                }
                System.out.println();
            } else if (userChoice == 10) {
                System.out.println("Enter the farmer ID to display his transaction");
                int farmerIdInput = in.nextInt();
                for (transcationHistory tr : transList) {
                    if (farmerIdInput == tr.farmerID) {
                        System.out.println("Transaction ID\t\t RetailerID\t\tBiddedPrice\t\tFarmerID");
                        tr.printTranscationDetails();
                    } else {
                        System.out.println("No transaction Available");
                        break;
                    }
                }
                String farmerName="";
                for(farmer far:farList){
                    if(far.farID==farmerIdInput){
                        farmerName = far.farName;
                    }
                }
                System.out.println("The name of the farmer Name: "+farmerName);
                System.out.println();

                // String RetailerrName="";
                // for(retailer ret:retList){
                //     if(ret.retID==farmerIdInput){
                //         RetailerrName = ret.retName;
                //     }
                // }
                // System.out.println("The name of the Retailer Name: "+RetailerrName);
                // System.out.println();

            } else {
                System.out.println("Please enter valid input:");
                System.out.println();
                userChoice = in.nextInt();
            }
        }
    }
}