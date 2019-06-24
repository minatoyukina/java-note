package design_pattern.poison_pill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class Producer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private final MqPublishPoint queue;
    private final String name;
    private boolean isStopped;

    Producer(String name, MqPublishPoint queue) {
        this.queue = queue;
        this.name = name;
        this.isStopped = false;
    }

    void send(String body) {
        if (isStopped) {
            throw new IllegalStateException(String.format("Producer %s was stopped and fail to deliver requested message [%s].", body, name));
        }
        Message msg = new SimpleMessage();
        msg.addHeader(Message.Headers.DATE, new Date().toString());
        msg.addHeader(Message.Headers.SENDER, name);
        msg.setBody(body);
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            LOGGER.error("Exception caught.", e);
        }
    }

    public void stop() {
        isStopped = true;
        try {
            queue.put(Message.POISON_PILL);
        } catch (InterruptedException e) {
            LOGGER.error("Exception caught.", e);
        }
    }
}
