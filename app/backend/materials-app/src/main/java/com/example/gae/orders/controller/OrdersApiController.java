package com.example.gae.orders.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gae.api.orders.controller.OrdersApi;
import com.example.gae.api.orders.model.Order;
import com.example.gae.common.framework.services.GetTranslatedTextService;
import com.example.gae.common.framework.utilities.GlobalConstants;
import jakarta.validation.Valid;
import lombok.Getter;

@RestController
@RequestMapping(GlobalConstants.ORDERS_API_CONTEXT_PATH)
public class OrdersApiController implements OrdersApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersApiController.class);

    @Getter private GetTranslatedTextService getTranslatedTextService;

    public OrdersApiController(final GetTranslatedTextService getTranslatedTextServiceIn) {
        this.getTranslatedTextService = getTranslatedTextServiceIn;
    }

    @Override 
    public final ResponseEntity<List<Order>> ordersGet(
        final @Valid @RequestParam(value = "limit", required = false) Integer limit,
        final @Valid @RequestParam(value = "offset", required = false) Integer offset
    ) {
        List<Order> list = new ArrayList<Order>();

        LOGGER.info("Orders Get invoked");
        // The proxy has a problem with final, i use the getter to bypass it
        LOGGER.info(this.getGetTranslatedTextService().invoke("test"));
        Order order = new Order();
        order.setOrderName("order 1");
        order.setOrderId("1");
        list.add(order);
        
        throw new RuntimeException("Test exception handling");
       }
}
