package Regexp;

public class RegExp {
    public static void main(String[] args) {
        /*

        https://regexlib.com/CheatSheet.aspx?AspxAutoDetectCookieSupport=1

         \\d - одна цифра
         \\w - одна буква  == [a-zA-Z]

           + - 1 или более
           * - 0 или более
           ? - символ может быть, а может и не быть
           (| |) - вариации

           [a-zA-Z] - все англ буквы
           [0-9] - все цифры
           [^] - символ отрицания

           . - любой символ

           {2} - два символа до (\\d{2})
           {2,} - два или более символа (\\d{2,})
           {2,  4} - от 2х до 4х символов (\\d{2,4})
         */

        String a = "465464";
        String c = "-4566";
        String b = "+464654";
        System.out.println(a.matches("\\d*"));
        System.out.println(c.matches("-\\d+"));
        System.out.println(b.matches("(-|\\+)?\\d+"));


        String d = "aasfasfasf46464";
        System.out.println(d.matches("[a-zA-z]+\\d+"));

        String s = "Hello";
        System.out.println(s.matches("[^abc]*"));

        String url = "https://www.google.com";

        System.out.println(url.matches("https://www\\..+\\.(com | ru)"));
    }
}
