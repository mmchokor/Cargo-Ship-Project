public class TrainCargoList {
    // Attributes
    private TrainCargoNode first;
    private String trainName = "";

    // default constructor
    public TrainCargoList() {
        first = null;
    }

    public TrainCargoList(String trainName) {
        first = null;
        this.trainName = trainName;
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
        System.out.println("Train Name: " + trainName);
        if (this.first == null) {
            return;
        }
        TrainCargoNode printerNode = first;
        while (printerNode != null) {
            System.out.print(printerNode.data + " ");
            printerNode = printerNode.next;
        }
    }

    // Method insertAtBack(int v) that inserts the element of value v at the end of
    // the linked list
    public void insertAtBack(int v) {
        TrainCargoNode p = new TrainCargoNode(v);
        if (first == null) {
            first = p;
        } else {
            TrainCargoNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = p;
        }
    }

    // Method deleteFromFront() that removes the first element from the linked list
    public boolean deleteFromFront() {
        if (isEmpty()) {
            return false;
        } else {
            first = first.next;
            return true;
        }
    }
}
