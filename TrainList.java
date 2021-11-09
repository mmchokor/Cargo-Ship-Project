public class TrainList {
    // Attributes
    TrainNode first;
    private String name;

    // default constructor
    public TrainList() {
        first = null;
    }

    // constructor
    public TrainList(String name) {
        first = null;
        this.name = name;
    }

    // getter and setters for name
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (this.first == null) {
            return;
        }
        TrainNode printerNode = first;
        while (printerNode != null) {
            System.out.print(printerNode.data + " ");
            printerNode = printerNode.next;
        }
    }

    // Method insertAtBack(int v) that inserts the element of value v at the end of
    // the linked list
    public void insertAtBack(TrainCargoList v) {
        TrainNode p = new TrainNode(v);
        if (first == null) {
            first = p;
        } else {
            TrainNode current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = p;
        }
    }

    // Method deleteFromFront() that removes the first element from the linked list
    public TrainCargoList deleteFromFront() {
        if (isEmpty()) {
        }
        TrainCargoList data = first.data;
        first = first.next;
        return data;
    }
}
