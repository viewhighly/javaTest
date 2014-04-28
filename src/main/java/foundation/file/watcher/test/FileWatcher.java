package foundation.file.watcher.test;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.io.*;

public abstract class FileWatcher extends TimerTask {
    private long timeStamp;
    private File file;

    public FileWatcher( File file ) {
        this.file = file;
        this.timeStamp = file.lastModified();
    }

    public final void run() {
        long timeStamp = file.lastModified();

        if( this.timeStamp != timeStamp ) {
            this.timeStamp = timeStamp;
            onChange(file);
        }
    }

    protected abstract void onChange( File file );
}
//For a directory, a thread is launched where we keep the Files in a Map, we check the current lastModifed
// value of a given file and compare it with the value stored in the Map. Also a special check is made to detect
// if a File is deleted.
