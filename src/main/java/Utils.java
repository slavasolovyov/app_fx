import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    private String exceptionName = "OK";

    public void setExceptionName(String exceptionName) {
        this.exceptionName = exceptionName;
    }

    public String getExceptionName() {
        return exceptionName;
    }

    public static String getCurrentDate(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(date);
    }

    public int isValidInput(String s){
        int result = 0;
        try{
            result = Integer.parseInt(s);
        }catch (NumberFormatException e){
           exceptionName = e.getClass().getName();
           System.out.println(exceptionName);
        }
        return result;
    }



    public static void main(String[] args) throws Throwable {
        Utils utils = new Utils();

    }
}
