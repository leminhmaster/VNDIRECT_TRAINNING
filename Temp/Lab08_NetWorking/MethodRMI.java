public class MethodRMI implements RMIMethod{

    @Override
    public String writeMethod(String name) throws Exception {
        return "Hello "+name;
    }
}
