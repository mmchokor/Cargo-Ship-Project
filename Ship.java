public class Ship {
    // Attributes
    private String name;
    private int row;
    private int col;
    protected CargoStack pile[][] = new CargoStack[100][100];
    private int stackSize = 0;

    // Constructors
    public Ship() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pile[i][j] = new CargoStack(stackSize);
            }
        }
    }

    public Ship(int row, int col, int stackSize) {
        this.row = row;
        this.col = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pile[i][j] = new CargoStack(stackSize);
            }
        }
    }

    public Ship(String name, int row, int col, int stackSize) {
        this.name = name;
        this.row = row;
        this.col = col;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pile[i][j] = new CargoStack(stackSize);
            }
        }
    }

    // getter for name attribute
    public String getName() {
        return name;
    }

    // method that return true if the ship is empty
    public boolean shipIsEmpty() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!pile[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    // method that return true if the ship is full
    public boolean shipIsFull() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!pile[i][j].isFull()) {
                    return false;
                }
            }
        }
        return true;
    }

    // methode to place the cargo on the ship on the fathest non full stack
    public boolean pushCargo(Cargo c) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!pile[i][j].isFull()) {
                    if (pile[i][j].push(c))
                        return true;
                }
            }
        }
        return false;
    }

    // method to return the nearest Cargo and delete it
    public Cargo popCargo() {
        if (!shipIsEmpty()) {
            for (int i = row - 1; i > -1; i--) {
                for (int j = col - 1; j > -1; j--) {
                    if (!pile[i][j].isEmpty()) {
                        return pile[i][j].pop();
                    }
                }
            }
        }
        return null;
    }

    // method that return the nearest Cargo withtout poping it
    public Cargo peekCargo() {
        for (int i = row - 1; i > -1; i--) {
            for (int j = col - 1; j > -1; j--) {
                if (!pile[i][j].isEmpty()) {
                    return pile[i][j].peek();
                }
            }
        }
        Cargo empty = new Cargo("The Ship is Empty!");
        return empty;
    }

    // method to clear out the entire ship
    public boolean popAllShip() {
        if (!shipIsEmpty()) {
            for (int i = row - 1; i > -1; i--) {
                for (int j = col - 1; j > -1; j--) {
                    while (!pile[i][j].isEmpty()) {
                        pile[i][j].pop();
                    }
                }
            }
            return true;
        }
        return false;
    }

    // method to search for a cargo that it is on the ship
    public int[] SearchCargoShip(String name) {
        if (!shipIsEmpty()) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!pile[i][j].isEmpty()) {
                        int position = pile[i][j].searchCargo(name);
                        if (position != -1) {
                            int location[] = { i + 1, j + 1, position };
                            return location;
                        }
                    }
                }
            }
        }
        int noLoc[] = { -1, -1, -1 };
        return noLoc;
    }

    // delete a cargo by its index
    public Cargo deleteCargoindexShip(int x, int y, int z) {
        try {
            if (!shipIsEmpty()) {
                if (x > row || y > col) {
                    return null;
                }
                return pile[x - 1][y - 1].deleteCargoIndexStack(z);
            }            
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    // delete a cargo by its name
    public Cargo deleteCargoNameShip(String name) {
        if (!shipIsEmpty()) {
            int position[] = SearchCargoShip(name);
            if (position[0] != -1) {
                return deleteCargoindexShip(position[0], position[1], position[2]);
            }
        }
        return null;
    }

    // method to insert a cargo in a certain position
    public boolean stackCargoAtIndex(Cargo c, int x, int y) {
        if (!shipIsFull()) {
            try {
                if (!pile[x - 1][y - 1].isFull()) {
                    pile[x - 1][y - 1].push(c);
                    return true;
                }                
            } catch (Exception e) {
                return false;
            }
            return false;
        }
        return false;
    }

    public void displayShip() {
        System.out.println(name + ":");
        if (shipIsEmpty()) {
            System.out.println("The Ship is Empty!");
        } else {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (!pile[i][j].isEmpty()) {
                        System.out.printf("Pile[%d][%d]:\n", i + 1, j + 1);
                        pile[i][j].displayStack();
                    } else {
                    }

                }
            }
        }
    }
}
