public class CargoList {
    // Attributes
    CargoNode first;

    // default constructor
    public CargoList() {
        first = null;
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
        CargoNode printerNode = first;
        while (printerNode != null) {
            System.out.print(printerNode.data + " ");
            printerNode = printerNode.next;
        }
    }

    // Method insertAtFront(int v) that inserts the element of value v at the
    // beginning of the linked list
    public void insertAtFront(Cargo v) {
        CargoNode p = new CargoNode(v);
        if (first == null) {
            first = p;
        } else {
            p.next = first;
            first = p;
        }
    }

    // Method deleteFromFront() that removes the first element from the linked list
    public Cargo deleteFromFront() {
        Cargo data = first.data;
        first = first.next;
        return data;

    }
}
