public class TrainCargoNode {
    // Attributes
    Cargo data;
    TrainCargoNode next;

    // default constructor
    public TrainCargoNode() {
        data = null;
    }

    // construcotr to create a node with a value
    public TrainCargoNode(Cargo d) {
        this.data = d;
    }
}