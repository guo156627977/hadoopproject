package com.gzq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ${DESCRIPTION}
 *
 * @author guozhiqiang
 * @created 2018-01-06 14:54.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-kafka.xml"})
public class KafkaTest {

    @Autowired
    @Qualifier("inputToKafka")
    MessageChannel messageChannel;

    @Autowired
    @Qualifier("outputFromKafka")
    PollableChannel pollableChannel;


    @Test
    public void sendMsg() throws Exception {

        for (int i = 0; i < 1500000; i++) {
            Message<String> message = new GenericMessage<String>("test-------------" + (i + 100));
            boolean flag = messageChannel.send(message);

            //System.out.println(flag + "=============" + (i + 100));
        }

        Message<?> received = pollableChannel.receive(1000);
        while (received != null) {
            //System.out.println("|||" + received);
            received = pollableChannel.receive(1000);
        }
        System.out.println("exit");

    }

}




