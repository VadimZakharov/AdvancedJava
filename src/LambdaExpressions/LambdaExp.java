package LambdaExpressions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface Executable{
    int execute(int x,int y);

}

class Runner{
    public void run(Executable e){

      int a = e.execute(10,15);
        System.out.println(a);
    }
}

public class LambdaExp {
    public static void main(String[] args) {
       Runner runner = new Runner();

       runner.run(new Executable() {
           @Override
           public int execute(int x, int y) {
               return x + 2 + y;
           }
       });

       runner.run((int x, int y) -> 10 + x + y);

       ForExample forExample = new ForExample();
       forExample.test();

    }
}

class ForExample{


    public void test(){
        List<String> list = new ArrayList<>();
        list.add("Some");
        list.add("letters");
        list.add("to");
        list.add("add");
        list.add("in");
        list.add("list");

        list.sort(Comparator.comparingInt(String::length));
        System.out.println(list);
    }
}
