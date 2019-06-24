package design_pattern.poison_pill;

public interface MqPublishPoint {
    void put(Message msg) throws InterruptedException;
}
