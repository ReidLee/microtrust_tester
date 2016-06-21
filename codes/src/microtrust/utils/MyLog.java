package microtrust.utils;
import microtrust.Config;
import android.util.Log;

public class MyLog
{
    public MyLog()
    {

    }

    public static void error(String msg)
    {
        Log.e(Config.TAG,msg);
    }

    public static void info(String msg)
    {
        Log.i(Config.TAG,msg);
    }

    public static void debug(String msg)
    {
        Log.d(Config.TAG,msg);
    }


}
