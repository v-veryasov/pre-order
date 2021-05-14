//package ru.edu.iorder.booking.controller;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import ru.edu.iorder.booking.dto.MessageDto;
//
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.IntStream;
//
//@Slf4j
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/kafka")
//public class ProducerController {
//
//    private final KafkaTemplate<String, Object> template;
//
//    @Value("${tpd.topic-name}")
//    private String topicName;
//
//    @Value("${tpd.messages-per-request}")
//    private int messagesPerRequest;
//
//    @GetMapping("/sendMess")
//    public String hello() throws Exception {
////        CountDownLatch latch = new CountDownLatch(messagesPerRequest);
//        IntStream.range(0, messagesPerRequest)
//                .forEach(i -> this.template.send(topicName, String.valueOf(i), new MessageDto("A Practical Advice", i)));
////        latch.await(10, TimeUnit.SECONDS);
//        log.info("All messages received");
//        return "Hello Kafka!";
//    }
//}
