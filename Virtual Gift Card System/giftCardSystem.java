import java.util.*;

class customers {
    int customerID1, accountBalance1;

    customers(int customerID, int accountBalance) {
        customerID1 = customerID;
        accountBalance1 = accountBalance;
    }

    void customerDetails() {
        System.out.println("Customer ID \t Account Balance");
        System.out.println(customerID1 + "\t\t\t" + accountBalance1);
    }
}

class giftCard {
    int giftCardNo1, pin1, giftAmount1, customerID1, rewardpoints0;
    String blocks, stats, cardTypes;

    giftCard(int customerID, int giftCardNo, int pin, int giftAmount) {
        customerID1 = customerID;
        giftCardNo1 = giftCardNo;
        pin1 = pin;
        giftAmount1 = giftAmount;
        stats = "Active";
        blocks = "unblock";
        rewardpoints0 = 0;
        cardTypes="s";

    }

    void giftCardDetails() {
        if (rewardpoints0 <= 0 && cardTypes.equals("s")) {
            System.out.println("Gift Card No\t CustomerID\tPin\tBalance\tStatus\tBlock Status\tReward Points");
            System.out.println(giftCardNo1 + "\t\t\t" + customerID1 + "\t" + pin1 + "\t" + giftAmount1 + "\t" + stats
                    + "\t" + blocks + "\t" + rewardpoints0);
        } else {
            // System.out.println("here");
            System.out
                    .println("Gift Card No\tCustomerID\tPIN\tBalance\tStatus\tBlock Status\tReward Points\tCard Type");
            System.out.println(
                    giftCardNo1 + "\t\t\t" + customerID1 + "\t" + pin1 + "\t" + giftAmount1 + "\t" + stats + "\t"
                            + blocks + "\t\t" + rewardpoints0 + "\t" + cardTypes);

        }

    }
}

class transactions {
    int transactionNo1, cardNumerTx, amounttx;

    transactions(int transactionNo, int cardnumbert, int amountt) {
        transactionNo1 = transactionNo;
        cardNumerTx = cardnumbert;
        amounttx = amountt;
    }

    void transactionDetails() {
        System.out.println("Transaction No \t Gift Card No\tAmount");
        System.out.println(transactionNo1 + "\t\t" + cardNumerTx + "\t\t" + amounttx);
    }
}

