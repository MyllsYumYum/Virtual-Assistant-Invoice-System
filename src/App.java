//in the bengigging
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

class services{
    Scanner sc = new Scanner(System.in);
    int[] serviceCosts = new int[10]; // service costs per hour
    String[] serviceNames = new String[10]; // service name
    services(){ //default values
        serviceNames[0] = "Party Tricks";
        serviceNames[1] = "Balloon Shapes";
        serviceCosts[0] = 100;
        serviceCosts[1] = 60;
    }
    void addServ (){
        for (int i = 0; i < 10; i++) {
            if (serviceNames[i] == null) {
                System.out.println("~~~Enter Service Name~~~");;
                serviceNames[i] = sc.nextLine();
                System.out.println("~~~Enter Service Costs Per Hour~~~");
                serviceCosts[i] = sc.nextInt();
                sc.nextLine(); // problems with nextline comming after a next int
                break;
            } 
            if (i != 9) {
                continue;
            }
                System.out.println("~~~Services List is full, Please Delete an existing Service.~~~");
            
        }
    }
    void deleteServ(int input){
        serviceNames[input] = null;
        serviceCosts[input] = 0;
    }
    void loadServ(){ //load user with services from sql
        //Somehow

    }
}

class user extends services{
    String name = "John Doe"; //default name
    int userID = 0; //default user id
    user(){ //constructor
        System.out.println(name); //test stuff
        System.out.println(userID); //test stuff
    }

}

class client{
    int clientID = 0;
    String clientName = "Jane Defoe";
    ArrayList<Integer> invoiceKeys = new ArrayList<Integer>();

}
class invoice{
    int invoiceID = 0;
    int userKey = 0;
    String[] serviceNames = new String[10]; //invoice should provide name of services availed at that time
    int[] serviceCosts = new int[10]; // invoice should provide costs of services availed at that time
    float hours;
    int total = 0;
    String date;
    int clientKey = 0;
}

public class App {
    int currentUser = 0;
    int newint;
    void menu(int menum){
        switch (menum) {
            case 0: //Main Menu
            System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n Current User : " + userList[currentUser].name);
                System.out.println("1. ) Change User \n2. ) Access Services \n3. ) Access Clients \n4. ) Access Invoices \n 9. ) Exit Program");
                menu(sc.nextInt());
                break;
        
            case 1: //Change user
            System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n Choose User");
                System.out.println("0. ) Add User");
                for (int index = 0; index < 5; index++) {
                    if (userList[index] == null) {
                        break;
                    }
                    System.out.println(index+1 + ". ) " + userList[index].name );
                }
                try { // try catch block so the program doesnt KAMIKAZE when given a string
                    newint = sc.nextInt();
                } catch (Exception e) {
                    newint = 99;
                }
                switch (newint) {
                    case 0: //Adds new user
                        boolean breakind = false;
                        for (int i = 0; i < 5; i++) {
                            if (userList[i] == null) {
                                userList[i] = new user();
                                sc.nextLine();
                                System.out.println();
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("Enter new User's Name");
                                userList[i].name = sc.nextLine();
                                userList[i].userID = i;
                                currentUser = i;
                                breakind = true;
                                break;
                            }
                        }if (!breakind) {
                            System.err.println("User Slots Full, Please delete a user");
                        }
                        break;

                    default: //checks users if available and recalls menu at invalid input
                        for (int i = 0; i < 5; i++) {
                            if (i == newint - 1) {
                                System.out.println();
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                if (userList[i] == null) {
                                    System.err.println("User slot empty, Please select or add a valid user");
                                    menu(1);
                                    break;
                                }
                                System.out.println("1. ) Switch to user \n2. ) Return to user selection");
                                System.out.println("0. ) Delete User");
                                switch (sc.nextInt()) {
                                    case 1:
                                        currentUser = i;
                                        break;
                                
                                    case 0: // insert user deletion code here
                                        
                                        break;
                                    default:
                                        menu(1);
                                        break;
                                }
                                break;
                            }
                        }
                        break;
                }
                break;
            case 2: //Access services
            System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" 11. ) exit to main menu \n0. ) Add service");
                for (int index = 0; index < 10; index++) {
                    if (userList[currentUser].serviceNames[index] == null) {
                        continue;
                    }
                    System.out.println(index+1 + ". ) " + userList[currentUser].serviceNames[index] + " - " + userList[currentUser].serviceCosts[index] + " per Hour" );
                }
                try { // try catch block so the program doesnt KAMIKAZE when given a string
                    newint = sc.nextInt();
                } catch (Exception e) {
                    newint = 99;
                }
                switch (newint) {
                    case 0: // add new service
                        userList[currentUser].addServ();
                        break;
                    default:
                        for (int i = 0; i < 10; i++) {
                            if (i == newint - 1) {
                                if (userList[currentUser].serviceNames[i] == null) {
                                    System.err.println("Service Slot empty, please add or choose a valid service");
                                    menu(2);
                                    break;
                                
                            }
                            System.out.println();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("0. ) Delete service \n1. ) Change name \n2. ) Change cost \n3. ) Return to Services");
                            switch (sc.nextInt()) {
                                case 0: // Insert Deletion Code Here
                                    userList[currentUser].deleteServ(i);
                                    break;
                            
                                case 1:
                                    System.out.println("Enter new Service Name");
                                    sc.nextLine();
                                    userList[currentUser].serviceNames[i] = sc.nextLine();
                                    break;
                                case 2:
                                    try {// try catch block so the program doesnt KAMIKAZE when given a string
                                        System.out.println("Enter new Service Cost");
                                        userList[currentUser].serviceCosts[i] = sc.nextInt();
                                    } catch (Exception e) {
                                        userList[currentUser].serviceCosts[i] = 0;
                                    }
                                    break;

                                default:
                                    break;
                            }
                            
                            }               
                        }
                        break;
                }
                 break;   
            case 3: //Access client
            System.out.println();
                switch (sc.nextInt()) {
                    case 1: //add client
                    
                    case 2: //delete client
                        
                    case 3: //access client records

                    case 4: //return to main menu
                        menu(0);
                        break;
                
                    default:
                        menu(0);
                        break;
                }
                break;
            case 4: //Access invoices
            System.out.println();
                
                break;
            
            case 9: //Exit program
            System.out.println();
            System.err.println("Closing Command Line Process");
            System.exit(1);
            default:
                
                break;
        }
        menu(0);
    }
    Scanner sc = new Scanner(System.in);
    user[] userList = new user[5];
    ArrayList<client> clientList = new ArrayList<client>();
    ArrayList<invoice> invoiceList = new ArrayList<invoice>();
    
    
    
    App(){
        userList[0] = new user();
        clientList.add(new client());
        invoiceList.add(new invoice());
        System.out.println(clientList.get(0).clientName);
        menu(0);
        //
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App();
    }
}
