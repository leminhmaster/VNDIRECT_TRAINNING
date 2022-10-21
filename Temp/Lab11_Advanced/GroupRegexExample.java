import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\w+)(\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        String text = "tôi học java.";
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
            System.out.println(matcher.group(4));
        }else{
            System.out.println("NO MATCH");
        }

    }
}
