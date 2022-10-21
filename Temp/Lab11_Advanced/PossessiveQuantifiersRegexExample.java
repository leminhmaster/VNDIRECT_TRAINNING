import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifiersRegexExample {
    public static void main(String[] args) {
        String text = "nanaminhniniminh";
        Pattern pattern = Pattern.compile("(.*)+mi");
        Matcher matcher = pattern.matcher(text);
        System.out.println("possessive -----> "+matcher.find());
        System.out.println(text.substring(matcher.start(),matcher.end()));
    }
}
