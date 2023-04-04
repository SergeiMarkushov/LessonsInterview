package ru.markush.lessonFive;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

public class StudentDao {
    private SessionFactory sessionFactory;

    public StudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
    }


    public void updateStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();
    }

    public void deleteStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
    }

    public Student getStudentById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.getTransaction().commit();
        return student;
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Student> students = session.createQuery("from Student").getResultList();
        session.getTransaction().commit();
        return students;
    }

    public void addRandomStudents() {
        Random rand = new Random();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        for (int i = 1; i <= 1000; i++) {
            String name = "Student " + i;
            double mark = rand.nextInt(100) + 1;
            Student student = Student.builder()
                    .name(name)
                    .mark(new BigDecimal(mark))
                    .build();
            session.save(student);
        }

        session.getTransaction().commit();
    }
}