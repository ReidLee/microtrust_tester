package microtrust.utils;
import java.io.*;
import microtrust.utils.MyLog;

public class CallShell
{
    public CallShell()
    {

    }


    public static void execCommand(String command) throws IOException
    {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command);        //这句话就是shell与高级语言间的调用
        InputStream inputstream = proc.getInputStream();
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader bufferedreader = new BufferedReader(inputstreamreader);
        String line = "";
        StringBuilder sb = new StringBuilder(line);
        while ((line = bufferedreader.readLine()) != null) {
                sb.append(line);
                sb.append('\n');
        }
        try {
            if (proc.waitFor() != 0) {
                MyLog.error("exit value = " + proc.exitValue());
            }
        } catch (InterruptedException e) {
            MyLog.error(e.getMessage());
        }
    }



}
