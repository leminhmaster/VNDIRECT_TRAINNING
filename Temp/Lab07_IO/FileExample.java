import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileExample {

    private static long getSize(File file){
        if ((file.isFile())) return file.length();

        File [] files = file.listFiles();
        int length =0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()) {
                length += getSize(files[i]);
                continue;
            }
            System.out.println(files[i].getName() + " : "+files[i].length() + " bytes");
            length += files[i].length();
            System.out.println();
        }
        return length;

    }

    public static void main(String[] args) {
        String homedir = System.getProperty("user.home");
        File file = new File(homedir+"/Temp/Lab01_Basic");
        System.out.println("This is "+ (file.isFile()? "file":"folder"));
//        List<File> files = Arrays.asList(file.listFiles());
//        for (File f:files) {
//            System.out.println(f.getName() + " : "+f.length() + " bytes");
//        }
        System.out.println("Size: "+getSize(file)+" byte");
    }
}
