package ru.siebel.order.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.siebel.order.dto.enums.StatusEnum;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "orders")
public class OrderEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Id;
    @Column(name = "status")
    private String status = StatusEnum.NEW.getValue();
    @Column(name = "content")
    private String content;
    @Column(name = "shipping")
    private String shipping;

}