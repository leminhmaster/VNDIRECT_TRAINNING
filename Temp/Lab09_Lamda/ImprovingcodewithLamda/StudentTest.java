package ImprovingcodewithLamda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;
import java.util.stream.Stream;

public class StudentTest {
    public static List<Student> filter(List<Student> students,Filter<Student> pred){
        List<Student> list = new ArrayList<>();
        for (Student s: students) {
            if (pred.valid(s)) list.add(s);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,23,"Nguyen thi A1"));
        students.add(new Student(1,23,"Nguyen thi A2"));
        students.add(new Student(1,230,"Nguyen thi A3"));
        students.add(new Student(1,231,"Nguyen thi A4"));

//        Filter<Student> older = student -> {return student.getAge() >= 30;};
//        List<Student> filtered = filter(students,older);
//        filtered.stream().forEach(s-> System.out.println(s));
        ///////////////////////////////////////////////////////
//        Stream<Student> stream = students.stream().filter(student -> student.getAge() > 30);
//        stream.forEach(student -> System.out.println(student));
        //////////////////////////////
//        Collections.sort(students,(Student s1,Student s2)->{
//            return s1.getAge() - s2.getAge();
//        });
//        students.forEach(student -> System.out.println(student));
        /////////////////////////////////
        Stream<Student> stream = students.stream().sorted((Student s1,Student s2)->{return s1.getAge()- s2.getAge();});
        stream.forEach(s-> System.out.println(s));

        Comparator<Student> comparator = (Student s1,Student s2)->{
            return s1.getAge()- s2.getAge();
        };
        Stream<Student> stream1 = students.stream().sorted(comparator);
        stream1.forEach(student -> System.out.println(student));

        System.out.println("\n max is "+students.stream().max(comparator));

        //int sum = students.stream().mapToInt(Student::getAge).sum();
        int sum = students.stream().mapToInt(s->{return s.getAge();}).sum();
        System.out.println("Average of age is "+sum/students.size());

        students.parallelStream().forEach(new Consumer<Student>() {
            @Override
            public void accept(Student student) {
                System.out.println(Thread.currentThread().getName() + " hello "+student.getName());
            }
        });
    }
}
