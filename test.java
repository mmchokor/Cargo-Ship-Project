import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Ship s = new Ship(2, 1, 3);
        // // Cargo c[] = { new Cargo("1"), new Cargo("2"), new Cargo("3"), new
        // Cargo("4"), new Cargo("5"), new Cargo("6") , new Cargo("nfjweuf")};
        // TrainQueue tq = new TrainQueue();
        // TrainCargoList t = new TrainCargoList("t");

        // System.out.println("How many cargo the train have: 4");
        // for (int i = 0; i < 4; i++) {
        // System.out.println("Enter the name of the cargo:");
        // String csn = input.nextLine();
        // Cargo c = new Cargo(csn);
        // t.addCargo(c);
        // }

        // tq.enqueueTrain(t);

        // tq.display();

        // TrainCargoList t1 = tq.dequeueTrain();

        // for (int i = 0; i <= t1.getCargoCounter(); i++) {
        // s.pushCargo(t1.deleteFromFront());
        // }

        // tq.display();

        // s.displayShip();

        int x = readInt(input, "ENter x");
        System.out.println(x);
        
        input.close();
    }

    public static int readInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input! Try Again.");
                input.nextLine();
            }
        }
    }
}
