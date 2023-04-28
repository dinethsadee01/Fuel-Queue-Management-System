package com.example.classVersion;

import java.util.Scanner;
public class Waiting {
    static int size = 12;  // Size of Circular Queue
    static int front=-1, rear=-1;
    static FuelQueue[] waitingList = new FuelQueue[size];
    static Scanner sc = new Scanner(System.in);

    static void addToWaitingList() {
        if ((front == 0 && rear == size-1) || (front == rear+1)) {
            System.out.println("SORRY! WAITING LIST IS ALSO FULL!");
        } else {
            if (front == -1) front = 0;
            rear = (rear+1) % size;
            System.out.print("1) Enter customer's first name: ");
            String fName = sc.next().toUpperCase();
            System.out.print("2) Enter customer's second name: ");
            String lName = sc.next().toUpperCase();
            System.out.print("3) Enter vehicle No: ");
            String vNo = sc.next().toUpperCase();
            System.out.print("4) Enter the liters required: ");
            int fAmount = sc.nextInt();
            waitingList[rear]= new FuelQueue(); //creating array object
            waitingList[rear].setFName(fName);  //storing data with setters
            waitingList[rear].setLName(lName);
            waitingList[rear].setVNo(vNo);
            waitingList[rear].setFAmount(fAmount);
            System.out.println(waitingList[rear].getFName() + " SUCCESSFULLY ADDED TO THE WAITING LIST.");
        }
    }

    static FuelQueue waitingListToQueue() {
        FuelQueue w = null;
        if (front == -1) {
            System.out.println("(THERE ARE NO PASSENGERS IN WAITING LIST TO ADD)");
        } else {
            w = waitingList[front];
            //System.out.println(w.getFName());
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % size; //list has only one element, so we reset the queue after deleting it.
            }
        }
        return w;
    }
}
