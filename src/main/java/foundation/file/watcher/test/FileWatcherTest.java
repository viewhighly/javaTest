package foundation.file.watcher.test;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 2:26 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public class FileWatcherTest {
    public static void main(String args[]) {
        // monitor a single file
        TimerTask task = new FileWatcher( new File("c:/temp/text.txt") ) {
            protected void onChange( File file ) {
                // here we code the action on a change
                System.out.println( "File "+ file.getName() +" have change !" );
            }
        };

        Timer timer = new Timer();
        // repeat the check every second
        timer.schedule( task , new Date(), 1000 );
    }
}