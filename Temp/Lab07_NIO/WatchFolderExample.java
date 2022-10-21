import jdk.jshell.Snippet;

import java.io.File;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

public class WatchFolderExample {
    public static void watch(Path path){
        FileSystem fs = path.getFileSystem();
        try(WatchService service = fs.newWatchService()){
            path.register(service,ENTRY_CREATE);
            while(true){
                WatchKey key = service.take();
                for (WatchEvent watchEvent: key.pollEvents()) {
                    WatchEvent.Kind kind = watchEvent.kind();
                    if (ENTRY_CREATE == kind){
                        Path newPath = ((WatchEvent<Path>) watchEvent).context();
                        System.out.println("new Path created : "+newPath);
                    }
                }
                if (!key.reset()) break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp");
        Path path  = Paths.get(homedir+File.separator+"Temp");
        watch(path);
    }
}
