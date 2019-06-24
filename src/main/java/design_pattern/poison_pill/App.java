package design_pattern.poison_pill;

public class App {
    public static void main(String[] args) {
        MessageQueue queue = new SimpleMessageQueue(1000);
        final Producer producer = new Producer("PRODUCER_1", queue);
        final Consumer consumer = new Consumer("CONSUMER_1", queue);

        new Thread(consumer::consume).start();

        new Thread(() -> {
            producer.send("hand shake");
            producer.send("some very important information");
            producer.send("bye!");
            producer.stop();
        }).start();
    }
}
