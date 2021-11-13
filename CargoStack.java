public class CargoStack extends CargoList {
    // Attributes
    public int currentNb = 0;
    public int stackSize;

    // Constructor
    public CargoStack() {
        super();
    }

    public CargoStack(int stackSize) {
        super();
        this.stackSize = stackSize;
    }

    // push method to insert integers to the beginning of the stack
    public boolean push(Cargo value) {
        if (!isFull()) {
            if (insertAtFront(value)) {
                currentNb++;
                return true;
            }
        }
        return false;
    }

    // pop method to remove an integers from the stack and return its value
    public Cargo pop() {
        currentNb--;
        if (currentNb < 0) {
            currentNb = 0;
        }
        return deleteFromFront();
    }

    // peek method to see the last element at the top of the stack without removing
    // it
    public Cargo peek() {
        Cargo peeker = pop();
        push(peeker);
        return peeker;
    }

    // isFull method to see if the cargo stack is full
    public boolean isFull() {
        if (currentNb == stackSize) {
            return true;
        }
        return false;
    }

    // search method to find a specific cargo in the stack and return its position
    public int searchCargo(String value) {
        int search = -1;
        int tempCurrent = currentNb;
        if (isEmpty()) {
            System.out.println("The stack is empty");
        } else {
            CargoStack temp = new CargoStack(stackSize);
            for (int i = 0; !isEmpty(); i++) {
                Cargo tempCargo = pop();
                temp.push(tempCargo);
                if (value.equals(tempCargo.getSn())) {
                    search = tempCurrent - i;
                }
            }
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
        }
        return search;
    }

    // delete cargo by its index
    public Cargo deleteCargoIndexStack(int index) {
        Cargo returnC = null;
        if (!isEmpty()) {
            CargoStack temp = new CargoStack(stackSize);
            int i = 0;
            int tempCurrent = currentNb;
            while (!isEmpty()) {
                Cargo value = pop();
                temp.push(value);
                if (tempCurrent - i == index) {
                    returnC = temp.pop();
                }
                i++;
            }
            while (!temp.isEmpty()) {
                push(temp.pop());
            }
            return returnC;
        }
        return returnC;
    }

    // a method that search for a cargo by its name and if it is found it will
    // delete it
    public Cargo deleteCargoNameStack(String name) {
        if (!isEmpty()) {
            int position = searchCargo(name);
            if (position != -1) {
                return deleteCargoIndexStack(position);
            }
        }
        return null;
    }

    // display method to display the stack elements
    public void displayStack() {
        CargoStack temp = new CargoStack(stackSize);
        while (!isEmpty()) {
            Cargo value = pop();
            temp.push(value);
            System.out.println(value.getSn());
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
    }
}
