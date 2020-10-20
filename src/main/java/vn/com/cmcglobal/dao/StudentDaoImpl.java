package vn.com.cmcglobal.dao;

import org.apache.ibatis.session.SqlSession;
import vn.com.cmcglobal.model.Student;
import vn.com.cmcglobal.utils.StudentUtils;

import java.util.List;

/**
 * @author nvdat2
 */
public class StudentDaoImpl implements IStudentDao {
    private SqlSession sqlSession;

    public List<Student> selectAllStudents() {
        List<Student> students;
        try {
            sqlSession = StudentUtils.getSqlSession();
            students = sqlSession.selectList("selectAllStudents");
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return students;
    }

    public Student getStudentById(Long id) {
        Student student;
        try {
            sqlSession = StudentUtils.getSqlSession();
            student = sqlSession.selectOne("getStudentById", id);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return student;
    }

    public void insertStudent(Student student) {
        try {
            sqlSession = StudentUtils.getSqlSession();
            sqlSession.insert("insertStudent", student);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void updateStudent(Student student) {
        try {
            sqlSession = StudentUtils.getSqlSession();
            sqlSession.update("updateStudent", student);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void deleteStudentById(Long id) {
        try {
            sqlSession = StudentUtils.getSqlSession();
            sqlSession.delete("deleteStudentById", id);
            sqlSession.commit();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
