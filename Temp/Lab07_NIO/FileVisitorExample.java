import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorExample {
    public static class PrintFiles extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.toString()+" is File");
            return FileVisitResult.SKIP_SUBTREE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            System.out.println(dir.toString()+" is Directory");
            return FileVisitResult.TERMINATE;
        }
    }
    public static void main(String[] args) throws IOException {
        String homedir = System.getProperty("user.home");
        File sourceFile = new File(homedir+File.separator+"Temp");
        Path path  = Paths.get(homedir+File.separator+"Temp");
        Files.walkFileTree(path, new PrintFiles());
    }
}
