import java.util.ArrayList;

/**
 * Created by gfn on 2017/5/4.
 */
public class test {

    public static void main(String[] args) {
        ArrayList a = new ArrayList();
        Object obj = new Object();
        for (int i = 0; i < 100000000; i++) {
            a.add(obj);
        }
        Object temp;
        long start_time = System.currentTimeMillis();
        for (int i = 0; i < a.size(); i++) {
            temp =a.get(i);
        }
        long end_time = System.currentTimeMillis();
        System.out.println("for用时" + (end_time - start_time));
        start_time = System.currentTimeMillis();
        for (Object i: a) {
            temp = i;
        }
        end_time = System.currentTimeMillis();
        System.out.println("for用时" + (end_time - start_time));
    }
}
