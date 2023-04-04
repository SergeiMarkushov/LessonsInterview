package ru.markush.lessonFive;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.math.BigDecimal;


public class HibernateRun {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory()) {
            StudentDao dao = new StudentDao(sessionFactory);
//            dao.addRandomStudents(); добавление 1000 студентов
            dao.addStudent(Student.builder()
                    .name("SOME NEW STUDENT")
                    .mark(new BigDecimal("5.5"))
                    .build());

            dao.deleteStudent(dao.getStudentById(3L)); // удаление
            Student updateStudent = dao.getStudentById(4L); // обновление (начало)
            System.err.println(updateStudent.toString());
            updateStudent.setName("UPDATED STUDENT");
            dao.updateStudent(updateStudent); // обновление (конец)
            System.out.println(dao.getStudentById(4L).toString()); // достаем измененного студента

            dao.getAllStudents().forEach(System.out::println);

        }
    }
}


/**
 * Student(id=2, name=Student 1, mark=12)
 * Student(id=5, name=Student 4, mark=55)
 * Student(id=6, name=Student 5, mark=40)
 * Student(id=7, name=Student 6, mark=9)
 * Student(id=8, name=Student 7, mark=75)
 * ......................................
 * Student(id=150, name=Student 149, mark=85)
 * Student(id=4, name=UPDATED STUDENT, mark=89)
 * Student(id=151, name=Student 150, mark=98)
 * Student(id=152, name=Student 151, mark=39)
 * .......................................
 * Student(id=1000, name=Student 999, mark=1)
 * Student(id=1001, name=Student 1000, mark=72)
 * Student(id=1002, name=SOME NEW STUDENT, mark=5.5)
 */