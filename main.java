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
        System.out.println("                      Ship Info");
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

        do {
            System.out.println("---------------------------------------------------");
            System.out.println("                      Main Menu");
            System.out.println("---------------------------------------------------");
            System.out.println("1 - Add a Cargo to the Ship");
            System.out.println("2 - Remove Cargo From Ship");
            System.out.println("3 - Search for Cargo on the Ship");
            System.out.println("4 - Display the Cargo on the Ship");
            System.out.println("5 - Exit Program");
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
                int roomInfoSelect;
                do {
                    System.out.println("----------------------------------------------------");
                    System.out.println("                    Adding Method");
                    System.out.println("----------------------------------------------------");
                    System.out.println("1 - Normal Method");
                    System.out.println("2 - At Certain Index Method");
                    System.out.println("3 - Return to main menu");
                    System.out.println("Enter the Adding method number:");
                    roomInfoSelect = input.nextInt();

                    switch (roomInfoSelect) {
                    case 1:
                        // Normal Method abd that by pushing in the order
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

                    case 3:
                        // this case is empty so the program doesn't go to default case when exiting
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid Input! \nTry Again.");
                        break;
                    }
                } while (roomInfoSelect != 3);

                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 2:

                break;

            case 3:

                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 4:
                s.displayShip();
                // to go back to the main menu
                backToMenu(input, back);

                break;

            case 5:
                // To exit Program
                System.out.println("Exiting in process...");
                System.exit(0);
                break;

            default:
                // Invalid input
                System.out.println(operator + " is not a valid Menu Option! Please Select Another.");
                break;
            }
        } while (operator != 5);
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
