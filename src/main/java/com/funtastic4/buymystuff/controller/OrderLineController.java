package com.funtastic4.buymystuff.controller;

import com.funtastic4.buymystuff.Dto.AddOrderLineDto;
import com.funtastic4.buymystuff.Dto.OrderLineDto;
import com.funtastic4.buymystuff.mapper.AddOrderLineMapper;
import com.funtastic4.buymystuff.mapper.OrderLineMapper;
import com.funtastic4.buymystuff.model.OrderLine;
import com.funtastic4.buymystuff.service.OrderLineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/orderLines")
public class OrderLineController {

    private final OrderLineService orderLineService;

    public OrderLineController(OrderLineService orderLineService, OrderLineMapper orderLineMapper, AddOrderLineMapper addOrderLineMapper) {
        this.orderLineService = orderLineService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<OrderLineDto>> getAllOrderLines() {
        List<OrderLineDto> orderLineDtoList = orderLineService.getAllOrderLines();
        return new ResponseEntity<>(orderLineDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OrderLineDto> createOrderLine(@RequestBody AddOrderLineDto addOrderLineDto) {
        OrderLineDto orderLineDto =orderLineService.createOrderLine(addOrderLineDto);
        return new ResponseEntity<>(orderLineDto, HttpStatus.CREATED);
    }

    @PutMapping(value="{orderLineId}")
    public ResponseEntity<OrderLineDto> updateOrderLine(@PathVariable("orderLineId") Long id, @RequestBody AddOrderLineDto addOrderLineDto){
        OrderLineDto newOrderLineDto = orderLineService.updateOrderLine(id, addOrderLineDto.getQuantity());
        return new ResponseEntity<>(newOrderLineDto,HttpStatus.OK);
    }

    @DeleteMapping(value = "{orderLineId}")
    public ResponseEntity<?> deleteOrderLine(@PathVariable("orderLineId") Long id) {
        orderLineService.deleteOrderLine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
