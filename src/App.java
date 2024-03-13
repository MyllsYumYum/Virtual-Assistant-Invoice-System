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
    int userID = 666; //default user id
    user(){ //constructor

    }

}

public class App {
    Scanner sc = new Scanner(System.in);
    user testUser = new user();
    App(){
        testUser.add();

    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App();
    }
}
