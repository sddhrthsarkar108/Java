package streams.collection;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    int price;
    String name;

    Product(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

public class Collect {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        // Collectors.joining()
        String listToString = productList.stream().map(Product::getName)
                .collect(Collectors.joining(", ", "[", "]"));

        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

        IntSummaryStatistics statistics = productList.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));
        statistics.getAverage();
        statistics.getCount();

        // Collectors.groupBy
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(Collectors.groupingBy(Product::getPrice));

        // Pushing the collector to perform additional transformation
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));
    }
}
