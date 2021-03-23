package learning.core.aaJava8.orders;

import learning.core.aaJava8.orders.model.Customer;
import learning.core.aaJava8.orders.model.Order;
import learning.core.aaJava8.orders.model.OrderLine;
import learning.core.aaJava8.orders.model.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrdersAnalyzer {

    /**
     * Should return at most three most popular products. Most popular product is the product that have the most occurrences
     * in given learning.core.aaJava8.orders (ignoring product quantity).
     * If two products have the same popularity, then products should be ordered by name
     *
     * @param orders learning.core.aaJava8.orders stream
     * @return list with up to three most popular products
     */
    public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
        return orders
            .flatMap(order -> order.getOrderLines().parallelStream().map(OrderLine::getProduct))
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<Product, Long>comparingByValue().reversed())
            .limit(3)
            .sorted(Comparator.comparing(x -> x.getKey().getName()))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
    }

    /**
     * Should return the most valuable customer, that is the customer that has the highest value of all placed learning.core.aaJava8.orders.
     * If two customers have the same learning.core.aaJava8.orders value, then any of them should be returned.
     *
     * @param orders learning.core.aaJava8.orders stream
     * @return Optional of most valuable customer
     */
    public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
        return
            orders.collect(Collectors.groupingBy(Order::getCustomer,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    orderList -> orderList.stream()
                        .flatMap(order -> order.getOrderLines().stream())
                        .mapToLong(orderLine -> (orderLine.getProduct().getPrice()).longValue() * orderLine.getQuantity())
                        .sum())))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }
}
