package util;

import DBO.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class StudentUtil {

    int x = 1;
    int y = 10;
    int a = x + (int) (Math.random() * ((y - x) + 1));


    static List<String> names = Arrays.asList("Ilya", "Dima", "Vova", "Valery", "Matvei", "Sergey");


    public static List<Student> generateStudent(int num) {
        Student student = null;
        Random random = new Random();
        int x = 1;
        int y = 10;
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int a = x + (int) (Math.random() * ((y - x) + 1));
            int nameCount = random.nextInt(names.size());
            student = Student.builder().name(names.get(nameCount)).mark(a).build();
            students.add(student);
        }
        return students;
    }

}
