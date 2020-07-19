package dmly.micrometer.test.controllers;

import dmly.micrometer.test.model.Order;
import dmly.micrometer.test.utils.StubUtils;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class OrdersController {

    @Autowired
    private MeterRegistry meterRegistry;

    private Counter counter;

    @GetMapping(value = "/orders")
    public List<Order> getOrders() {
        counter.increment();
        return StubUtils.getStubListOrders();
    }

    @GetMapping(value = "/orders/{id}")
    public Order getOrder(@PathVariable("id") long id) {
        counter.increment();
        return StubUtils.getOrderById(id);
    }

    @PostConstruct
    void init() {
        counter = Counter.builder("test.dmly").register(meterRegistry);
    }

}
