package ru.siebel.order.service.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.siebel.order.api.OrderApi;
import ru.siebel.order.dto.Order;
import ru.siebel.order.dto.enums.ShippingEnum;
import ru.siebel.order.service.entity.OrderEntity;
import ru.siebel.order.service.exception.InvalidContentException;
import ru.siebel.order.service.exception.InvalidShippingException;
import ru.siebel.order.service.mapper.OrderMapper;
import ru.siebel.order.service.service.OrderService;

@RestController
@RequiredArgsConstructor
public class OrderController implements OrderApi {
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @Override
    public void updateOrder(Order dto) {
        OrderEntity entity = this.orderMapper.dtoToEntity(dto);
        this.orderService.saveOrder(entity);
    }

    @Override
    public void sendOrder(String orderContent, String orderShipping) {
        OrderEntity entity = new OrderEntity();
        entity.setContent(orderContent);
        for (ShippingEnum ship : ShippingEnum.values()) {
            if (ship.getValue().equals(orderShipping)){
                entity.setShipping(orderShipping);
            }
        }
        if (entity.getShipping() == null) {
            throw new InvalidShippingException(orderShipping);
        }
        List<String> ingredients = List.of(orderContent.split(","));
        if (!ingredients.isEmpty()) {
            this.orderService.acceptOrder(entity);
        } else {
            throw new InvalidContentException(orderContent);
        }
    }
}
