package com.example.classVersion;

import java.io.*;
import java.util.Scanner;

public class FuelQueue extends Passenger {
    static boolean running = true; //controlling main menu
    static int defLength = 6;    //default passenger amount inn queue
    static int fVolume = 6600;   //fuel stock
    static int[] incomes = new int[5];  //array for incomes of 5 pumps
    static Scanner sc = new Scanner(System.in);

    public static void VFQ() {
        for (int i = 0; i < queues.length; i++) {
            System.out.println("PUMP " + (i + 1) + " QUEUE: ");
            System.out.printf("%n %2s  %-13s  %-13s  %-13s  %-4s%n", " ", "F.Name", "S.Name", "V.No", "F.Amount");
            for (int j = 0; j < queues[i].length; j++) { //showing queue information using getters
                if (queues[i][j] != null)
                    System.out.printf("%n %2s  %-13s  %-13s  %-13s  %-4s%n", (j + 1) + ") ", queues[i][j].getFName(), queues[i][j].getLName(), queues[i][j].getVNo(), queues[i][j].getFAmount());
            }
            System.out.println();
        }
    }

    public static void VEQ() {
        int spaces = 0;  //taking null count
        int count = 0;   //counting empty queues
        for (int j = 0; j < queues.length; j++) { //take 5 queues one by one
            for (int i = 0; i < queues[j].length; i++) {  //loop through queue
                if (queues[j][i] == null) spaces++;  //checking spaces
            }
            if (spaces == defLength) {
                System.out.println("PUMP " + (j + 1) + " QUEUE IS FULLY EMPTY."); //queues with 6 empty slots
                count++;
            } else if (spaces > 0) {
                System.out.println("PUMP " + (j + 1) + " QUEUE HAVE " + spaces + " SPACES."); //queues with empty slots less than 6
                count++;
            }
            spaces = 0; //resetting the null count for next line checking
        }
        if (count == 0)
            System.out.println("THERE IS NO EMPTY QUEUES !!");  //queues with 0 empty slots
    }

    public static void ACQ() {
        boolean addCheck = true;  //for control adding loop
        boolean another = true;   //for control add another loop
        while (addCheck) {  //giving chance to input again if input is invalid or want to add more
            try {
                int toQueueIndex = 0; //the queue has max spaces
                int maxCount = 0;  // max number of spaces
                for (int i = 0; i < queues.length; i++) {
                    int spaces = 0;  //null count for lines
                    for (int j = 0; j < queues[i].length; j++) {
                        if (queues[i][j] == null) spaces++; //counting nulls
                    }
                    if (maxCount < spaces) {  //choosing queue has max spaces
                        maxCount = spaces;  //storing max null count
                        toQueueIndex = i;   //storing eligible queue index
                    }
                }
                if (maxCount == 0) {  //if there is no spaces in queues
                    System.out.println("<== ALL PUMPS ARE FULL. REDIRECTED TO THE WAITING LIST ==> \n");
                    Waiting.addToWaitingList();

                } else {  //if there are spaces in queues
                    System.out.print("1) Enter customer's first name: ");
                    String fName = sc.next().toUpperCase();
                    System.out.print("2) Enter customer's second name: ");
                    String lName = sc.next().toUpperCase();
                    System.out.print("3) Enter vehicle No: ");
                    String vNo = sc.next().toUpperCase();
                    System.out.print("4) Enter the liters required: ");
                    int fAmount = sc.nextInt();
                    for (int i = 0; i < queues[toQueueIndex].length; i++) {
                        if (queues[toQueueIndex][i] == null) {  //find space in the queue
                            queues[toQueueIndex][i] = new FuelQueue(); //creating array object
                            queues[toQueueIndex][i].setFName(fName); //storing data with setters
                            queues[toQueueIndex][i].setLName(lName);
                            queues[toQueueIndex][i].setVNo(vNo);
                            queues[toQueueIndex][i].setFAmount(fAmount);
                            System.out.println("\n" + fName + " ADDED TO THE QUEUE " + (toQueueIndex + 1) + " SUCCESSFULLY.\n");
                            break; //adding completion
                        }
                    }
                }
                while (another) {
                    System.out.println("DO YOU WANT TO ADD ANOTHER CUSTOMER ? (Y/N)");
                    String choice = sc.next().toUpperCase();
                    if (choice.equals("N")) {
                        addCheck = false;  //stopping adding loop
                        break;  //stopping asking another input loop
                    } else if (choice.equals("Y")) {
                        break;  //stopping asking another input loop only
                    } else System.out.println("INVALID INPUT!");
                }
            } catch (Exception e) {  //catching errors
                System.out.println("INVALID INPUT. TRY AGAIN.\n ");
            }
        }
    }

