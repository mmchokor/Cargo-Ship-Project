public class test {
    public static void main(String[] args) {
        Ship s = new Ship(2, 1, 3);

        Cargo c[] = { new Cargo("1"), new Cargo("2"), new Cargo("3"), new Cargo("1"), new Cargo("2"), new Cargo("3") };
        for (int i = 0; i < c.length ; i++) {
            if (s.pushCargo(c[i]) == false) {
                System.out.println("The ship is full");
                break;
            }
        }

        s.displayShip();

        s.deleteCargoindexShip(1, 1, 2);

        s.displayShip();

        s.pushCargo(c[2]);
        s.displayShip();

        // CargoStack g = new CargoStack(5);
        // g.push(c[0]);
        // g.push(c[3]);
        // g.push(c[5]);

        // g.deleteCargoNameStack("6");

        // g.displayStack();
    }
}
