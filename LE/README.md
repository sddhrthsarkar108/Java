* Functional Interface: A functional interface is an interface have only one abstract method e.g., 
Runnable, Callable, Comparator
* Lambda expression: A lambda expression is an anonymous method whose target type is a functional interface.

        . LE results in a form of anonymous class.
        . A LE can only be used in context of functional interface. This context is created once LE is applied to
          FI reference. Type of the lambda must be compatible with that of FI’s abstract method.
        . LE gives us a way to pass executable code as an argument to method.
        . When a lambda expression is applied to target type then an instance is created implementing functional 
          interface where lambda expression defines the behavior of the abstract method.
        . Checked exception thrown by LE must be compatible with the FI abstract method.
* Closure: Closures differ from lambda expressions in that they rely on their lexical scope for some variables. 
As a result, closures can capture and carry state with them. While lambdas are stateless, closures are stateful. 

        You can use them in your programs to carry state from a defining context to the point of execution.
        
        public class CarryStateEx1 {
            public static void call(Runnable runnable) {
                System.out.println("stack 2: in call...");
                runnable.run();
            }
        
            public static void main(String[] args) {
                int value = 4;
                System.out.println("stack 1: in main...");
                call(() -> System.out.println("stack 3: in run..." + value));
            }
        }
        
        Compiler creates a method for the closure. The state is stored into a variable, which is then loaded and passed
        to the function created for the closure. The closure holds on to a copy of value in this case. That is how 
        closures carry state
        
* Higher order function: It a function that may receive, create or return a function
        
* Cascading Function: When a lambda expression returns another lambda expression, instead of taking an action or
  returning a value, you will see two arrows.
  
        Function<Integer, Predicate<Integer>> isGreaterThan = 
          pivot ‑> candidate ‑> candidate > pivot;
          
        we use currying to reuse lambda expressions with repetative logic.
* Method Reference: A method reference provides a way to refer a method without executing it.

        . LE is nothing but a code which you pass to a function to execute. If you already have that code in form of a
           method then instead of passing new code as lambda you can pass method reference
        . To use a method reference, you first need a lambda expression. To use a lambda expression, 
           you need a functional interface, an interface with one abstract method.
    a. Static method reference: LE like the one below: (args) -> Class.staticMethod(args), can be turned into the
       method reference: <Class::staticMethod>
       
    b. Instance method reference of an existing object: LE like the following: (args) -> obj.instanceMethod(args), 
       can be turned into the method reference: objRef::methodName
       
    c. Instance method ref of an object of particular type: LE like the following: (obj, args) -> obj.instanceMethod(args)	,
       can be turned into the following method reference: <ClassName::instanceMethodName>
       
    d. Constructor method reference: LE like the following: (args) -> new ClassName(args), can be turned into the
       method reference: <ClassName::new>
* Best Practices:

    a. Prefer Standard Functional Interfaces
    
    b. Use the @FunctionalInterface Annotation for FI to prevent it accidentally modified.
    
    c. Don't Overuse Default Methods in Functional Interfaces
    
    d. Avoid Overloading Methods With Functional Interfaces as Parameters
    
        public interface Processor {
            String process(Callable<String> c) throws Exception;
            String process(Supplier<String> s);
        }
        
        String result = processor.process(() -> "abc"); // compilation error
        String result = processor.process((Supplier<String>) () -> "abc");
    e. Don’t Treat Lambda Expressions as Inner Classes
        
        Inner class creates a new scope. It can hide local variables from the enclosing scope. 
        It can use the keyword this inside your inner class as a reference to its instance.
        
        LE work with enclosing scope. It can’t hide variables from the enclosing scope and
        the keyword this is a reference to an enclosing instance.
        
    f. Avoid Blocks of Code in Lambda's Body. 
    
    g. Avoid Specifying Parameter Types
    
    h. Avoid Parentheses Around a Single Parameter
    
    i. Use “Effectively Final” variables. This approach should simplify the process of making lambda execution thread-safe.
    
    j. Protect Object Variables from Mutation, otherwise it compromises thread safety.
    
    k. Use Method References
    
    l. Avoid Return Statement and Braces

* Predefined FI:

    a. UnaryOperator<T>: operate on object of type T then return result of type T. Method: T apply(T t)
    
    b. BinaryOpeartor<T>: operate on two object of type T then return result of type T. Method: T apply(T t1, T t2)
    
    c. Consumer<T>: Apply an operation on an object of type T and return nothing. Method: void accept(T t)
    
    d. Supplier<T>: Return an object of type T and takes no parameter. Method: T get()
    
    e. Function<T, R>: Apply operation on object of type T and return a result of type R. Method: R apply(T t)
    
    f. Predicate<T>: Determine if object of type T fulfills some constraint. Method: Boolean test(T t)
    
    g. Operators: function that receive and return the same value type

* Refs:
    * https://www.baeldung.com/java-8-functional-interfaces



