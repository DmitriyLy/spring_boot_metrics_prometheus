package dmly.micrometer.test.controllers;

import dmly.micrometer.test.model.Order;
import dmly.micrometer.test.utils.StubUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {

    @GetMapping(value = "/orders")
    public List<Order> getOrders() {
        return StubUtils.getStubListOrders();
    }

    @GetMapping(value = "/orders/{id}")
    public Order getOrder(@PathVariable("id") long id) {
        return StubUtils.getOrderById(id);
    }

}