    public static void RCQ() {
        FuelQueue[] nrQueue = new FuelQueue[defLength]; //temporary new array
        boolean remCheck = true; //controlling removing loop
        while (remCheck) {
            try {
                System.out.print("1) Enter the queue to remove customer:- ");
                int fromQueue = sc.nextInt();
                System.out.print("2) Enter the customer number to remove:- ");
                int remCust = sc.nextInt();
                if (queues[fromQueue-1][remCust-1]==null) {
                    System.out.println("THERE IS NO CUSTOMER IN THE PLACE YOU ENTERED! ENTER AGAIN.\n");
                    continue;
                } else {
                    for (int i = 0, nIndex = 0; i < queues[fromQueue - 1].length; i++) {  //loop through queue
                        if (i != (remCust - 1)) {  //find entered element to remove
                            nrQueue[nIndex] = queues[fromQueue - 1][i];  //replacing remains
                            nIndex++;
                        }
                    }
                    queues[fromQueue - 1] = nrQueue;  //removing temporary array
                    queues[fromQueue - 1][defLength - 1] = Waiting.waitingListToQueue(); //adding from the waiting list
                    System.out.println("REMOVED SUCCESSFULLY.\n");
                }
                while (true) {
                    System.out.println("DO YOU WANT TO REMOVE ANOTHER CUSTOMER ? (Y/N)");
                    String choice = sc.next().toUpperCase();
                    if (choice.equals("N")) {
                        remCheck = false; //stopping removing loop
                        break;  //stopping remove another loop
                    } else if (choice.equals("Y")) {
                        break;  //stopping add another loop only
                    } else System.out.println("INVALID INPUT!");
                }

            } catch (Exception e) {  //catching errors
                System.out.println("INVALID INPUT! ENTER AGAIN\n ");
            }
        }
    }

    public static void PCQ() {
        boolean serCheck = true;
        while (serCheck) {   //giving chance serve again
            try {
                System.out.println("ENTER THE QUEUE NUMBER TO SERVE CUSTOMER:- ");
                int served = sc.nextInt();
                if (queues[served - 1][0] == null) {   //check whether the queue has someone
                    System.out.println("THERE IS NO CUSTOMER TO SERVE.");
                    break;
                } else {
                    fVolume = fVolume - queues[served - 1][0].getFAmount(); //reducing served amount
                    int curIncome = queues[served - 1][0].getFAmount() * 430; //calculating income
                    incomes[served - 1] += curIncome; //collecting income
                    for (int i = 1; i < queues[served - 1].length; i++) { //loop through queue
                        queues[served - 1][i - 1] = queues[served - 1][i]; //removing served customer
                    }
                    queues[served - 1][defLength - 1] = Waiting.waitingListToQueue(); //adding from the waiting list
                    if (fVolume == 500) System.out.println("""                         
                                    
                                    !!!WARNING!!!
                            --YOU HAVE 500L ONLY IN STOCK--
                             
                            """);  //500L warning

                    System.out.println("SERVED SUCCESSFULLY.\n");
                    while (true) {
                        System.out.println("DO YOU WANT TO SERVE ANOTHER CUSTOMER ? (Y/N)");
                        String choice = sc.next().toUpperCase();
                        if (choice.equals("N")) {
                            serCheck = false;   //stopping serving loop
                            break;
                        } else if (choice.equals("Y")) {
                            break;
                        } else System.out.println("INVALID INPUT!");
                    }
                }
            } catch (Exception e) {   //catching errors
                System.out.println("INVALID INPUT! ENTER AGAIN\n ");
            }
        }
    }

