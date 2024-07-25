package ru.siebel.order.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ShippingEnum {
    DELIVERY("Доставка"),
    HALL("В зале");

    private final String value;
}
