package JavaCollectionsFramework.Stack;

import java.util.Stack;
// работает по принципу last in first out
public class myStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5); // adding element
        stack.push(3);
        stack.push(1);

        System.out.println(stack.peek()); // показывает последний добавленый элемент

        System.out.println(stack.empty()); // TRUE/FALSE

        while (!stack.empty()){
            System.out.println(stack.pop());
        }

        System.out.println(stack.pop());  // достает последний добавленыый элемент 1 (элемент извлекается из стека)
        System.out.println(stack.pop());  // 3
        //  System.out.println(stack.pop());  // 5
        //  System.out.println(stack.pop());  // EmptyStackException


    }
}