    public static void VCS() {
        for (int i = 0; i < queues.length; i++) {
            for (int j = 0; j < queues[i].length; j++) {
                copies[i][j] = queues[i][j];  //assigning values to temporary arrays
                if (copies[i][j] == null) {  //if any null found
                    copies[i][j] = new FuelQueue(); //creating object
                    copies[i][j].setFName("zzzz");  //replacing null with high ASCII value characters
                }
            }
            for (int j = 0; j < queues[i].length; j++) {
                for (int k = j + 1; k < queues[i].length; k++) {
                    if (copies[i][j].getFName().compareTo(copies[i][k].getFName()) > 0) {  //comparing nearby elements
                        FuelQueue temp;  //temporary holder for swapping elements
                        temp = copies[i][j];  //swapping
                        copies[i][j] = copies[i][k];
                        copies[i][k] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < queues.length; i++) {
            System.out.println("\nPUMP " + (i + 1) + " QUEUE: ");
            System.out.printf("%n %2s  %-13s  %-13s  %-13s  %-4s%n", " ", "F.Name", "L.Name", "V.No", "F.Amount");
            for (int j = 0; j < queues[i].length; j++) {
                if (copies[i][j].getFName().equals("zzzz")) {
                    System.out.println();  //ignoring null elements
                } else {  //showing sorted queues
                    System.out.printf("%2d.  %-13s  %-13s  %-13s  %-4d%n", (j + 1), copies[i][j].getFName(), copies[i][j].getLName(), copies[i][j].getVNo(), copies[i][j].getFAmount());
                }
            }
            System.out.println();  //spacing between queues
        }
    }

    public static void SPD() {
        try {
            //creating file
            File creating = new File("Fuel+Station+Data+2.txt");
            creating.createNewFile(); //creating new file
        } catch (IOException e) {
            System.out.println("ERROR OCCURRED !!");
            e.printStackTrace();
        }
        try {
            //writing queue info
            FileWriter writing = new FileWriter("Fuel+Station+Data+2.txt");  //writing data to path
            for (int i = 0; i < queues.length; i++) {
                for (int j = 0; j < queues[i].length; j++) {
                    if (queues[i][j] == null) {
                        writing.write("null\n");  //converting nulls to string
                    } else {  //writing not nulls by getters
                        writing.write(queues[i][j].getFName() + " " + queues[i][j].getLName() + " " + queues[i][j].getVNo() + " " + queues[i][j].getFAmount() + " " + "\n");
                    }
                }
            }
            //writing fuel volume
            writing.write(Integer.toString(fVolume));
            writing.flush();  //empty buffer in the file
            writing.close();
            System.out.println("SUCCESSFULLY ADDED DATA TO THE FILE.");
        } catch (IOException e) {
            System.out.println("ERROR OCCURRED !!");
            e.printStackTrace();
        }
    }

    public static void LPD() {
        try {
            File loading = new File("Fuel+Station+Data+2.txt"); //path
            Scanner reader = new Scanner(loading);
            //load data
            for (int i = 0; i < queues.length + 1; i++) {
                for (int j = 0; j < queues.length + 1; j++) {  //+1 because make value to 6
                    if (reader.hasNextLine()) {  //check if there are lines anymore
                        String data = reader.nextLine();
                        if (data.equals("null")) queues[i][j] = null;  //reconverting nulls
                        else if (i == queues.length)
                            fVolume = Integer.parseInt(data);  //setting fuel stock as int
                        else {
                            String[] dataset = data.split(" "); //entering data divided bn space
                            queues[i][j] = new FuelQueue();  //creating object
                            queues[i][j].setFName(dataset[0]);  //set passenger data with setters
                            queues[i][j].setLName(dataset[1]);
                            queues[i][j].setVNo(dataset[2]);
                            queues[i][j].setFAmount(Integer.parseInt(dataset[3]));
                        }
                    }
                }
            }
            reader.close();
            System.out.println("PROGRAM DATA LOADED SUCCESSFULLY FROM THE FILE.");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR OCCURRED");
            e.printStackTrace();
        }
    }

    public static void STK() {
        System.out.println("Remaining fuel stock:- " + fVolume + " L");
    }

    public static void AFS() {
        int canAdd = 6600 - fVolume; //addable amount
        while (true) {
            System.out.println("You can add " + (canAdd) + " more Liters to the stock.");
            System.out.println("Enter amount in Liters to add:- ");
            int addFuel = sc.nextInt();
            if (addFuel <= canAdd) {  //check eligibility
                fVolume += addFuel;  //adding amount
                System.out.println("New fuel stock is:- " + fVolume + " L");
                break;
            } else {
                System.out.println("Not enough space!! Enter possible amount.");
            }
        }
    }

    public static void IFQ() {
        for (int i=0; i< incomes.length; i++) {
            System.out.println("PUMP " + (i + 1) + " INCOME: " + incomes[i]);
        }
    }      //showing each pump's income

    public static void EXT() {
        System.out.println("""
                                 =======================================================
                                 | THANK YOU FOR BEING WITH US ------------ COME AGAIN |
                                 =======================================================
                """);
        running = false; //stopping main menu looping
    }

    public static void DEF() {
        System.out.println("OPERATION DOS NOT EXIST! PLEASE ENTER AGAIN.\n ");
    }  //if inputted menu operation invalid

    /*static void lol(){
        String userName =  "DINETH";
        String s_name = "SADEEPA";
        String v_num = "GW9499";
        int num_Liters = 20;
        for (int j = 0; j < queues.length; j++) {
            for (int i = 0; i < queues[j].length; i++) {
                if (queues[j][i] == null) {
                    queues[j][i] = new FuelQueue();
                    queues[j][i].setFName(userName);
                    queues[j][i].setLName(s_name);
                    queues[j][i].setVNo(v_num);
                    queues[j][i].setFAmount(num_Liters);

                }
            }
        }
    }*/
}

