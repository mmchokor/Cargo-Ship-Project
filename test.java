public class test {
    public static void main(String[] args) {
        Ship s = new Ship(2, 1, 3);

        Cargo c[] = { new Cargo("1"), new Cargo("2"), new Cargo("3"), new Cargo("4"), new Cargo("5"), new Cargo("6") };

        for (int i = 0; i < c.length - 3; i++) {
            if (s.pushCargo(c[i]) == false) {
                System.out.println("The ship is full");
                break;
            }
        }

        System.out.println(s.stackCargoAtIndex(c[5], 1, 1));

        s.displayShip();

        // CargoStack g = new CargoStack(5);
        // g.push(c[0]);
        // g.push(c[3]);
        // g.push(c[5]);

        // g.deleteCargoNameStack("6");

        // g.displayStack();
    }
}
