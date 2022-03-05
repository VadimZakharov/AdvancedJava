package JavaCollectionsFramework.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

// очередь перевый зашел первый вышел
public class myQueue {
    public static void main(String[] args) {
        Person person1 = new Person(1);
        Person person3 = new Person(3);
        Person person2 = new Person(2);
        Person person4 = new Person(4);

        Queue<Person> people = new LinkedList<>();
        people.add(person3);
        people.add(person2);
        people.add(person1);
        people.add(person4);

        // person3 <- person2 <- person1 <- person4

        for (Person person: people){
            System.out.println(person);
        }

        Queue<Person> arrayBlockingQueue = new ArrayBlockingQueue<Person>(10); // ограничевает очередь числом
        arrayBlockingQueue.add(person3);
        arrayBlockingQueue.add(person1);
        arrayBlockingQueue.add(person2);
        arrayBlockingQueue.add(person4);

        arrayBlockingQueue.remove(); //удаляет эллемент из очереди по умолчанию с головы
        arrayBlockingQueue.remove(person2); // можно указать конкретный эллемент
        System.out.println(arrayBlockingQueue);


        System.out.println(arrayBlockingQueue.peek()); // показывает элемент из очереди с головы

        //////////////////////////*********************\\\\\\\\\\\\\\\\\\\\\\\\\
        // Выбрасывает исключение                       Специальное хначение\\
        // .add                                         .offer   True/False               Добавление элемента
        // .remove                                      .poll                             Удаление элемента
        // .element                                     .peek                             Отображение элемента
    }
}
class Person{
    private int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public String
    toString() {
        return "Person{" +
                "id=" + id +
                '}';
    }
}