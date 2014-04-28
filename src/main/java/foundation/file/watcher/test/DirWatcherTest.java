package foundation.file.watcher.test;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class DirWatcherTest {
    public static void main(String args[]) {
        TimerTask task = new DirWatcher("c:/temp", "txt" ) {
            protected void onChange( File file, String action ) {
                // here we code the action on a change
                System.out.println
                        ( "File "+ file.getName() +" action: " + action );
            }
        };

        Timer timer = new Timer();
        timer.schedule( task , new Date(), 1000 );
    }
}