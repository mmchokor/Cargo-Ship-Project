public class CargoNode {
    // Attributes
    Cargo data;
    CargoNode next;

    // default constructor
    public CargoNode() {
    }

    // construcotr to create a node with a value
    public CargoNode(Cargo d) {
        this.data = d;
    }
}