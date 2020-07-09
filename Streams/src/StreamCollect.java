import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class StreamCollect {
    public static void main(String[] args) {
        List<Product> productList = List.of(new Product(23, "potatoes"),
                new Product(14, "orange"), new Product(13, "lemon"),
                new Product(23, "bread"), new Product(13, "sugar"));

        // toList
        List<String> collectorCollection =
                productList.stream().map(Product::getName).collect(toList());
        collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.toCollection(LinkedList::new));
        collectorCollection =
                productList.stream().map(Product::getName).collect(Collectors.collectingAndThen(Collectors.toList(), List::copyOf));

        // toMap
        Map<String, String> prodToPrice = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toMap(Function.identity(), Function.identity()));
        // usage when there is key conflict [llegalStateException]
        prodToPrice = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (o, n) -> o));
        prodToPrice = productList.stream()
                .map(Product::getName)
                .collect(Collectors.toMap(Function.identity(), Function.identity(), (o, n) -> o, TreeMap::new));

        // toSet
        Set<String> uniqueProds= productList.stream().map(Product::getName).collect(Collectors.toSet());
        uniqueProds= productList.stream().map(Product::getName).collect(Collectors.toUnmodifiableSet());

        System.out.println(productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining("_", "#", "$")));
        double averagePrice = productList.stream()
                .collect(Collectors.averagingInt(Product::getPrice));

        // groupBy
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream()
                .collect(groupingBy(Product::getPrice));
        Map<Integer, Long> xx = productList.stream()
                .collect(groupingBy(Product::getPrice, counting()));
        System.out.println(xx);
        collectorMapOfLists = productList.stream()
                .collect(groupingBy(Product::getPrice, ConcurrentHashMap::new ,toUnmodifiableList()));
        Map<Integer, Map<String, List<Product>>> priceNameGrp = productList.stream()
                .collect(groupingBy(Product::getPrice, groupingBy(Product::getName)));

        // partitioningBy
        Map<Boolean, List<Product>> mapPartioned = productList.stream()
                .collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

        // collectingAndThen
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

        List.of(1, 2, 3, 4).stream().map(Integer::bitCount).collect(LinkedList::new,
                LinkedList::add,
                LinkedList::addAll);

        // java 9: filtering
        /*With Stream's filter, the values are filtered first and then it's grouped. In this way, the values which are
        filtered out are gone and there is no trace of it. If we need a trace then we would need to group first and then
         apply filtering which actually the Collectors.filtering does.*/
        List.of(1, 2, 3, 5, 5).stream()
                .collect(Collectors.groupingBy(i -> i,
                        Collectors.filtering(val -> val > 3, Collectors.counting())));

        // java12: teeing
        List.of(1, 2, 3, 4).stream()
                .collect(teeing(
                        minBy(Integer::compareTo),
                        maxBy(Integer::compareTo),
                        (min, max) -> min.isEmpty() ? max : min ));


        System.out.println("*** sequencial collect ***");
        System.out.println(List.of(1, 2, 3, 4).stream().collect(
                () -> {
                    System.out.println("supplier: creating container");
                    return new LinkedList<>();
                },
                (l, e) -> {
                    System.out.println("accumulator: adding element: " + ", l: " + l + ", element: " + e);
                    l.add(e);
                },
                // won't run for sequential stream
                (l1, l2) -> {
                    System.out.println("combiner: concat lists" + ", 1st: " + l1 + ", 2nd: " + l2);
                    l1.addAll(l2);
                }));

        System.out.println("*** parallel collect ***");

        System.out.println(List.of(1, 2, 3, 4).parallelStream().collect(
                () -> {
                    System.out.println("supplier: creating container");
                    return new LinkedList<>();
                },
                (l, e) -> {
                    System.out.println("accumulator: adding element: " + ", l: " + l + ", element: " + e);
                    l.add(e);
                },
                (l1, l2) -> {
                    System.out.println("combiner: concat lists: " + ", 1st: " + l1 + ", 2nd: " + l2);
                    l1.addAll(l2);
                }));
    }
}

class Product {
    private String name;
    private int price;

    public Product( int price, String name) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}