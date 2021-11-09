public class TrainQueue extends TrainList {

    // Constructor
    public TrainQueue() {
        super();
    }

    public TrainQueue(String name) {
        super(name);
    }

    // Method: enqueue
    public void enqueue(TrainCargoList element) {
        insertAtBack(element);
    }

    // Method: dequeue
    public TrainCargoList dequeue() {
        return deleteFromFront();
    }

    // Method: display
    public void display() {
        TrainQueue temp = new TrainQueue();
        while (!isEmpty()) {
            TrainCargoList tempData = dequeue();
            temp.enqueue(tempData);
            System.out.println(tempData);
        }
        while (!temp.isEmpty()) {
            enqueue(temp.dequeue());
        }
        System.out.println();
    }

}