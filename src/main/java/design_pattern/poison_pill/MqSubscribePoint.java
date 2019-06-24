package design_pattern.poison_pill;

public interface MqSubscribePoint {
    Message take() throws InterruptedException;
}
