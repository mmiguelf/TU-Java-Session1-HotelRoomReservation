package org.hotelManagementSystem.model;

import java.util.Arrays;
import java.util.Scanner;

public class HotelReservationSystem {
    private int[] rooms = {101, 102, 103, 104, 105, 106, 107, 108, 109, 110};
    private boolean[] booked = {false, false, false, false, false, false, false, false, false, false};

    Scanner scan = new Scanner(System.in);

    public HotelReservationSystem(){}

    public void welcomeMenu() {
        boolean inUse = true;
        while (inUse) {
            System.out.println("Welcome to the Hotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. Exit");
            System.out.printf("Enter Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    inUse = false;
                    break;
            }
        }
    }

    public void cancelReservation(){
        System.out.printf("Enter room number to cancel: ");
        int room = scan.nextInt();
        scan.nextLine();

        boolean found = false;
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == room){
                if (booked[i]) {
                    booked[i] = false;
                    System.out.println("Room "+room+" reservation cancelled.");
                } else {
                    System.out.println("Room is available.");
                }
                System.out.println();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid room number.");
            System.out.println();
        }

    }

    public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (!booked[i]) {
                System.out.print(rooms[i] + " ");
            }
        }
        System.out.println();
        System.out.println();
    }

    public void bookRoom() {
        System.out.printf("Enter room number to book: ");
        int room = scan.nextInt();
        scan.nextLine();

        boolean found = false;
        for (int i = 0; i < rooms.length; i++){
            if (rooms[i] == room){
                if (!booked[i]) {
                    booked[i] = true;
                    System.out.println("Room "+room+" booked succesfully.");
                } else {
                    System.out.println("Room is already booked.");
                }
                System.out.println();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Invalid room number.");
            System.out.println();
        }

    }
}
