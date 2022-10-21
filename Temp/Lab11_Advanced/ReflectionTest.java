import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionTest {
    public static void explore(Object obj) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class clazz = obj.getClass();
        System.out.println("clazz name: "+clazz.getName());
        //lay ra truong trong class
        Field field = clazz.getDeclaredField("TOTAL");
        field.setAccessible(true);
        System.out.println("total value is "+field.get(obj));
        //
        Field field1 = clazz.getDeclaredField("TOTAL1");
        field1.setAccessible(true);
        System.out.println("total value is "+field1.get(obj));

//        Field modifiField = Field.class.getDeclaredField("modifiers");
//        modifiField.setAccessible(true);
//        modifiField.set(field1,field1.getModifiers()&~Modifier.FINAL);
//        field1.setInt(obj,23);
//        System.out.println("modified value of the total field is "+field1.get(obj));

        //lay ra method khong dai dine cua class
        Method method = clazz.getDeclaredMethod("getTotal");
        method.setAccessible(true);
        System.out.println("method return value is "+method.invoke(obj,new Object[0]));
        Method method2 = clazz.getDeclaredMethod("getTotal",new Class[]{int.class});
        method2.setAccessible(true);
        System.out.println("method return value is "+method2.invoke(obj,new Object[]{5}));


    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(TotalCaculator.class,"getTotal", MethodType.methodType(long.class,short.class));

        Object obj = new TotalCaculator();
        System.out.println(mh.invoke(obj,(short)23));
        explore(obj);
    }
}

class TotalCaculator{
    int TOTAL = 3;
    private int TOTAL1 =343;

    private int getTotal(){
        return TOTAL;
    }
    private int getTotal(int value){
        return TOTAL+value;
    }
    @Test(34)
    public long getTotal(short value){return TOTAL+value;}
    @Test(100)
    private void print(int value){
        System.out.println(" gia tri them vao la "+value);
    }
}