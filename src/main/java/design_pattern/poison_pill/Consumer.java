package design_pattern.poison_pill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);
    private final MqSubscribePoint queue;
    private final String name;

    Consumer(String name, MqSubscribePoint queue) {
        this.queue = queue;
        this.name = name;
    }

    void consume() {
        while (true) {
            Message msg;
            try {
                msg = queue.take();
                if (Message.POISON_PILL.equals(msg)) {
                    LOGGER.info("Consumer {} receive request to terminate.", name);
                    break;
                }
            } catch (InterruptedException e) {
                LOGGER.error("Exception caught.", e);
                return;
            }
            String sender = msg.getHeader(Message.Headers.SENDER);
            String body = msg.getBody();
            LOGGER.info(String.format("%s: Message [{}] from [{}] received by [%s]", msg.getHeader(Message.Headers.DATE), name), body, sender);
        }
    }
}
