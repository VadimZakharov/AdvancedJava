package Tasks;


import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = {100, 7, 9, 5,69,56,93,15,20,30,40,50,60,88};
        bubleSort(array);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

    }
    private static void bubleSort(int [] array){
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                }

            }
        }
    }

}