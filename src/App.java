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
    boolean checkInKey(int key){
        return invoiceKeys.contains(key);
    }
    client(){
        invoiceKeys.add(0);
        invoiceKeys.add(1);
    }

}
class invoice{
    int invoiceID = 0;
    int userKey = 0;
    int clientKey = 0;
    String[] serviceNames = new String[10]; //invoice should provide name of services availed at that time
    int[] serviceCosts = new int[10]; // invoice should provide costs of services availed at that time
    float hours = 1;
    int total = 0;
    int[] date = {1,1,2000}; // Month Day Year
    invoice() { //Default parameters
        serviceNames[0] = "Assassination";
        serviceCosts[0] = 13000;
        total = 13000;
    }
    void newInvoiceTest(){
        invoiceID = 1;
        serviceNames[0] = "Genocide";
        serviceCosts[0] = 45000;
        total = 45000;
        date = new int[]{9,11,2001};
    }
    void total(){
        total = 0;
        for (int i : serviceCosts) {
            total += i;
        }
        total *= hours;
    }
    boolean inPeriod(int[] start, int[] end){
        int period = (end[0]-start[0])+((end[1]-start[1])*30)+((end[2]-start[2])*365);
        int result = (end[0]-date[0])+((end[1]-date[1])*30)+((end[2]-date[2])*365);
        
        return result - period > 0;
    }
    /*  Formula should be
     *      End Day     |   End Month    |    End Year
     *  -   Start Day   |  Start Month   |    Start Year
     * ------------------------------------------------
     *      Day         +   (Month x 30) +    (year x 365) = period int
     * 
     * replace start date with invoice date, then subtract to period int, return true if !< 0
     * else if less than 0 then date does not fall within specified date
     */
}

