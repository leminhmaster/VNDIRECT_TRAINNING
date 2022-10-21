import java.awt.*;
import java.io.*;
import java.lang.reflect.Method;

public class ObjectWriterExample {
    public static void main(String[] args) throws Exception {
        String homedir = System.getProperty("user.home");
        File folder = new File(homedir+File.separator+"Temp"+File.separator);
        ObjectOutputStream output = null;
        FileOutputStream fileOutput = new FileOutputStream(new File(folder,"my_object"));
        output = new ObjectOutputStream(fileOutput);
        //PrintMessage printMessage = new PrintMessage("Le Duc Minh");

        output.writeObject(new PrintMessage("Can Noi Noi"));

        output.close();

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(new File(folder,"my_object")));
        Object obj = input.readObject();
        Method method = obj.getClass().getMethod("run",new Class[0]);
        method.invoke(obj,new Object[0]);
        input.close();

        Desktop.getDesktop().open(folder);
    }
}
