import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }




    public static void main(String[] args) throws Throwable {
        Utils utils = new Utils();

    }
}
