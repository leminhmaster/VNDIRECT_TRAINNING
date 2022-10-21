import ImprovingcodewithLamda.Student;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaUnitFunction {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Consumer<Student> c = s->{
          if (s.getAge() > 23) s.setAge(23);
          students.add(s);
        };
        c.accept(new Student(1,34,"NgUYEN vAN a"));

        System.out.println(students.get(0));

        String[] names = {"Tran Van A","Nguyen thi B","Nguyen thi C","Ta van C"};
        int [] ages ={23,45,12,67};
        IntStream intStream = IntStream.rangeClosed(0, names.length-1);
        Stream stream = intStream.mapToObj(value -> new Student(1,ages[value],names[value]));
        Consumer<Student> c1 = s->{
            System.out.println(s);
        };
        //stream.forEach(c1);

        Function<Student,String> jsontoFunction= s->{
            StringBuilder builder = new StringBuilder();
            builder.append("student {\n");
            builder.append("\tid:").append(s.getId()).append("\n");
            builder.append("\tname:").append(s.getName()).append("\n");
            builder.append("\tage:").append(s.getAge()).append("\n");
            builder.append("}");
            return builder.toString();
        };
        c = s->{
            System.out.println(jsontoFunction.apply(s));
        };

        Consumer<Student> c2 = s->{
            System.out.println(jsontoFunction.apply(s));
        };
        Predicate<Student> predicate = s->{return s.getAge()>30;};
        Stream<Student> older = stream.filter(predicate);
        older.forEach(c2);

        Supplier<Student> supplier =()->{
            return  new Student(1,27,"LE DUC MINH");
        };
        System.out.println(jsontoFunction.apply(supplier.get()));
    }
}
