import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int back = 1;
        int operator;

        System.out.println("------------------- Chokor Cargo ------------------");
        System.out.println("              Welcome to Chokor Cargo");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("                     Ship Info");
        System.out.println("---------------------------------------------------");
        System.out.println("Enter the Ship name:");
        String shipName = input.nextLine();
        System.out.println("Please Enter how many rows the ship can handle: ");
        int row = input.nextInt();
        System.out.println("Please Enter how many columns the ship can handle: ");
        int column = input.nextInt();
        System.out.println("Please Enter how many cargo the ship can Stack: ");
        int height = input.nextInt();

        // Creating an object s that can access the ship class
        Ship s = new Ship(shipName, row, column, height);
        TrainQueue tq = new TrainQueue();

        do {
            System.out.println("---------------------------------------------------");
            System.out.println("                     Main Menu");
            System.out.println("---------------------------------------------------");
            System.out.println("1 - Add a Cargo to the Ship");
            System.out.println("2 - Remove Cargo From Ship");
            System.out.println("3 - Search for Cargo on the Ship");
            System.out.println("4 - Display the Cargo on the Ship");
            System.out.println("5 - Add a Train to the Queue");
            System.out.println("6 - Dequeue a Train to add its Cargo to the ship");
            System.out.println("7 - Display the Trains in the Queue");
            System.out.println("8 - Exit Program");
            System.out.println("Enter the Menu Number you want to Enter: ");
            operator = input.nextInt();
            System.out.println("---------------------------------------------------");
            System.out.println();

            switch (operator) {
            case 1:
                // Adding cargo to the ship menu
                System.out.println("---------------------------------------------------");
                System.out.println("                   Cargo Adding");
                System.out.println("---------------------------------------------------");
                int addingCargoSelect;
                do {
                    System.out.println("----------------------------------------------------");
                    System.out.println("                    Adding Method");
                    System.out.println("----------------------------------------------------");
                    System.out.println("1 - Normal Method");
                    System.out.println("2 - At Certain Index Method");
                    System.out.println("3 - Return to main menu");
                    System.out.println("Enter the Adding method number:");
                    addingCargoSelect = input.nextInt();

                    switch (addingCargoSelect) {
                    case 1:
                        // Normal Method and thats by placing the cargo at the furtest point of the ship
                        System.out.println("Enter the Serial Number of the Cargo");
                        String cargoSN = input.nextLine();
                        cargoSN = input.nextLine();
                        Cargo c = new Cargo(cargoSN);
                        if (s.pushCargo(c)) {
                            System.out.println(cargoSN + " has been added to the ship successfully");
                        } else {
                            System.out.println(cargoSN + " couldn't be added to the ship");
                        }

                        // to go back to the main menu
                        backToMenu(input, back);
                        break;

                    case 2:
                        // At Certain Index Method
                        System.out.println("Enter the Serial Number of the Cargo");
                        String cargoSN1 = input.nextLine();
                        cargoSN1 = input.nextLine();
                        Cargo c1 = new Cargo(cargoSN1);
                        System.out.println("Enter the x-index you want to add the cargo at");
                        int x = input.nextInt();
                        System.out.println("Enter the y-index you want to add the cargo at");
                        int y = input.nextInt();
                        if (s.stackCargoAtIndex(c1, x, y)) {
                            System.out.println(cargoSN1 + " has been added to the ship successfully");
                        } else {
                            System.out.println(cargoSN1 + " couldn't be added to the ship");
                        }

                        // to go back to the main menu
                        backToMenu(input, back);
                        break;

                    case 3:
                        // this case is empty so the program doesn't go to default case when exiting
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid Input! \nTry Again.");
                        break;
                    }
                } while (addingCargoSelect != 3);

                break;

            case 2:
                // Removing cargo from the ship menu
                System.out.println("---------------------------------------------------");
                System.out.println("                   Cargo Removing");
                System.out.println("---------------------------------------------------");
                int removingCargoSelect;
                do {
                    System.out.println("----------------------------------------------------");
                    System.out.println("                    Removing Method");
                    System.out.println("----------------------------------------------------");
                    System.out.println("1 - Normal Method");
                    System.out.println("2 - At Cargo Index Method");
                    System.out.println("3 - By the Cargo name Method");
                    System.out.println("4 - Remove all the Cargo on the Ship");
                    System.out.println("5 - Return to main menu");
                    System.out.println("Enter the Adding method number:");
                    removingCargoSelect = input.nextInt();

                    switch (removingCargoSelect) {
                    case 1:
                        // Normal Method abd that by removing the nearest cargo on the ship
                        Cargo temp = s.popCargo();
                        if (temp == null) {
                            System.out.println("There is no cargo on the ship");
                        } else {
                            System.out.println(temp.getSn() + " has been removed Successfully");
                        }

                        // to go back to the main menu
                        backToMenu(input, back);
                        break;

                    case 2:
                        // At Certain Index Method
                        System.out.println("Enter the x-index you want to remove the cargo from");
                        int x = input.nextInt();
                        System.out.println("Enter the y-index you want to remove the cargo from");
                        int y = input.nextInt();
                        System.out.println("Enter the z-index you want to remove the cargo from");
                        int z = input.nextInt();
                        if (x > row || y > column || z > height) {
                            System.out.println("Invalid Index!");
                            // to go back to the main menu
                            backToMenu(input, back);
                            break;
                        }
                        Cargo temp1 = s.deleteCargoindexShip(x, y, z);
                        if (temp1 == null) {
                            System.out.println("There is no cargo at this index on the ship");
                        } else {
                            System.out.println(temp1.getSn() + " has been removed Successfully");
                        }

                        // to go back to the main menu
                        backToMenu(input, back);

                        break;

                    case 3:
                        System.out.println("Enter the Serial Number of the Cargo you want to delete");
                        String snDelete = input.nextLine();
                        snDelete = input.nextLine();
                        if (s.deleteCargoNameShip(snDelete) == null) {
                            System.out.println(snDelete + " couldn't be found to be removed");
                        } else {
                            System.out.println(snDelete + " has been removed successfully");
                        }

                        // to go back to the main menu
                        backToMenu(input, back);
                        break;

                    case 4:
                        if (s.popAllShip()) {
                            System.out.println("The Ship has been cleared");
                        } else {
                            System.out.println("The Ship is already Empty!");
                        }
                        // to go back to the main menu
                        backToMenu(input, back);
                        break;

                    case 5:
                        // this case is empty so the program doesn't go to default case when exiting
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid Input! \nTry Again.");
                        break;
                    }
                } while (removingCargoSelect != 5);

                break;

            case 3:
                // Searching cargo from the ship menu
                System.out.println("---------------------------------------------------");
                System.out.println("                   Cargo Searching");
                System.out.println("---------------------------------------------------");
                System.out.println("Enter the Serial number of the Cargo you want to\nlook for:");
                String snSearch = input.nextLine();
                snSearch = input.nextLine();
                int cargoLocation[] = s.SearchCargoShip(snSearch);
                if (cargoLocation[0] == -1) {
                    System.out.println("The Cargo couldn't be found");
                } else {
                    System.out.println("The Cargo has been found at these coordinates:");
                    System.out.printf("X: %d; Y: %d; Z: %d \n", cargoLocation[0], cargoLocation[1], cargoLocation[2]);
                }

                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 4:
                s.displayShip();
                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 5:
                // add train to the queue
                System.out.println("Enter the number Trains you want to Enqueue");
                int trainCount = input.nextInt();
                for (int i = 0; i < trainCount; i++) {
                    System.out.println("Enter the name of the Train:");
                    String trainName = input.nextLine();
                    if (i == 0) {
                        trainName = input.nextLine();                        
                    }
                    // initalize the train
                    TrainCargoList t = new TrainCargoList(trainName);
                    System.out.println("How many Cargo Cart this train has:");
                    int cargoCartCount = input.nextInt();
                    for (int j = 0; j < cargoCartCount; j++) {
                        System.out.println("Enter the Serial Number of the Cargo");
                        String cargoSN = input.nextLine();
                        if (j == 0) {
                            cargoSN = input.nextLine();                            
                        }
                        Cargo c = new Cargo(cargoSN);
                        if (t.addCargo(c)) {
                            System.out.println(cargoSN + " has been added to the train successfully");
                        } else {
                            System.out.println(cargoSN + " couldn't be added to the train");
                        }
                    }
                    tq.enqueueTrain(t);
                }

                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 6:
                // remove train from the queue


                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 7:
                // display the trains in the queue
                System.out.println("The Train Queue:");
                tq.display();

                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 8:
                // To exit Program
                System.out.println("Exiting in process...");
                System.exit(0);
                break;

            default:
                // Invalid input
                System.out.println(operator + " is not a valid Menu Option! Please Select Another.");
                // to go back to the main menu
                backToMenu(input, back);
                break;
            }
        } while (operator != 8);
        input.close();
    }

    // Method to pause the caude between function in the menu
    public static void backToMenu(Scanner input, int back) {
        System.out.println("Enter \"0\" to go back to the previous Menu.");
        do {
            back = input.nextInt();
            if (back != 0) {
                System.out.println("You have enter a number other than 0. Try Again!");
            }
            System.out.println();
        } while (back != 0);
    }
}
