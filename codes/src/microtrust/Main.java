package microtrust;
import android.util.Log;
import microtrust.utils.CallShell;
import java.io.IOException;
import microtrust.utils.MyLog;


public class Main
{
    public static void main(String[] args)
    {
        for(int i=0;i<10;i++) {
            MyLog.info("========================");
            try{
                CallShell.execCommand("echo lalala");
            } catch (IOException e) {
                MyLog.error(e.getMessage());
            }

        }
    }
}
