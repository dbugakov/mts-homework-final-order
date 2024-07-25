package ru.siebel.order.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.siebel.order.dto.Order;

@FeignClient(
        name = "ProcessApi",
        url = "localhost:9560"
)
public interface OrderApi {
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping({"/updateOrderById"})
    void updateOrder(@RequestBody Order dto);

    @PostMapping({"/sendOrder"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void sendOrder(@RequestParam String orderContent, @RequestParam String orderShipping);
}
