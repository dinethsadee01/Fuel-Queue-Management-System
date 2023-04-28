package com.example.classVersion;

//This application created by assuming all queues are empty and fuel stock is full.
public class Main extends FuelQueue {
    public static void main(String[] args) {
        while (running) {
            System.out.println("""                 
                                     
                                     =======================================================
                                     |            -----------------------------            |
                                     |               -------WELCOME-------                 |
                                     |           \033[3mFUEL QUEUE MANAGEMENT SYSTEM\033[0m              |
                                     |       :._________________________________.:         |
                                     :                                                     :
                                     =======================================================
                                     |   100 or VFQ: View all Fuel Queues.                 |
                                     |   101 or VEQ: View all Empty Queues.                |
                                     |   102 or ACQ: Add customer to a Queue.              |
                                     |   103 or RCQ: Remove a customer from a Queue.       |
                                     |   104 or PCQ: Remove a served customer.             |
                                     |   105 or VCS: View Customers in alphabetical order. |
                                     |   106 or SPD: Store Program Data into file.         |
                                     |   107 or LPD: Load Program Data from file.          |
                                     |   108 or STK: View Remaining Fuel Stock.            |
                                     |   109 or AFS: Add Fuel Stock.                       |
                                     |   110 or IFQ: Print the income.                     |
                                     |   111 or UIF: Launch GUI.                           |
                                     |   999 or EXT: Exit the Program.                     |
                                     =======================================================
                                     
                    """);
            System.out.println("What you want to do ? ");
            String input = sc.next();

            switch (input) {
                case "100", "VFQ" -> VFQ();
                case "101", "VEQ" -> VEQ();
                case "102", "ACQ" -> ACQ();
                case "103", "RCQ" -> RCQ();
                case "104", "PCQ" -> PCQ();
                case "105", "VCQ" -> VCS();
                case "106", "SPD" -> SPD();
                case "107", "LPD" -> LPD();
                case "108", "STK" -> STK();
                case "109", "AFS" -> AFS();
                case "110", "IFQ" -> IFQ();
                case "111", "UIF" -> launch();
                case "999", "EXT" -> EXT();
                //case "120" -> lol();
                default -> DEF();
            }
        }
    }
}
/*Syntax copied from this reference to italic texts ==>
 (https://stackoverflow.com/questions/30310147/how-to-print-an-string-variable-as-italicized-text)*/