package JavaCollectionsFramework.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MyCheck {
    List<String> names = new ArrayList<>();


    public void namesfromkeybord() throws RuntimeException{
        Scanner sc = new Scanner(System.in);

        int counter =  0;
        while (sc.hasNextLine()){

            if (counter < 10){

                String user = sc.nextLine();
                names.add(counter,user);

                counter++;
            continue;}
            else {

                System.out.println("Enough");
                break;
        }

        }

    }
    public String toString(){
        String [] tempnames = names.toArray(new String[0]);
        return Arrays.toString(tempnames);
    }

}
