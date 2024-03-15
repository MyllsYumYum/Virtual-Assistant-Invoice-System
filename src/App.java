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
    void add (){
        for (int i = 0; i < 10; i++) {
            if (serviceNames != null) {
                System.out.println("~~~Enter Service Name~~~");;
                serviceNames[i] = sc.nextLine();
                System.out.println("~~~Enter Service Costs Per Hour~~~");
                serviceCosts[i] = sc.nextInt();
                sc.nextLine(); // problems with nextline comming after a next int
                break;
            } else {
                System.out.println("~~~Services List is full, Please Delete an existing Service.~~~");
            }
        }
    }
    void delete(){
        System.out.println("~~~Choose the number of the Service to Delete~~~");
        for (int i = 0; i < 10; i++) { // checks if there are no services in the list
            if (serviceNames != null) {
                break;
            }
            System.out.println("~~~Services are Empty, Please add a Service. Clown");
        }
        for (int i = 0; i < 10; i++) {
            if (serviceNames[i] != null) {
                System.out.println(i + ". " + serviceNames[i]);
            }
            
        }
        int input = sc.nextInt();
        serviceNames[input] = null;
        serviceCosts[input] = 0;
    }
    void load(){ //load user with services from sql
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
                switch (sc.nextInt()) {
                    case 0: //Adds new user
                        for (int i = 0; i < 5; i++) {
                            if (userList[i] == null) {
                                userList[i] = new user();
                                userList[i].name = sc.nextLine();
                                userList[i].userID = i;
                                currentUser = i;
                                break;
                            }
                        }
                        System.err.println("User Slots Full, Please delete a user");
                        break;

                    case 1: //user 1
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (userList[0] == null) {
                            System.err.println("User slot empty, Please select or add a valid user");
                            menu(1);
                            break;
                        }
                        System.out.println("1. ) Switch to user \n2. ) Return to user selection \n0. ) Delete User");
                        switch (sc.nextInt()) {
                            case 1:
                                currentUser = 0;
                                break;
                        
                            case 0: // insert user deletion code here
                                
                                break;
                            default:
                                menu(1);
                                break;
                        }
                        break;
                    case 2: //user 2
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (userList[1] == null) {
                            System.err.println("User slot empty, Please select or add a valid user");
                            menu(1);
                            break;
                        }
                        System.out.println("1. ) Switch to user \n2. ) Return to user selection \n0. ) Delete User");
                        switch (sc.nextInt()) {
                            case 1:
                                currentUser = 1;
                                break;
                        
                            case 0: // insert user deletion code here
                                
                                break;
                            default:
                                menu(1);
                                break;
                        }
                        break;
                        
                    case 3: //user 3
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (userList[2] == null) {
                            System.err.println("User slot empty, Please select or add a valid user");
                            menu(1);
                            break;
                        }
                        System.out.println("1. ) Switch to user \n2. ) Return to user selection \n0. ) Delete User");
                        switch (sc.nextInt()) {
                            case 1:
                                currentUser = 2;
                                break;
                        
                            case 0: // insert user deletion code here
                                
                                break;
                            default:
                                menu(1);
                                break;
                        }
                        break;

                    case 4: //user 4
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (userList[3] == null) {
                            System.err.println("User slot empty, Please select or add a valid user");
                            menu(1);
                            break;
                        }
                        System.out.println("1. ) Switch to user \n2. ) Return to user selection \n0. ) Delete User");
                        switch (sc.nextInt()) {
                            case 1:
                                currentUser = 3;
                                break;
                        
                            case 0: // insert user deletion code here
                                
                                break;
                            default:
                                menu(1);
                                break;
                        }
                        break;
                    case 5: //user 5
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        if (userList[4] == null) {
                            System.err.println("User slot empty, Please select or add a valid user");
                            menu(1);
                            break;
                        }
                        System.out.println("1. ) Switch to user \n2. ) Return to user selection \n0. ) Delete User");
                        switch (sc.nextInt()) {
                            case 1:
                                currentUser = 4;
                                break;
                        
                            case 0: // insert user deletion code here
                                
                                break;
                            default:
                                menu(1);
                                break;
                        }
                        break;
                
                    default:
                        menu(0);
                        break;
                }
                break;
            case 2: //Access services
            System.out.println();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(" 00. ) exit to main menu \n0. ) Add service");
                for (int index = 0; index < 10; index++) {
                    if (userList[currentUser].serviceNames[index] == null) {
                        break;
                    }
                    System.out.println(index+1 + ". ) " + userList[currentUser].serviceNames[index] + " - " + userList[currentUser].serviceCosts[index] + " per Hour" );
                }
                switch (sc.nextInt()) {
                    case 0: // add new service
                        
                        break;
                    case 1:
                        if (userList[currentUser].serviceNames[1] == null) {
                            System.err.println("Service Slot empty, please add or choose a valid service");
                        }
                        System.out.println();
                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                        System.out.println("0. ) Delete service \n1. ) Change name \n2. ) Change cost \n3. ) Return to Services");
                        switch (sc.nextInt()) {
                            case 0: // Insert Deletion Code Here
                                
                                break;
                        
                            case 1:
                                try {
                                    System.out.println("Enter new Service Name");
                                    userList[currentUser].serviceNames[0] = sc.nextLine();
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("Enter new Service Cost");
                                    userList[currentUser].serviceCosts[0] = sc.nextInt();
                                } catch (Exception e) {
                                    // TODO: handle exception
                                }
                                break;

                            default:
                                break;
                        }
                        break;
                
                    default:
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
    
    
    App(){
        userList[0] = new user();
        menu(0);
        //
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App();
    }
}