public class giftCardSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        customers[] cust = new customers[5];
        giftCard[] gift = new giftCard[5];
        transactions[] trans = new transactions[5];

        int customerID = 1;
        int topUpAmount = 0;
        int giftCardNum = 1;
        int pincount = 0;
        int transactionNo = 1;

        while (true) {
            System.out.println(
                    "1.Customer Creation \n2.Create A Gift Card\n3.Top-Up Gift Card\n4.Customer Details\n5.Gift Card Details\n6.Gift Card Closing\n7.Transaction\n8.Transaction Details\n9.Block Card\n10.Exit");
            int customerChoice = input.nextInt();
            if (customerChoice == 1) {
                System.out.println("Enter the Balance for your Account");
                int accountBalance = input.nextInt();
                cust[customerID] = new customers(customerID, accountBalance);
                customerID++;
                cust[customerID - 1].customerDetails();

            } else if (customerChoice == 2) {
                int customerCheck = 0;
                System.out.println("Enter Customer Id for Gift Card Creation");
                int customerids = input.nextInt();

                for (int i = 1; i <= customerID - 1; i++) {
                    if (cust[i].customerID1 == customerids) {
                        customerCheck = 1;
                    }
                }

                if (customerCheck != 1) {
                    System.out.println("Invalid Customer!!");
                    continue;
                }

                System.out.println("Enter the PIN");
                int giftCardPin = input.nextInt();

                while (true) {
                    int pincheck = giftCardPin;
                    while (pincheck != 0) {
                        pincheck /= 10;
                        pincount++;
                    }
                    if (pincount == 4) {
                        System.out.println("Gift Card PIN created successfully!!");
                        break;
                    } else {
                        pincount = 0;
                        System.out.println("Please enter PIN in four digits");
                        giftCardPin = input.nextInt();
                        // input.nextLine();
                    }
                }
                // input.nextLine();
                System.out.println("Enter the Gift Card Amount");
                int giftCardAmount = input.nextInt();

                if (cust[customerids].accountBalance1 - giftCardAmount < 0) {
                    System.out.println("Insufficient Balance in the Account. Please TopUp!!");

                } else {
                    gift[giftCardNum] = new giftCard(customerids, giftCardNum, giftCardPin, giftCardAmount);
                    giftCardNum++;
                    System.out.println(giftCardNum);

                    cust[customerids].accountBalance1 -= giftCardAmount;
                    gift[giftCardNum - 1].giftCardDetails();
                }

            } else if (customerChoice == 3) {
                int giftcheck = 0;
                System.out.println("Enter Gift Card No");
                int gCardNO = input.nextInt();

                for (int i = 1; i <= giftCardNum - 1; i++) {
                    if (gift[i].giftCardNo1 == gCardNO) {
                        giftcheck = 1;
                    }
                }
                if (giftcheck != 1) {
                    System.out.println("Invalid Gift Card No");
                    continue;
                }

                System.out.println("Enter Top-Up Amount");
                topUpAmount = input.nextInt();

                if (cust[gift[gCardNO].customerID1].accountBalance1 - topUpAmount < 0) {
                    System.out.println("Insufficient Balance in Your Account");
                } else {
                    gift[gCardNO].giftAmount1 += topUpAmount;
                    cust[gift[gCardNO].customerID1].accountBalance1 -= topUpAmount;
                    gift[gCardNO].giftCardDetails();
                }

            } else if (customerChoice == 4) {

                for (int custo = 1; custo <= customerID; custo++) {
                    if (cust[custo] != null) {
                        cust[custo].customerDetails();
                    } else {
                        break;
                    }
                }

            } else if (customerChoice == 5) {
                for (int gi = 1; gi < giftCardNum; gi++) {
                    if (gift[gi] != null) {
                        gift[gi].giftCardDetails();
                    } else {
                        break;
                    }
                }
            } else if (customerChoice == 6) {
                int cardCloseCheck = 0;
                System.out.println("Enter the gift Card No for Deleting");
                int giftCardClosing = input.nextInt();
                System.out.println("Enter the PIN");
                int cardClosePIN = input.nextInt();

                for (int j = 1; j <= giftCardNum - 1; j++) {
                    if (gift[j].giftCardNo1 == giftCardClosing) {
                        cardCloseCheck = 1;
                    }
                }
                if (cardCloseCheck != 1) {
                    System.out.println("Invalid Gift Card Number");
                    continue;
                }

                for (int giff = 1; giff <= giftCardNum - 1; giff++) {
                    if (gift[giff] != null) {
                        if (gift[giff].giftCardNo1 == giftCardClosing && gift[giff].pin1 == cardClosePIN) {
                            cust[gift[giff].customerID1].accountBalance1 += gift[giff].giftAmount1;
                            gift[giff].giftAmount1 = 0;
                            gift[giff].stats = "closed";
                            System.out.println("Gift Card Closed Succesfully!!");
                        }
                    }
                }

            } else if (customerChoice == 7) {
                int rewardPoints;
                System.out.println("Enter the Gift Card Number");
                int cardNumTrans = input.nextInt();

                if (gift[cardNumTrans].stats.equals("closed")) {
                    System.out.println("Gift Card is Closed");
                    continue;
                }
                if (gift[cardNumTrans].blocks.equals("block")) {
                    System.out.println("Gift Card is Blocked");
                    continue;
                }
                System.out.println("Enter the Gift Card PIN");
                int gCardPIN = input.nextInt();
                System.out.println("Enter the Amount");
                int amounts = input.nextInt();

                if (gift[cardNumTrans].pin1 != gCardPIN) {
                    System.out.println("Invalid PIN");
                    continue;
                }
                if (gift[cardNumTrans].giftCardNo1 == cardNumTrans && gift[cardNumTrans].pin1 == gCardPIN) {
                    trans[transactionNo] = new transactions(transactionNo, cardNumTrans, amounts);
                    if (gift[cardNumTrans].giftAmount1 - amounts < 0) {
                        System.out.println("Insufficient Balance in Card ");
                        continue;
                    }
                    trans[transactionNo].transactionDetails();
                    gift[cardNumTrans].giftAmount1 -= amounts;
                    transactionNo++;

                }
                if (amounts >= 500) {
                    rewardPoints = 50;
                    gift[cardNumTrans].rewardpoints0 += rewardPoints;
                    gift[cardNumTrans].giftAmount1 += rewardPoints;

                    if (gift[cardNumTrans].cardTypes.equals("s")) {
                        gift[cardNumTrans].cardTypes = "Silver";
                    }
                    if (gift[cardNumTrans].rewardpoints0 >= 200 && gift[cardNumTrans].cardTypes.equals("Silver")) {
                        gift[cardNumTrans].cardTypes = "Gold";
                        gift[cardNumTrans].rewardpoints0 = 0;
                    }
                    if (gift[cardNumTrans].rewardpoints0 >= 400 && gift[cardNumTrans].cardTypes.equals("Gold")) {
                        gift[cardNumTrans].cardTypes = "Plantinum";
                        gift[cardNumTrans].rewardpoints0 = 0;
                    }
                }

            } else if (customerChoice == 8) {
                for (int detail = 1; detail <= transactionNo - 1; detail++) {
                    trans[detail].transactionDetails();
                }
            }

            else if (customerChoice == 9) {
                int blockCheck = 0;
                System.out.println("Enter 1 to block or 2 to Unblock");
                int blockinput = input.nextInt();

                if (blockinput == 2) {
                    System.out.println("Enter the Card No to be unblocked");
                    int unblockinput = input.nextInt();
                    for (int js = 1; js < giftCardNum; js++) {
                        if (gift[js].giftCardNo1 == unblockinput) {
                            blockCheck = 1;
                        }
                    }
                    if (blockCheck != 1) {
                        System.out.println("Invalid Card given for Unblocking");
                        continue;
                    } else {
                        System.out.println("Card Succesfully UnBlocked");
                        gift[unblockinput].blocks = "unblock";
                    }
                } else {
                    System.out.println("Enter Card No the be Blocked");
                    blockinput = input.nextInt();
                    for (int jk = 1; jk < giftCardNum; jk++) {
                        if (gift[jk].giftCardNo1 == blockinput) {
                            blockCheck = 1;
                        }
                    }
                    if (blockCheck != 1) {
                        System.out.println("Invalid Card No to be Blocked");
                        continue;
                    } else {
                        gift[blockinput].blocks = "block";
                        System.out.println("Card successfully Blocked");
                    }
                }
            } else if (customerChoice == 10) {
                break;
            }

        }
    }
}
