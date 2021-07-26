package ru.edu.iorder.profile.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.edu.iorder.profile.dto.MessageDto;

import java.util.concurrent.CountDownLatch;
import java.util.stream.StreamSupport;

@Slf4j
@Component
@RequiredArgsConstructor
public class Listener {


    @Value("${tpd.topic-name}")
    private String topicName;

    @Value("${tpd.messages-per-request}")
    private int messagesPerRequest;

    private CountDownLatch latch;

//    @KafkaListener(topics = "advice-topic", clientIdPrefix = "json", containerFactory = "kafkaListenerContainerFactory")
//    public void listenAsObject(ConsumerRecord<String, MessageDto> cr, @Payload MessageDto payload) {
//        log.info("Logger 1 [JSON] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
//                typeIdHeader(cr.headers()), payload, cr.toString());
//        latch.countDown();
//    }

    @KafkaListener(topics = "advice-topic", clientIdPrefix = "string",
            containerFactory = "kafkaListenerStringContainerFactory")
    public void listenasString(ConsumerRecord<String, String> cr, @Payload String payload) {
        log.info("Logger 2 [String] received key {}: Type [{}] | Payload: {} | Record: {}", cr.key(),
                typeIdHeader(cr.headers()), payload, cr.toString());
//        latch.countDown();
    }

    private static String typeIdHeader(Headers headers) {
        return StreamSupport.stream(headers.spliterator(), false)
                .filter(header -> header.key().equals("__TypeId__"))
                .findFirst().map(header -> new String(header.value())).orElse("N/A");
    }
}
