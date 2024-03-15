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
    boolean[] serviceKeys = new boolean[10];
    ArrayList<Integer> clientKeys = new ArrayList<Integer>();
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
                            if (userList[1] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(1);
                                break;
                            }
                            break;

                        case 1: //user 1
                            if (userList[1] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(1);
                                break;
                            }
                            break;
                        case 2: //user 2
                            if (userList[2] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(1);
                                break;
                            }
                            break;
                            
                        case 3: //user 3
                            if (userList[3] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(1);
                                break;
                            }
                            break;
    
                        case 4: //user 4
                            if (userList[4] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(3);
                                break;
                            }
                            break;
                        case 5: //user 5
                            if (userList[5] == null) {
                                System.err.println("User slot empty, Please select or add a valid user");
                                menu(1);
                                break;
                            }
                            break;
                    
                        default:
                            menu(0);
                            break;
                }
            case 2: //Access services
            System.out.println();
                    
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
                
            case 4: //Access invoices
            System.out.println();
                
            
            case 9: //Exit program
            System.out.println();
            System.err.println("Closing Command Line Process");
            System.exit(1);
            default:
                menu(0);
                break;
        }
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
