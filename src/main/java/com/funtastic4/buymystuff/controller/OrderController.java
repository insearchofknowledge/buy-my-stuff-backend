package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AddOrderDto;
import com.funtastic4.buymystuff.Dto.OrderDto;
import com.funtastic4.buymystuff.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "")
    public ResponseEntity<OrderDto> addOrder(@RequestBody AddOrderDto addOrderDto) {
        OrderDto orderDtoToCreate = orderService.createOrder(addOrderDto);
        return new ResponseEntity<>(orderDtoToCreate, HttpStatus.CREATED);
    }

    @GetMapping(value="{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUser(@PathVariable Long userId){
        List<OrderDto> orderDtoList = orderService.getOrdersByUserId(userId);
        return new ResponseEntity<>(orderDtoList, HttpStatus.OK);
    }
}
