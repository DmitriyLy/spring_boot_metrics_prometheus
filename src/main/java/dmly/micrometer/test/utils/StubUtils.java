package dmly.micrometer.test.utils;

import dmly.micrometer.test.model.Order;
import dmly.micrometer.test.model.OrderItem;

import java.util.Arrays;
import java.util.List;

public class StubUtils {

    public static List<Order> getStubListOrders() {
        return Arrays.asList(
                new Order("customer1", "0001", 1),
                new Order("customer2", "0002", 2),
                new Order("customer3", "0003", 3),
                new Order("customer4", "0004", 4),
                new Order("customer5", "0005", 5)
        );
    }

    public static Order getOrderById(long id) {
        Order order = new Order("customer" + id, "000" + id, id);
        order.addOrderItem(new OrderItem("item1", 25, 25));
        order.addOrderItem(new OrderItem("item2", 25, 25));
        order.addOrderItem(new OrderItem("item3", 25, 25));

        return order;
    }

}
