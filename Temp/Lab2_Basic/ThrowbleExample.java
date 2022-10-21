import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowbleExample {
    public static class SaiSoExeption extends  Exception{
        private String so;
        public SaiSoExeption(String so){
            this.so = so;
        }

        @Override
        public String getMessage() {
            return "Gia tri \'"+so+"\' khong phai so!";
        }
    }
    private final static Logger LOGGER = Logger.getLogger(ThrowbleExample.class.getName());
    static int toNumber(String value) throws SaiSoExeption {
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (NumberFormatException e){
            throw new SaiSoExeption(value);
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("number = "+ toNumber("11a"));
        } catch (SaiSoExeption e) {
            //System.err.println(e.getMessage());
            LOGGER.log(Level.WARNING,e.getMessage());
        }
    }
}
