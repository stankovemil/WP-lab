package mk.ukim.finki.wp.lab.repository;


import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Repository
public class StudentRepository {


    public static List<Student> students = new ArrayList<>();


    @PostConstruct
    public void init(){
        students.add(new Student("student1","password1","student1","Stankov"));
        students.add(new Student("student2","password2","Student2","Stankov"));
        students.add(new Student("student3","password3","student3","Stankov"));
        students.add(new Student("student4","password4","Student4","Stankov"));
        students.add(new Student("student5","password5","student5","Stankov"));
    }


    public List<Student> findAllStudents(){
            return this.students;
    };


    public List<Student> findAllByNameOrSurname(String text){
            List<Student> result = new ArrayList<>();
            for (Student s:students)
            {
                if (s.getName().contains(text) || s.getSurname().contains(text)){
                    result.add(s);
                }
            }
            return result;
        };

    public Student findStudentByUsername(String username){
        for (Student s:students){
            if (s.getUsername().equals(username)) return s;
        }

        return null;
    }

    public Student save(Student student){
        students.add(student); //treba da proveram dali ima dali nema
        return student;
    }

}
