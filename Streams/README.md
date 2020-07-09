*	Streams: A stream represents a sequence of objects and operates on data source like array/ collection.

    a.	A stream simply moves data possibly filtering sorting or otherwise operating on that data in the process.
    b.	A collection is an in-memory data structure to hold values and before we start using collection, all the values should have been populated. 
        Whereas a java Stream is a data structure that is computed on-demand. 
    c.	A stream operation itself doesn’t modify the source rather creates a new stream.
    d.	Stream library is defined in java.util.stream
    e.	Terminal operations: Terminal ops on streams consume it. Once consumed a stream can’t be reused. An attempt to 
        reuse the same reference after calling the terminal operation will trigger the IllegalStateException
    f.	Intermediate operations: create another stream. They can be used to pipeline that performs sequence of operations, 
        Intermediate operations doesn’t execute until a terminal operation is encountered. intermediate operations which 
        reduce the size of the stream should be placed before operations which are applying to each element.
        i.	Stateful: Processing of element depends on other elements e.g., sorted
        ii.	Stateless: Processing of element doesn’t depends on other e.g., filter, map, flatMap, distinct, takeWhile,
            dropWhile, peek, skip, limit
    g.	Short circuit operations: 
        i.	Intermediate: limit, skip
        ii.	Terminal:  anyMatch, allMatch, noneMatch, findFirst and findAny
*	BaseStream: Defines basic functionality defined in a stream. interface BaseStream<T, S extends BaseStream<T, S>> extends AutoCloseable

    a.	Methods: close, isParallel, allMatch(), anyMatch, noneMatch, distinct 
        i.	Creation: of
        ii.	Terminal: iterator, splitarator 
        iii.	Intermediate: unordered, onClose(runnable), parallel, sequential
    b.	Primitive stream, [Double|Int|Long]Stream extends BaseStream
*	Stream: interface Stream<T> extends BaseStream<T, Stream<T>>

    a.	Methods: 
        i.	Terminal: collect(Collector<T, A, R>), count, forEach(Consumer), max(Comparator<T>), min(Comparator<T>), 
            reduce(T identity, BinaryOperator<T>), findFirst, findAny, anyMatch(predicate), allMatch(predicate)
        ii.	Intermediate: filter(Predicate), map(Function<T, R>), mapTo<Double|Int|Long>, sorted(), toArray()
*	Primitive stream: <Double|Int|Long>Stream extends Stream to generate stream of primitives
*	Creation: 

    see example code
*	Optional<T>: A container object which may or may not contain a non-null value.

    a.	Methods: isPresent(), get()
        i. Query: isPresent([consumer]), ifPresentOrElse(consumer, runnable), equals(), get()
        ii.	Factory: empty(), of(), ofNullable()[wraps nulls returns empty optional], stream(), or(supplier), orElseGet(supplier), orElseThrow(supplier)
        iii. Operations: map(mapper), filter(predicate)
    b.	Stream terminal operations return Optional object. Some of these methods are:
        reduce, Optional, max, findFirst, findAny
*	Parallel streams: Any operation applied on parallel stream must be stateless, non-interfering and associative.
    
    a.	reduce:
        i. identity – the initial value for an accumulator or a default value if a stream is empty and there is nothing to accumulate;
        ii. accumulator – a function which specifies a logic of aggregation of elements. As accumulator creates a 
        new value for every step of reducing, the quantity of new values equals to the stream's size and only the last 
        value is useful. This is not very good for the performance.
        iii. combiner – a function which aggregates results of the accumulator. Combiner is called only in a parallel 
        mode to reduce results of accumulators from different threads.
        iv.	An accumulator should be stateless, non-interfering and associative. 
    b.	Parallel streams may be efficient for unordered elements. If order doesn’t matter call unordered()
*	Mapping: <R> Stream<R> map(Function<? super T, ? extends R> mapper) 

    a.	To map to primitive stream: mapTo<Int|Long|Double>(To<Int|Long|Double>Function)
    b.	Stream.flatMap, as it can be guessed by its name, is the combination of a map and a flat operation. 
        That means that you first apply a function to your elements, and then flatten it. Stream.map only applies a function
         to the stream without flattening the stream.
To understand what flattening a stream consists in, consider a structure like [ [1,2,3], [4,5,6], [7,8,9] ] which has "two levels". Flattening this means transforming it in a "one level" structure : [ 1,2,3,4,5,6,7,8,9 ].
*	Collecting: To obtain collection from a stream provides collect method.

    a.	<R, A> R collect(Collector<? super T, A, R> collector)
    b.	<R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner): 
    c.	The result of collect operation is mutable storage object.
    d.	Collector class methods: toList, toUnmodifiableList, toSet, toUnmodifiableSet, toMap,, toUnmodifiableMap,
            toCollection, summarizing[Int|Double\Long], joining, averagingInt, counting, groupingBy, groupingByConcurrent, partitioningBy, 
            collectingAndThen, filtering, mapping, flatMapping, reducing
*	Splitarator: used for traversing and partitioning sequences esp. for parallel one

    a.	TryAdvance(Consumer): returns false when there is no item to process, thus makes looping construct very simple.
    b.	forEachRemaining(Consumer): performs action on each element collectively than in loop.
    c.	trySplit(): split elements to be iterated in two parts and return Splitarator reference to new part where
            original part remain accessible through old spliterator.
* Iterator:

      a.  forEach() in parallel stream may not preserve ordering. For ordering we need to call forEachOrdered()
* Parallel Streams:

        a. The API allows creating parallel streams, which perform operations in a parallel mode. Under the hood, 
           Stream API automatically uses the ForkJoin framework to execute operations in parallel. By default,
           the common thread pool will be used and there is no way (at least for now) to assign some custom thread pool to it.
        b. Collection or an array it can be achieved with the help of the parallelStream() otherwise use parallel()  
        c. The stream in parallel mode can be converted back to the sequential mode by using the sequential() method.
        d. Stream API also simplifies multithreading by providing the parallelStream()
            i. list.parallelStream().forEach(element -> doWork(element));   
* Ref:

        a. https://www.baeldung.com/java-streams