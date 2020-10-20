package vn.com.cmcglobal.dao;

import vn.com.cmcglobal.model.Student;

import java.util.List;

/**
 * @author nvdat2
 */
public interface IStudentDao {
    List<Student> selectAllStudents();

    Student getStudentById(Long id);

    void insertStudent(Student student);

    void updateStudent(Student student);

    void deleteStudentById(Long id);
}
