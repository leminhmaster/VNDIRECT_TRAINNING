import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifiersRegexExample {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("t?\\S+(\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        String text = "tớ học java";
        Matcher matcher = pattern.matcher(text);
        System.out.println(text+"--------->"+matcher.matches());

        text="Cậu học java";
        matcher = pattern.matcher(text);
        System.out.println(text+"--------->"+matcher.matches());

        text="tttôi học java";
        matcher = pattern.matcher(text);
        System.out.println(text+"--------->"+matcher.matches());

        pattern = Pattern.compile("t*\\S+ (\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        pattern = Pattern.compile("t*\\S+ (\\S+)(.*)",Pattern.UNICODE_CHARACTER_CLASS);
        String regex = "t{2,}\\S+ (\\S+)(.*)";
        regex ="t{2,5}\\S+ (\\S+)(.*)";
    }
}
