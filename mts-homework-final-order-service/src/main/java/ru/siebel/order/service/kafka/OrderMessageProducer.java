package ru.siebel.order.service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MimeTypeUtils;
import ru.siebel.order.dto.Order;
import ru.siebel.order.dto.kafka.OrderMessage;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderMessageProducer {

    private final StreamBridge streamBridge;

    @Transactional
    public void sendRequest(Order dto) {
        OrderMessage esbRequestEvent = OrderMessage.builder()
                .order(dto)
                .build();

        Message<OrderMessage> message =
                MessageBuilder
                        .withPayload(esbRequestEvent)
                        .setHeader(KafkaHeaders.MESSAGE_KEY, dto.getId().toString().getBytes(StandardCharsets.UTF_8))
                        .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                        .build();

        String bindingName = "consumeOrderMessage-in-0";
        streamBridge.send(bindingName, message);
    }
}