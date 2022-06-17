import java.util.*;

class employee {
    String name;
    int age;
    String department;
    String designation;
    String reportingTo;

    employee(String name, int age, String department, String designation, String reportingTo) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.designation = designation;
        this.reportingTo = reportingTo;

    }

    void printEmployeeDetails() {
        // System.out.println("Name Age Department Designation Reporting To");

        // System.out.println(this.name + "\t\t\t\t" + this.age + "\t\t\t" +
        // this.department + " " + this.designation
        // + " " + this.reportingTo);

        System.out.printf("%s \t\t\t\t%d \t\t\t\t%s \t\t\t\t  %s\t\t\t\t  %s\t\t\t\t \n", name, age, department,
                designation, reportingTo);

    }
}

class EmployeeDatabase {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<employee> empList = new ArrayList<>();

        while (true) {
            System.out.println(
                    "0.Insert Data\n1.Show all Records\n2.Search Records\n3.Manger Reports\n4.Summary Report\n5.Tree Hierarchy\n6.Exit");
            int choice = in.nextInt();
            System.out.println();

            if (choice == 0) {
                // System.out.println("Name\t\t\tAge\t\tDepartment Designation Reporting To");

                empList.add(new employee("Sriram", 45, "Management", "CEO", "--"));
                empList.add(new employee("Mukund", 42, "HR", "HR Manager", "Sriram"));
                empList.add(new employee("Sebastian", 38, "Finance", "Finance Manager", "Sriram"));
                empList.add(new employee("Aashritha", 32, "Product Management", "Dev Manager", "Sriram"));
                empList.add(new employee("Mohammad Rafi", 35, "HR", "HR Lead", "Mukund"));
                empList.add(new employee("Anjali Kumar", 29, "HR", "HR Associate", "Mohammad Rafi"));
                empList.add(new employee("Jospeh", 40, "Finance", "Finance Associate", "Sebastian"));
                empList.add(new employee("Ramachandran", 27, "Product Development", "Tech Lead", "Aashritha"));
                empList.add(new employee("Abhinaya Shankar", 23, "Product Development", "System Developer",
                        "Ramachandran"));
                empList.add(new employee("Imran Khan", 28, "Product Testing", "QA Lead", "Ramachandran"));

                System.out.println("Succesfully inserted data!!");
                System.out.println();

            }

            else if (choice == 1) {
                System.out.println(
                        "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                for (employee emp : empList) {
                    emp.printEmployeeDetails();
                }
                System.out.println();
            } else if (choice == 2) {
                if (empList.size() == 0) {
                    System.out.println("No data in the list,Please Insert data");
                }
                while (true) {

                    System.out.println("Do you want to for String or Integer");
                    String strInt = in.next().toLowerCase();

                    if ((!strInt.equals("string")) && (!strInt.equals("integer"))) {
                        System.out.println("Please enter either string or integer!");
                        System.out.println();
                    }

                    if (strInt.equals("string")) {
                        while (true) {
                            System.out.println(
                                    "1.Equals\n2.Not Equals\n3.StartsWith\n4.EndWith\n5.Contains\n6.Not Contains\n7.Exit this loop");
                            int strChoice = in.nextInt();
                            System.out.println("Your choice is " + strChoice);

                            if (strChoice == 1) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();
                                    in.nextLine();

                                    if (!search.equals("name") && !search.equals("department")
                                            && !search.equals("designation") && !search.equals("reportingto")) {
                                        System.out.println("Please enter a valid search field!");
                                        System.out.println();
                                        continue;
                                    }

                                    // name search
                                    System.out.println("Enter the " + search + " to search for: ");
                                    String givenSearch = in.nextLine();
                                    // System.out.println("input data--> " + givenSearch);

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.name.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.department.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            // System.out.println("for in");
                                            if (emps.designation.equals(givenSearch)) {
                                                // System.out.println("if in");

                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.reportingTo.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                }

                            } else if (strChoice == 2) {
                                while (true) {
                                    // System.out.println("working man");
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    // name search
                                    System.out.println("Enter the " + search + " to search for");
                                    String givenSearch = in.next();

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.name.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.department.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.designation.equals(givenSearch)) {
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.reportingTo.equals(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            }

                            else if (strChoice == 3) {
                                while (true) {
                                    // System.out.println("why not here??");
                                    // System.out.println("new one");
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    // name search
                                    System.out.println("Enter the " + search + " to search for");
                                    String givenSearch = in.next();

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.name.startsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.department.startsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.designation.startsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.reportingTo.startsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            }
                            // endsWith
                            else if (strChoice == 4) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    // name search
                                    System.out.println("Enter the " + search + " to search for");
                                    String givenSearch = in.next();

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.name.endsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.department.endsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.designation.endsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.reportingTo.endsWith(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            }
                            // Contains
                            else if (strChoice == 5) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    // name search
                                    System.out.println("Enter the " + search + " to search for");
                                    String givenSearch = in.next();

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.name.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.department.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.designation.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.reportingTo.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            }
                            // not contains
                            else if (strChoice == 6) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("--->name,   department,     designation,    reportingto");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    // name search
                                    System.out.println("Enter the " + search + " to search for");
                                    String givenSearch = in.next();

                                    if (search.equals("name")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.name.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for Department search
                                    if (search.equals("department")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.department.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                    // for designation
                                    if (search.equals("designation")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.designation.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }

                                    // for Reporting to
                                    if (search.equals("reportingto")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (!emps.reportingTo.contains(givenSearch)) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }

                        }

                    } else if (strInt.equals("integer")) {
                        while (true) {

                            System.out.println(
                                    "1.Equals\n2.Not Equals\n3.Greater than\n4.Less than\n5.Exit this loop");
                            int intChoice = in.nextInt();
                            System.out.println("Your choice is " + intChoice);

                            if (intChoice == 1) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("-->age");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    System.out.println("Enter the attribute " + search + " to search for");
                                    int givenSearch = in.nextInt();

                                    if (search.equals("age")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.age == givenSearch) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            } else if (intChoice == 2) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("-->age");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    System.out.println("Enter the attribute " + search + " to search for");
                                    int givenSearch = in.nextInt();

                                    if (search.equals("age")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.age != givenSearch) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            } else if (intChoice == 3) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("-->age");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    System.out.println("Enter the attribute " + search + " to search for");
                                    int givenSearch = in.nextInt();

                                    if (search.equals("age")) {
                                        System.out.println(
                                                "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                        for (employee emps : empList) {
                                            if (emps.age > givenSearch) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            } else if (intChoice == 4) {
                                while (true) {
                                    System.out.println("The search fields available are: ");
                                    System.out.println("-->age");
                                    System.out.println("Enter the search field");
                                    String search = in.next().toLowerCase();

                                    System.out.println("Enter the attribute " + search + " to search for");
                                    int givenSearch = in.nextInt();

                                    if (search.equals("age")) {
                                        for (employee emps : empList) {
                                            System.out.println(
                                                    "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                                            if (emps.age < givenSearch) {
                                                // System.out.println(
                                                // "Name\t\t\tAge\t\tDepartment Designation Reporting To");
                                                emps.printEmployeeDetails();
                                            }
                                        }
                                    }
                                }
                            } else {
                                break;
                            }

                        }
                    }

                }

            } else if (choice == 3) {
                System.out.println("Enter Manager Name");
                String managerinput = in.next();
                System.out.println(
                        "Name\t\t\tAge\t\tDepartment      Designation     Reporting To");
                for (employee ee : empList) {
                    if (ee.reportingTo.equals(managerinput)) {
                        ee.printEmployeeDetails();
                    }
                }
            }

            else if (choice == 4) {
                while (true) {
                    System.out.println("1.Department Summary \n2.Designation Summary\n3.Mangers Summary\n4.Exit");
                    System.out.println();
                    int summaryInput = in.nextInt();

                    if (summaryInput == 1) {
                        System.out.println("You have selected Department Summary");

                        if (empList.size() == 0) {
                            System.out.println("Please insert data to generate summary!");
                            System.out.println("Exiting....");
                            return;
                        }

                        int managementCount = 0;
                        int hrCount = 0;
                        int financeCount = 0;
                        int prodManagement = 0;
                        int prodDevelopment = 0;
                        int prodTesting = 0;

                        for (employee emp : empList) {
                            if (emp.department.equals("Management")) {
                                managementCount++;
                            }
                            if (emp.department.equals("HR")) {
                                hrCount++;
                            }
                            if (emp.department.equals("Finance")) {
                                financeCount++;
                            }
                            if (emp.department.equals("Product Management")) {
                                prodManagement++;
                            }

                            if (emp.department.equals("Product Development")) {
                                prodDevelopment++;
                            }
                            if (emp.department.equals("Product Testing")) {
                                prodTesting++;
                            }
                        }
                        System.out.println("Management              " + managementCount);
                        System.out.println("HR                      " + hrCount);
                        System.out.println("Finance                 " + financeCount);
                        System.out.println("Product Mangement       " + prodManagement);
                        System.out.println("Product Development     " + prodDevelopment);
                        System.out.println("Product Testing         " + prodTesting);

                    }

                    else if (summaryInput == 2) {
                        System.out.println("You have selected Designation Summary");

                        if (empList.size() == 0) {
                            System.out.println("Please insert data to generate summary!");
                            System.out.println("Exiting....");
                            return;
                        }

                        int CEOCount = 0;
                        int hrManCount = 0;
                        int finManCount = 0;
                        int devManager = 0;
                        int HRLead = 0;
                        int HRAssocaite = 0;
                        int finAssCount = 0;
                        int techLeadCount = 0;
                        int sysDevCount = 0;
                        int QAleadCount = 0;

                        for (employee emp : empList) {
                            if (emp.designation.equals("CEO")) {
                                CEOCount++;
                            }
                            if (emp.designation.equals("HR Manager")) {
                                hrManCount++;
                            }
                            if (emp.designation.equals("Finance Manager")) {
                                finManCount++;
                            }
                            if (emp.designation.equals("Dev Manger")) {
                                devManager++;
                            }
                            if (emp.designation.equals("HR Lead")) {
                                HRLead++;
                            }
                            if (emp.designation.equals("HR Associate")) {
                                HRAssocaite++;
                            }
                            if (emp.designation.equals("Finance Associate")) {
                                finAssCount++;
                            }
                            if (emp.designation.equals("Tech Lead")) {
                                techLeadCount++;
                            }
                            if (emp.designation.equals("System Developer")) {
                                sysDevCount++;
                            }
                            if (emp.designation.equals("QA Lead")) {
                                QAleadCount++;
                            }
                        }
                        System.out.println("CEO                 " + CEOCount);
                        System.out.println("HR Manager          " + hrManCount);
                        System.out.println("Finance Manager     " + finManCount);
                        System.out.println("Dev Manger          " + devManager);
                        System.out.println("HR Lead             " + HRLead);
                        System.out.println("HR Associate        " + HRAssocaite);
                        System.out.println("Finance Associate   " + finAssCount);
                        System.out.println("Tech Lead           " + techLeadCount);
                        System.out.println("System Developer    " + sysDevCount);
                        System.out.println("QA Lead             " + QAleadCount);

                    } else if (summaryInput == 3) {
                        System.out.println("You have selected Manager Summary");

                        if (empList.size() == 0) {
                            System.out.println("Please insert data to generate summary!");
                            System.out.println("Exiting....");
                            return;
                        }

                        int sriramCount = 0;
                        int mukundCounmt = 0;
                        int mohammedRafiCount = 0;
                        int sebastianCount = 0;
                        int aashrithaCount = 0;
                        int ramachandranCount = 0;

                        for (employee emp : empList) {
                            if (emp.reportingTo.equals("Sriram")) {
                                sriramCount++;
                            }
                            if (emp.reportingTo.equals("Mukund")) {
                                mukundCounmt++;
                            }
                            if (emp.reportingTo.equals("Mohammad Rafi")) {
                                mohammedRafiCount++;
                            }
                            if (emp.reportingTo.equals("Sebastian")) {
                                sebastianCount++;
                            }

                            if (emp.reportingTo.equals("Aashritha")) {
                                aashrithaCount++;
                            }
                            if (emp.reportingTo.equals("Ramachandran")) {
                                ramachandranCount++;
                            }
                        }
                        System.out.println("Manger Sriram              " + sriramCount);
                        System.out.println("Manger Mukund              " + mukundCounmt);
                        System.out.println("Manager Mohammad Rafi      " + mohammedRafiCount);
                        System.out.println("Manager Sebastian          " + sebastianCount);
                        System.out.println("Manager Aashritha          " + aashrithaCount);
                        System.out.println("Manager Ramachandran       " + ramachandranCount);

                    } else if (summaryInput == 4) {
                        break;
                    } else {
                        System.out.println("Invalid input, Please try again!");
                    }
                }
            }

            else if (choice == 5) {
                while (true) {
                    in.nextLine();
                    System.out.println("Enter the Employee Name");
                    String empName = in.nextLine();

                    int empcheck = 0;

                    for (employee emp : empList) {
                        if (emp.name.equals(empName)) {
                            // System.out.println("Manger1:--> " + emp.reportingTo);
                            // man1=emp.reportingTo;
                            empcheck = 1;
                        }
                    }

                    if (empcheck == 1) {
                        String man1 = "";
                        for (employee emp : empList) {
                            if (emp.name.equals(empName)) {
                                System.out.println("Manger1:--> " + emp.reportingTo);
                                man1 = emp.reportingTo;
                            }
                        }
                        String man2 = "";
                        for (employee emp : empList) {
                            if (man1.equals(emp.name)) {
                                man2 = emp.reportingTo;
                                System.out.println("Manger2:--> " + man2);
                            }
                        }

                        String man3 = "";
                        for (employee emp : empList) {
                            if (man2.equals(emp.name)) {
                                man3 = emp.reportingTo;
                                System.out.println("Manger3:--> " + man3);
                            }
                        }

                        String man4 = "";
                        for (employee emp : empList) {
                            if (man3.equals(emp.name)) {
                                man4 = emp.reportingTo;
                                System.out.println("Manger4:--> " + man4);
                            }
                        }

                        System.out.println("-----Final Hierarchy-----");
                        int printed = 0;
                        if (man4 != "") {
                            System.out.println(empName + "--> " + man1 + "--> " + man2 + "--> " + man3 + "--> " + man4);
                            // System.out.println("111");
                            printed = 1;
                        } else if (man3 != "" && printed != 1) {
                            System.out.println(empName + "--> " + man1 + "--> " + man2 + "--> " + man3);
                            // System.out.println("222");
                            printed = 1;
                        } else if (man2 != "" && printed != 1) {
                            System.out.println(empName + "--> " + man1 + "--> " + man2);
                            printed = 1;
                            // System.out.println("333");
                        } else if (man1 != "" && printed != 1) {
                            System.out.println(empName + "--> " + man1);
                            // System.out.println("444");
                        }

                    } else {
                        System.out.println("Please enter a valid Employee Name!!!");
                        System.out.println();
                        // empName = in.nextLine();
                    }

                }

            }

            else if (choice == 6) {
                break;
            }

            else {
                System.out.println("Invalid input, Please try again!");
            }
        }
    }
}
