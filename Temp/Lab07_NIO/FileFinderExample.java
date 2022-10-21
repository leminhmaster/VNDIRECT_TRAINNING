import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileFinderExample {
    static class Finder extends SimpleFileVisitor<Path>{
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (matcher.matches(file.getFileName())) System.out.println("found: "+file.toString());
            return FileVisitResult.CONTINUE;
        }


    }
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp");
        Path path  = Paths.get(homedir+File.separator+"Temp");
        Files.walkFileTree(path,new Finder());
    }
}
