package util;

import DBO.Courses;
import DBO.Student;
import DBO.Teacher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TeachersUtil {

    int x = 1;
    int y = 10;
    int a = x + (int) (Math.random() * ((y - x) + 1));

    static List<String> names = Arrays.asList("Ilya", "Dima", "Vova", "Valery", "Matvei", "Sergey");
    static List<String> revieew = Arrays.asList("Goog", "Bad", "Very nice");

    public static List<Teacher> generateTeachers(int num) {
        Teacher teacher = null;
        Random random = new Random();
        int x = 1;
        int y = 10;
        List<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int a = x + (int) (Math.random() * ((y - x) + 1));
            int revieewCount = random.nextInt(revieew.size());
            int nameCount = random.nextInt(names.size());
            Courses courses = new Courses();
            courses.setId(i);
            teacher = Teacher.builder().review(revieew.get(revieewCount)).name(names.get(nameCount)).courses(courses).build();
            teachers.add(teacher);
        }
        return teachers;
    }
}
