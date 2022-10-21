import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandlerExample {
    public static void main(String[] args) throws Throwable {
        TotalCaculator obj = new TotalCaculator();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
//        MethodHandle mh2 = lookup.findStatic(obj.getClass(),"calculate", MethodType.methodType(String.class));
//        System.out.println((String)mh2.invokeExact());
        MethodHandle mh = lookup.findSetter(obj.getClass(),"TOTAL",int.class);
        mh.invoke(obj,15);
        mh=lookup.findVirtual(obj.getClass(),"getTotal",MethodType.methodType(long.class,short.class));
        System.out.println(mh.invoke(obj,(short)23));

        mh = MethodHandles.insertArguments(mh,1,(short)10);
        System.out.printf("total = %d ",mh.invoke(obj));
    }
}
