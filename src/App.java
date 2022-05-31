import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class App {
    public static void main(String[] args) throws Exception {
        // Scanner sc = new Scanner(System.in);
        // while (sc.hasNextInt()) {
        //     // String s = sc.nextLine();
        //     int year = sc.nextInt();
        //     // System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
        //     System.out.println(122 - year);
        // }
        // // System.out.println("Hello, World!");
        // sc.close();
        // int min = 1000;
        // int max = -1;
        // int n=1000;
        // while(n-->0){
            
        //     Random r = new Random();   
        //     int kk = r.nextInt( (int)(Math.pow(2, 4))-2 ) +2 ;
        //     min = Math.min(min,kk);
        //     max = Math.max(max, kk);
            
           
        // }
        // System.out.println( min);
        // System.out.println(max); 

        // int nowAction = 0;
        // int now=0;
        // while(now>=0){
        //     now = getNextAction(2,nowAction,5);
        //     System.out.println(now);
        //     nowAction = now;
        // }
        
    }

    public static int getNextAction(int actionStore, int nowAction, int actionNums) {
        nowAction++;
        while(nowAction < actionNums) {
            if( (actionStore & (1<<nowAction)) != 0 ){
                return nowAction;
            }else{
                nowAction++;
            }
        }
        return actionNums-1;
    }
}
