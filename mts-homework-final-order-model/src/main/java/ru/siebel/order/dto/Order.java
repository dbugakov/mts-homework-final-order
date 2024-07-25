package ru.siebel.order.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    public static final long serialVersionIUD = 12345L;

    private UUID id;

    private String status;

    private String content;

    private String shipping;
}
