import org.junit.Before;
import org.junit.Test;
import vn.com.cmcglobal.dao.IStudentDao;
import vn.com.cmcglobal.dao.StudentDaoImpl;
import vn.com.cmcglobal.model.Student;

import java.util.List;

public class StudentTest {
    private IStudentDao studentDao;

    @Before
    public void before(){
        studentDao = new StudentDaoImpl();
    }

    @Test
    public void getAllStudents(){
        List<Student> students = studentDao.selectAllStudents();
        if (students.size()>0){
            for (Student student: students){
                System.out.println(student);
            }
        }
    }

    @Test
    public void getStudentById(){
        Student student = studentDao.getStudentById(1L);
        System.out.println(student);
    }

    @Test
    public void insertStudent(){
        Student student = new Student("Nguyen Trong Cuong",26, 70);
        studentDao.insertStudent(student);
    }

    @Test
    public void updateStudent(){
        Student student = new Student("John Conner", 25, 60);
        student.setId(3L);
        studentDao.updateStudent(student);
    }

    @Test
    public void deleteStudentById(){
        studentDao.deleteStudentById(3L);
    }
}
