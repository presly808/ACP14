package week4.day2;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Created by serhii on 9/25/16.
 */
public class TestDelegation {


    public static void main(String[] args) {
        Consumer delegator = System.out::println;
        delegator.accept(23);

        // binding
        ReferenceMethod myMethod = TestDelegation::sum;
        myMethod.doSome(12,21);


       // Arrays.asList(1,2,3,4,5).stream().forEach();
    }

    public static int sum(int a, int b){
        return a + b;
    }

}

@FunctionalInterface
interface ReferenceMethod{

    int doSome(int n1, int n2);

}


