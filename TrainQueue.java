public class TrainQueue extends TrainList {

    // Attributes
    private int numberOfTrains = 0;

    // Constructor
    public TrainQueue() {
        super();
    }

    public TrainQueue(String name) {
        super(name);
    }

    // getter for numberOfTrains
    public int getNumberOfTrains() {
        return numberOfTrains;
    }

    // Method: enqueue
    public void enqueueTrain(TrainCargoList element) {
        insertAtBack(element);
        numberOfTrains++;
    }

    // Method: dequeue
    public TrainCargoList dequeueTrain() {
        return deleteFromFront();
    }

    // Method: display
    public void display() {
        TrainQueue temp = new TrainQueue();
        while (!isEmpty()) {
            TrainCargoList tempData = dequeueTrain();
            temp.enqueueTrain(tempData);
            tempData.display();
        }
        while (!temp.isEmpty()) {
            enqueueTrain(temp.dequeueTrain());
        }
        System.out.println();
    }

}