public class App {
    void displayInvoice(invoice voice, client dude){
        //TO BE CONTINUED
        System.out.println("Invoice ID : " + voice.invoiceID);
        System.out.println("Client ID : " + dude.clientID + "\n Client name : " + dude.clientName + "\nServices Availed");
        for (int i = 0; i < 10; i++) {
            if (voice.serviceNames[i] != null) {
                System.out.println(voice.serviceNames[i] + " at " + voice.serviceCosts[i] + "per Hour");
            }
        }


    }
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
                        continue;
                    }
                    System.out.println(index+1 + ". ) User ID : "+ userList[index].userID+ " | Name : " + userList[index].name );
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
                                    case 1: //changes user to i
                                        currentUser = i;
                                        break;
                                
                                    case 0: 
                                        userList[i] = null;
                                        int counter = 0;
                                        for (int j = 0; j < 5; j++, counter++) {
                                            if(userList[j] != null){
                                                currentUser = j;
                                                break;

                                            } else if (counter == 4) {
                                                userList[0] = new user();
                                                currentUser = 0;
                                            }
                                        }
                                        
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
                            
                                case 1: // Change Service Name
                                    System.out.println("Enter new Service Name");
                                    sc.nextLine();
                                    userList[currentUser].serviceNames[i] = sc.nextLine();
                                    break;
                                case 2: // Change Service Costs
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
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("11. ) Return to Main menu \n0. ) Add Client ");
                for (int i = 0; i < clientList.size(); i++) {
                    System.out.println(i+1 + ". ) " + clientList.get(i).clientName);
                }
                System.out.println();
                newint = sc.nextInt();
                switch (newint) {
                    case 0: //add client
                        // To Be Continued
                        clientList.add(new client());
                        clientList.getLast().clientID = clientList.size()-1;
                        System.out.println("Enter New Client Name");
                        sc.nextLine();
                        clientList.getLast().clientName = sc.nextLine();

                        break;
                    default:
                        for (int i = 0; i < clientList.size(); i++) {
                            if (i == newint -1) {
                                System.out.println();
                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                System.out.println("11. ) Return to Main menu \n0. ) Delete Client");
                                System.out.println("1. ) Change name \n2. ) Get Invoice records");
                                newint = sc.nextInt();
                                switch (newint) {
                                    case 0: // Client Deletion Here
                                        System.out.println();
                                        System.out.println("ARE YOU SURE YOU WANT TO DELETE " + clientList.get(i).clientName + " FROM EXISTANCE");
                                        System.out.println("    1-9. ) NO \n    0.   ) I AM INEVITABLE ");
                                        switch (sc.nextInt()) {
                                            case 0:
                                                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                                                clientList.remove(i);
                                                System.out.println(" CLIENT DELETED FROM LIFE");
                                                break;
                                        
                                            default:
                                                break;
                                        }
                                        break;
                                
                                    case 1: // Change Client Name
                                        System.out.println();
                                        System.out.println("Enter New Name");
                                        sc.nextLine();
                                        clientList.get(i).clientName = sc.nextLine();
                                        break;
                                
                                    case 2: // Print out invoices under this client
                                        System.out.println();
                                        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \nPrinting Invoices under Client");
                                        int superTotal = 0;
                                        for (int j = 0; j < invoiceList.size(); j++) {
                                            if (clientList.get(i).checkInKey(invoiceList.get(j).invoiceID)) {
                                                System.out.println("Invoice ID: " + invoiceList.get(j).invoiceID + " ~~~" + " Total : " + invoiceList.get(j).total);
                                                superTotal += invoiceList.get(j).total;
                                            }
                                            
                                        }
                                        System.out.println(" Total = " + superTotal);
                                        System.out.println("~~~ END OF LIST ~~~");
                                        break;
                                
                                    default:
                                        break;
                                }
                            }
                        }
                        break;
                }
                break;
            case 4: //Access invoices
            System.out.println();
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("11. ) Return to Main menu \n0. ) Add Invoice");
            for (int i = 0; i < invoiceList.size(); i++) {
                //String cliName = ;
                System.out.println(i+1 + ". ) Invoice ID: " + invoiceList.get(i).invoiceID + " ~~~ Client ID : " + invoiceList.get(i).clientKey + " ~~~ User ID : " + invoiceList.get(i).userKey);
                System.out.println("    Date : " + invoiceList.get(i).date[0] +" / "+ invoiceList.get(i).date[1] +" / "+ invoiceList.get(i).date[2] +" ~~~ Total : " + invoiceList.get(i).total);

            }
            System.out.println();
            newint = sc.nextInt();
            switch (newint) {
                case 0: // Add Invoice
                    invoiceList.add(new invoice());
                    invoiceList.getLast().invoiceID = invoiceList.size()-1;
                    System.out.println("Enter Day");
                    invoiceList.getLast().date[0] = sc.nextInt();
                    System.out.println("Enter Month");
                    invoiceList.getLast().date[1] = sc.nextInt();
                    System.out.println("Enter Year");
                    invoiceList.getLast().date[2] = sc.nextInt();
                    System.out.println("Choose Client");
                    for (int i = 0; i < clientList.size(); i++) {
                        System.out.println( (i + 1) + ". ) " + clientList.get(i).clientName);
                    }
                    newint = sc.nextInt();
                    invoiceList.getLast().clientKey = newint - 1; // revision to get client id instead
                    invoiceList.getLast().userKey = currentUser;
                    System.out.println("Enter the Hours of Service");
                    invoiceList.getLast().hours = sc.nextFloat();
                    sc.nextLine();
                    System.out.println("Choose which services to add, separated by space");for (int index = 0; index < 10; index++) {
                        if (userList[currentUser].serviceNames[index] == null) {
                            continue;
                        }
                        System.out.println(index+1 + ". ) " + userList[currentUser].serviceNames[index] + " - " + userList[currentUser].serviceCosts[index] + " per Hour" );
                    }
                    String[] numlist = sc.nextLine().split("\\s+"); 
                    for (int str = 0 ; str < numlist.length ; str++) {
                        invoiceList.getLast().serviceNames[str] = userList[currentUser].serviceNames[str] ;
                        invoiceList.getLast().serviceCosts[str] = userList[currentUser].serviceCosts[str] ;
                        
                    }
                    //Code that adds new invoice key to client's invoice list
                    clientList.get(invoiceList.getLast().clientKey).invoiceKeys.add(invoiceList.getLast().invoiceID);
                    invoiceList.getLast().total();
                    break;
            
                default:
                    for (int i = 0; i < invoiceList.size(); i++) {
                        if (newint -1 == i) { //
                            System.out.println();
                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ ");
                            System.out.println("Invoice ID: " + invoiceList.get(i).invoiceID + " ~~~ Client ID : " + invoiceList.get(i).clientKey + " ~~~ User ID : " + invoiceList.get(i).userKey);
                            System.out.println("Client name : " + clientList.get(invoiceList.get(i).clientKey).clientName);
                            System.out.println("Services Availed");
                            for (int j = 0; j < 10; j++) {
                                if (invoiceList.get(i).serviceNames[j] == null) {
                                    break;
                                }
                                System.out.println("  " + invoiceList.get(i).serviceNames[j] + " ~~~ " + invoiceList.get(i).serviceCosts[j] );
                            }
                            System.out.println("Total : " + invoiceList.get(i).total + " ~~~ Hours : " + invoiceList.get(i).hours);
                            System.out.println();
                            System.out.println("1. ) Add service \n 2. ) Delete service \n 3. ) Change hours \n 11. ) Return to invoices");
                            
                            newint = sc.nextInt();
                            switch (newint) {
                                case 1:
                                    
                                    break;
                            
                                case 2:
                                    
                                    break;
                            
                                case 3:
                                    
                                    break;
                            
                                default:
                                    break;
                            }
                        }
                    }
                    break;
            }
            System.out.println();
                
                break;
            
            case 9: //Exit program
            /*  
             *  Insert Saving Feature Here
             */
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
        invoiceList.add(new invoice());
        invoiceList.get(1).newInvoiceTest();
        System.out.println(clientList.get(0).clientName);
        menu(0);
        //
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        new App();
    }
}
