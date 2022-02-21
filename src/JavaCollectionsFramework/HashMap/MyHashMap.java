package JavaCollectionsFramework.HashMap;



import java.io.FileNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MyHashMap  {

    public static void main(String[] args) throws FileNotFoundException {

        User user = new User();
        System.out.println("Добро пожаловать");
        System.out.println("Новый пользователь?");
        Scanner sc = new Scanner(System.in);
        String userAnswer = sc.nextLine();
        switch (userAnswer){
            case "Да": user.newUser();
            break;
            case "Нет": user.existUser();
            break;

        }

    }

}
class User {

    Map<String, String> userNamePass = new HashMap<>();

    private String name;
    private String pass;


    void newUser() throws FileNotFoundException {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        user.userEnterLogin();
        name = sc.nextLine();
        user.userEnterPass();
        pass = sc.nextLine();
        userNamePass.put(name,pass);

        System.out.println("Данные сохранены");

        System.out.println("Войти?");
        String answer = sc.nextLine();
        switch (answer){
            case "Да" : {
                user.userEnterLogin();
                String userName = sc.nextLine();
                user.userEnterPass();
                String userPass = sc.nextLine();


                if (userNamePass.containsKey(userName) && userNamePass.containsValue(userPass)){
                    System.out.println("Поздравляю вы вошли на сайт");
                    break;
                } else {
                    System.out.println("Введеные данные не верны");
                    user.existUser();
                }

            }

            case "Нет" : {
                System.out.println("Ну всё откалывайся:)");
                break;
            }

        }


    }
    void existUser(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введи имя пользователя");
        String userName = sc.nextLine();
        System.out.println("Введи пароль");
        String userPass = sc.nextLine();
        if (userNamePass.containsKey(userName) && userNamePass.containsValue(userPass)){
            System.out.println("Поздравляю вы вошли на сайт");
        } else {
            System.out.println("Введеные данные не верны");
            existUser();
        }

    }

    public void userEnterLogin(){
        System.out.println("Введи имя пользователя");

    }
    public void userEnterPass(){
        System.out.println("Введи пароль");
    }


    }





