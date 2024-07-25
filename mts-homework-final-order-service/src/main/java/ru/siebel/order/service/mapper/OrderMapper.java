package ru.siebel.order.service.mapper;

import org.mapstruct.Mapper;
import ru.siebel.order.dto.Order;
import ru.siebel.order.service.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    Order entityToDto(OrderEntity entity);

    OrderEntity dtoToEntity(Order dto);
}
