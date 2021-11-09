public class TrainNode {
    // Attributes
    TrainCargoList data;
    TrainNode next;

    // default constructor
    public TrainNode() {
        data = null;
    }

    // construcotr to create a node with a value
    public TrainNode(TrainCargoList d) {
        this.data = d;
    }
}