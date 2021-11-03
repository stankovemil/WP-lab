package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Student;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {


    private final StudentRepository studentRepository;


    public static List<Course> courses = new ArrayList<>();

    public CourseRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }



    @PostConstruct
    public void init(){

        List<Student> students = this.studentRepository.findAllByNameOrSurname("student1");
        students.add((Student) this.studentRepository.findAllByNameOrSurname("student2"));
        courses.add(new Course(1L,"Web Programming" , "geo description" , students));

        courses.add(new Course(2L,"Operating Systems" , "hist description" , students));

        courses.add(new Course(3L,"EMT" , "music description" , students));

        courses.add(new Course(4L,"Computer Networks" , "sports description" , students));

        courses.add(new Course(5L,"Programming" , "prog description" , students));
    }


    public List<Course> findAllCourses(){
      return courses;
    };

    public Course findById(Long courseId){

        for (Course c:courses) {
            if (c.getCourseId() == courseId) return c;
        }

        return null; //ako ne go najde kursot
    };

   public List<Student> findAllStudentsByCourse(Long courseId) {
      return findById(courseId).getStudents();
    }

    public Course addStudentToCourse(Student student, Course course){
        for (Course c:courses) {
            if (c.equals(course)) {
                c.getStudents().add(student);
            }
        }
        return course;
    }

}

