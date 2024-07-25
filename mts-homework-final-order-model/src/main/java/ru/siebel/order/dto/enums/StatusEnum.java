package ru.siebel.order.dto.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum StatusEnum {
    NEW("Создан"),
    IN_PROGRESS("В работе"),
    RESERVE_INGRS("Резерв ингридиентов"),
    COOKING("Готовится"),
    NOT_ENOUGH_INGRS("Нет ингридиентов"),
    SUBMIT_FOR_DELIVERY("Передано на доставку"),
    SUBMIT_FOR_SERVE("Передано на подачу"),
    SERVED("Подан"),
    DELIVERED("Доставлен");

    private final String value;
}
