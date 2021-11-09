public class TrainCargoList {
    // Attributes
    private CargoNode first;
    private String trainName = "";
    private int CargoCounter = 0;

    // default constructor
    public TrainCargoList() {
        first = null;
    }

    public TrainCargoList(String trainName) {
        first = null;
        this.trainName = trainName;
    }

    // getter and setter for CargoCounter
    public int getCargoCounter() {
        return this.CargoCounter;
    }

    public void setCargoCounter(int CargoCounter) {
        this.CargoCounter = CargoCounter;
    }


    // Method isEmpty() returns true if the linked list contains no elements
    // otherwise false
    public boolean isEmpty() {
        if (first == null) {
            return true;
        }
        return false;
    }

    // Method to display the linked list
    public void display() {
        System.out.println("Train " + trainName + ": ");
        if (this.first == null) {
            return;
        }
        CargoNode printerNode = first;
        while (printerNode != null) {
            System.out.print(printerNode.data.getSn() + " ");
            printerNode = printerNode.next;
        }
    }

    // Method insertAtBack(int v) that inserts the element of value v at the end of
    // the linked list
    public void addCargo(Cargo v) {
        CargoNode p = new CargoNode(v);
        if (first == null) {
            first = p;
        } else {
            CargoNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = p;
            CargoCounter++;
        }
    }

    // Method deleteFromFront() that removes the first element from the linked list
    public Cargo deleteFromFront() {
        if (isEmpty()) {
            return null;
        } else {
            Cargo temp = first.data;
            first = first.next;
            return temp;
        }
    }
}
