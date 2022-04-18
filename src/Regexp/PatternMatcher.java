package Regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcher {
    public static void main(String[] args) {
        String text = "Hello gaiz I send email to Johni his mail is johni@mail.ru and he responds back" +
                "from da mail wau@gmail.com also I share another mail is mamail@yandex.ru ";

        Pattern email = Pattern.compile("(\\w+)@(mail|gmail|yandex)\\.(ru|com)");
        Matcher matcher = email.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
