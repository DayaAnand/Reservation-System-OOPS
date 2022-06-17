import java.util.*;

class MoneyDenominatinon {
    int denomination;
    int number;
    int value;

    MoneyDenominatinon(int denomination, int number, int value) {
        this.denomination = denomination;
        this.number = number;
        this.value = value;
    }

    void displayMoneyDenomination() {
        System.out.println(denomination + "                   " + number + "       " + value);
    }
}

class CustomerDetails {
    int accNo;
    String accHolder;
    int pinNumber;
    int accBalance;

    CustomerDetails(int accNo, String accHolder, int pinNumber, int accBalance) {
        this.accNo = accNo;
        this.accHolder = accHolder;
        this.pinNumber = pinNumber;
        this.accBalance = accBalance;
    }

    void printCustDetails() {
        System.out.println(accNo + "      " + accHolder + "       " + pinNumber + "       " + accBalance);
    }

}

class atmMachine {
    public static void main(String[] args) {
        List<MoneyDenominatinon> denoList = new ArrayList<>();
        List<CustomerDetails> custList = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        denoList.add(new MoneyDenominatinon(2000, 20, 40000));
        denoList.add(new MoneyDenominatinon(500, 100, 50000));
        denoList.add(new MoneyDenominatinon(100, 100, 10000));

        custList.add(new CustomerDetails(101, "Suresh", 2343, 25234));
        custList.add(new CustomerDetails(102, "Ganseh", 5432, 34123));
        custList.add(new CustomerDetails(103, "Magesh", 7854, 26100));
        custList.add(new CustomerDetails(104, "Naresh", 2345, 80000));
        custList.add(new CustomerDetails(105, "Harish", 1907, 103400));

        while (true) {
            System.out.println("-----WELCOME TO ATM-----");
            System.out.println("Enter ur choice");
            System.out.println("1.Load Cash to ATM\n2.Show Customer Details\n3.Show ATM Operations\n4.Exit");
            int userChoice = in.nextInt();
            if (userChoice == 1) {
                System.out.println("Loaded cash into ATM");
                System.out.println("Displaying Denomination Available");
                System.out.println("Denomination        Number      Value");
                for (MoneyDenominatinon mon : denoList) {
                    mon.displayMoneyDenomination();
                }
                System.out.println();
            } else if (userChoice == 2) {
                System.out.println("Showing Customer Details");
                System.out.println("Acc No   Acc Holder   Pin No     Acc Balance");

                for (CustomerDetails cust : custList) {
                    cust.printCustDetails();
                }
            } else if (userChoice == 3) {

                while (true) {
                    System.out.println("ATM Process Available");
                    System.out.println(
                            "1.Check Balance\n2.Withdraw Money\n3.Transfer Money\n4.Check ATM Balance\n5.Customer Details\n6.Exit");
                    int procChoice = in.nextInt();

                    if (procChoice == 1) {
                        System.out.println("Enter Account Number");
                        int accNoInput = in.nextInt();
                        System.out.println("Enter PIN");
                        int pinInput = in.nextInt();
                        int pinCheck = 0;
                        int custCheck = 0;

                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == accNoInput) {
                                custCheck = 1;
                            }
                        }
                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == accNoInput && cust.pinNumber == pinInput) {
                                pinCheck = 1;
                            }
                        }

                        if (custCheck == 1 && pinCheck == 1) {
                            for (CustomerDetails cust : custList) {
                                if (cust.accNo == accNoInput && cust.pinNumber == pinInput) {
                                    System.out.println("Acc No   Acc Holder   Pin No     Acc Balance");
                                    cust.printCustDetails();
                                }
                            }
                        } else {
                            System.out.println("Please enter a valid Credentials");
                            System.out.println();
                            continue;
                        }

                        System.out.println();
                    } else if (procChoice == 2) {
                        System.out.println("Enter Amount to be Withdrawn");
                        int withdrawInput = in.nextInt();
                        // System.out.println("withdrawInput--> " + withdrawInput);
                        System.out.println("Enter Account Number");
                        int accNoInput = in.nextInt();
                        System.out.println("Enter PIN");
                        int pinInput = in.nextInt();

                        int pinCheck1 = 0;
                        int custCheck1 = 0;

                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == accNoInput) {
                                custCheck1 = 1;
                            }
                        }
                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == accNoInput && cust.pinNumber == pinInput) {
                                pinCheck1 = 1;
                            }
                        }

                        int denom = 0;
                        int remMon = 0;

                        for (MoneyDenominatinon mon : denoList) {
                            denom = mon.denomination;
                            remMon += (denom * mon.number);

                            // System.out.println("denom "+denom);
                            // System.out.println("remMon "+remMon);
                        }
                        if (withdrawInput >= remMon) {
                            System.out.println("Not enough Money in ATM Machine");
                            return;
                        }

                        if (custCheck1 == 1 && pinCheck1 == 1) {
                            if (withdrawInput <= 10000 && withdrawInput >= 100) {
                                // System.out.println("here");
                                for (CustomerDetails cust : custList) {
                                    if (cust.accBalance <= withdrawInput) {
                                        System.out.println("Account Balance is low");
                                        continue;
                                    }

                                    if (cust.accNo == accNoInput && cust.pinNumber == pinInput) {
                                        cust.accBalance -= withdrawInput;
                                        System.out.println("Acc No   Acc Holder   Pin No     Acc Balance");
                                        cust.printCustDetails();
                                        int debited = 0;
                                        int amountWanted = withdrawInput;

                                        System.out.println("debited  " + debited);
                                        System.out.println("amountWanted " + amountWanted);

                                        if (withdrawInput <= 5000) {
                                            if (withdrawInput >= 3000) {
                                                for (MoneyDenominatinon deno : denoList) {
                                                    if (deno.denomination == 2000) {
                                                        deno.value -= 2000;
                                                        deno.number -= 1;

                                                        debited += 2000;
                                                        amountWanted -= 2000;
                                                    }
                                                }
                                            }

                                            System.out.println("debited  " + debited);
                                            System.out.println("amountWanted " + amountWanted);

                                            while (amountWanted > 1000) {
                                                if (amountWanted >= 1000) {
                                                    for (MoneyDenominatinon deno : denoList) {
                                                        if (deno.denomination == 500) {
                                                            deno.value -= 500;
                                                            deno.number -= 1;

                                                            debited += 500;
                                                            amountWanted -= 500;
                                                        }

                                                    }
                                                }
                                            }

                                            System.out.println("debited  " + debited);
                                            System.out.println("amountWanted " + amountWanted);

                                            while (amountWanted > 100) {
                                                if (withdrawInput >= 1500) {
                                                    // System.out.println("here");
                                                    for (MoneyDenominatinon deno : denoList) {
                                                        // System.out.println("for in");
                                                        int towith = amountWanted / 100;
                                                        int toVal = towith * 100;
                                                        // System.out.println("towith " + towith);
                                                        // System.out.println("toVal " + toVal);

                                                        if (deno.denomination == 100) {
                                                            deno.value -= toVal;
                                                            deno.number -= towith;

                                                            debited += toVal;
                                                            amountWanted -= toVal;
                                                        }

                                                    }
                                                }

                                                if (withdrawInput <= 1500) {
                                                    for (MoneyDenominatinon deno : denoList) {
                                                        // System.out.println("this here");
                                                        int towith = amountWanted / 100;
                                                        int toVal = towith * 100;

                                                        // System.out.println("towith " + towith);
                                                        // System.out.println("toVal " + toVal);

                                                        if (deno.denomination == 100) {
                                                            deno.value -= toVal;
                                                            deno.number -= towith;

                                                            debited += toVal;
                                                            amountWanted -= toVal;
                                                        }
                                                    }
                                                }
                                            }

                                            System.out.println("debited  " + debited);
                                            System.out.println("amountWanted " + amountWanted);

                                        } else if (withdrawInput > 5000) {
                                            int debited5000 = 0;
                                            int amountWanted5000 = withdrawInput;
                                            for (MoneyDenominatinon deno : denoList) {
                                                if (deno.denomination == 2000) {
                                                    deno.value -= 4000;
                                                    deno.number -= 2;

                                                    debited5000 += 4000;
                                                    amountWanted5000 -= 4000;

                                                    System.out.println("debited  " + debited5000);
                                                    System.out.println("amountWanted " + amountWanted5000);

                                                }
                                                if (deno.denomination == 500 && amountWanted5000 >= 1000) {

                                                    int towith2 = amountWanted5000 / 500;
                                                    int toVal2 = towith2 * 500;

                                                    deno.value -= toVal2;
                                                    deno.number -= towith2;

                                                    debited5000 += toVal2;
                                                    amountWanted5000 -= toVal2;

                                                    System.out.println("debited  " + debited5000);
                                                    System.out.println("amountWanted " + amountWanted5000);

                                                }
                                                if (deno.denomination == 100) {

                                                    int towith1 = amountWanted5000 / 100;
                                                    int toVal1 = towith1 * 100;

                                                    System.out.println("towith1 " + towith1);
                                                    System.out.println("towith1 " + toVal1);
                                                    deno.value -= toVal1;
                                                    deno.number -= towith1;

                                                    debited5000 += toVal1;
                                                    amountWanted5000 -= toVal1;

                                                    System.out.println("debited  " + debited5000);
                                                    System.out.println("amountWanted " + amountWanted5000);

                                                }
                                            }
                                        }
                                    }
                                }
                                System.out.println();
                            } else {
                                System.out.println(
                                        "Maximum Withdrawal limit for Single Transaction is Rs.10000/- and Minimum is 100");
                                System.out.println();
                                continue;
                            }
                        } else {
                            System.out.println("Please enter Valid Credentials!");
                            System.out.println();
                            continue;
                        }

                    }

                    else if (procChoice == 3) {
                        System.out.println("Enter your Account number");
                        int yourAcc = in.nextInt();
                        System.out.println("Enter your PIN");
                        int yourPin = in.nextInt();
                        System.out.println("Enter Transfer Account Number");
                        int transAcc = in.nextInt();
                        System.out.println("Enter Amount to be transferred");
                        int transAmount = in.nextInt();

                        if (transAmount > 10000 || transAmount < 100) {
                            System.out.println("Max transfer limit is 10000 and minimum is 100");
                            System.out.println();
                            continue;
                        }

                        int custCheck2 = 0;
                        int pinCheck2 = 0;
                        int transAccCheck = 0;

                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == yourAcc) {
                                custCheck2 = 1;
                            }
                            if (cust.accNo == transAcc) {
                                transAccCheck = 1;
                            }
                        }
                        for (CustomerDetails cust : custList) {
                            if (cust.accNo == yourAcc && cust.pinNumber == yourPin) {
                                pinCheck2 = 1;
                            }
                        }

                        if (custCheck2 == 1 && pinCheck2 == 1 && transAccCheck == 1) {
                            for (CustomerDetails cust : custList) {

                                if(cust.accBalance<transAmount){
                                    System.out.println("No sufficient balance in your account!");
                                    System.out.println();
                                    continue;
                                }

                                if (cust.accNo == yourAcc && cust.pinNumber == yourPin) {
                                    cust.accBalance -= transAmount;
                                }
                                if (cust.accNo == transAcc) {
                                    cust.accBalance += transAmount;
                                }
                            }
                            System.out.println("Money Successfully Transferred!!");
                        } else {
                            System.out.println("Please enter valid credentials!");
                            System.out.println();
                            continue;
                        }

                    }

                    else if (procChoice == 4) {
                        System.out.println("ATM Balance");
                        int denom = 0;
                        int remMon = 0;

                        for (MoneyDenominatinon mon : denoList) {
                            denom = mon.denomination;
                            remMon += (denom * mon.number);

                            // System.out.println("denom "+denom);
                            // System.out.println("remMon "+remMon);
                        }
                        System.out.println("Total Amount available in the ATM: " + remMon);
                    } else if (procChoice == 5) {
                        System.out.println("Showing Customer Details");
                        System.out.println("Acc No   Acc Holder   Pin No     Acc Balance");
                        for (CustomerDetails cust : custList) {
                            cust.printCustDetails();
                        }
                    }

                    else if (procChoice == 6) {
                        break;
                    } else {
                        System.out.println("Please enter a valid Choice");
                        System.out.println();
                        continue;
                    }
                }
            } else if (userChoice == 4) {
                break;
            } else {
                System.out.println("Please enter a valid Choice");
                System.out.println();
                continue;
            }
        }
    }
}