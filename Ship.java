public class Ship {
    // Attributes
    private String name;
    private int row;
    private int col;
    protected CargoStack pile[][] = new CargoStack[100][100];
    private int i = 0;
    private int j = 0;
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

    public String getName() {
        return name;
    }

    public boolean shipIsEmpty() {
        if (pile[0][0].isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean shipIsFull() {
        if (pile[row - 1][col - 1].isFull() == true) {
            return true;
        }
        return false;
    }

    public boolean pushCargo(Cargo c) {
        if (!shipIsFull()) {
            if (pile[i][j].isFull()) {
                if (j + 1 == col) {
                    i++;
                    j = 0;
                } else {
                    j++;
                }
            }
            pile[i][j].push(c);
            j++;
            return true;
        }
        return false;
    }

    public Cargo popCargo() {
        if (pile[i][j].isEmpty()) {
            if (j == 0) {
                i--;
                j = pile[0].length - 1;
            } else {
                j--;
            }
        }
        return pile[i][j].pop();
    }

    public int[] SearchCargoShip(String name) {
        if (!shipIsEmpty()) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int position = pile[i][j].searchCargo(name);
                    if (position != -1) {
                        int location[] = { i + 1, j + 1, position };
                        return location;
                    }
                }
            }
        }
        int noLoc[] = { -1, -1, -1 };
        return noLoc;
    }

    // delete a cargo by its index
    public boolean deleteCargoindexShip(int x, int y, int z) {
        if (!shipIsEmpty()) {
            if (x > row || y > col) {
                return false;
            }
            if (!pile[x - 1][y - 1].isEmpty()) {
                if (pile[x - 1][y - 1].deleteCargoIndexStack(z))
                    return true;
                return false;
            }
            return false;
        }
        return false;
    }

    // delete a cargo by its name
    public boolean deleteCargoNameShip(String name) {
        if (!shipIsEmpty()) {
            int position[] = SearchCargoShip(name);
            if (position[0] != -1) {
                deleteCargoindexShip(position[0], position[1], position[2]);
            }
            return false;
        }
        return false;
    }

    // method to insert a cargo in a certain position
    public boolean stackCargoAtIndex(Cargo c, int x, int y) {
        if (!shipIsFull()) {
            if (!pile[x - 1][y - 1].isFull()) {
                pile[x - 1][y - 1].push(c);
                return true;
            }
            return false;
        }
        return false;
    }

    public void displayShip() {
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
