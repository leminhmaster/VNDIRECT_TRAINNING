import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateTimeFormatExample {

     String getTypeOfDay( Calendar calendar){
        String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi"));
        switch (type){
            case "Th 2":
                return "Start of work week";
            case "Th 3":
                return "Second day work";
            case "Th 4":
                return "Mid week";
            case "Th 5":
                return "Mid week";
            case "Th 6":
                return "End of work week";
            case "Th 7":
                return "go out";
            case "CN":
                return "Weekend";
            default:
                return "Unknown";
        }
    }

    public static void main(String[] args) {
        Locale locale = new Locale("vi","VN");
        DateFormat dateFormat = new SimpleDateFormat("EEEEE , dd MMMMMyyyy",locale);
        Calendar calendar = Calendar.getInstance();
        System.out.println(dateFormat.format(calendar.getTime()));
        DateTimeFormatExample dateTimeFormatExample = new DateTimeFormatExample();
        Calendar calendar1 = Calendar.getInstance();
        System.out.println(calendar1.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi")));
        System.out.println("Today is " + dateTimeFormatExample.getTypeOfDay(calendar1));
        calendar1.set(Calendar.DATE,calendar1.get(Calendar.DATE)+1);
        System.out.println(calendar1.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.SHORT,new Locale("vi")));
        System.out.println("Tomorrow is "+ dateTimeFormatExample.getTypeOfDay(calendar1));
    }
}
