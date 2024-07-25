package ru.siebel.order.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.siebel.order.dto.Order;
import ru.siebel.order.service.entity.OrderEntity;
import ru.siebel.order.service.kafka.OrderMessageProducer;
import ru.siebel.order.service.mapper.OrderMapper;
import ru.siebel.order.service.repository.OrderRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMessageProducer orderMessageProducer;
    private final OrderMapper orderMapper;

    public void acceptOrder(OrderEntity order) {
        this.orderRepository.save(order);
        this.sendOrderMessage(order);
    }

    public void saveOrder(OrderEntity order) {
        this.orderRepository.save(order);
    }

    public Optional<OrderEntity> getOrder(String dtoId) {
        return Optional.of(this.orderRepository.getById(UUID.fromString(dtoId)));
    }

    private void sendOrderMessage(OrderEntity order) {
        Order orderDto = this.orderMapper.entityToDto(order);
        this.orderMessageProducer.sendRequest(orderDto);
    }
}
