package foundation.file.watcher.test;

/**
 * User: gaozhan
 * Date: 1/3/14
 * Time: 2:27 PM
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;

public class DirFilterWatcher implements FileFilter {
    private String filter;

    public DirFilterWatcher() {
        this.filter = "";
    }

    public DirFilterWatcher(String filter) {
        this.filter = filter;
    }

    public boolean accept(File file) {
        if ("".equals(filter)) {
            return true;
        }
        return (file.getName().endsWith(filter));
    }
}