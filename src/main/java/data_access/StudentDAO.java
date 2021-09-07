package data_access;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // region singleton
    private static StudentDAO instance;
    public static StudentDAO getInstance(){
        return instance == null ? instance = new StudentDAO() : instance;
    }
    private StudentDAO() {
    }
    // endregion

    public List<Student> getAll() throws SQLException {

        try(
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stmt = connection.prepareStatement(" SELECT student_id, first_name, last_name, year_result,section_id FROM student ");
                ResultSet rs = stmt.executeQuery()
        ) {
            List<Student> list = new ArrayList<>();
            while( rs.next() ){
                list.add(convertToStudent(rs));
            }
            return list;
        }

    }

    private Student convertToStudent(ResultSet rs) throws SQLException {

        return new Student(
                rs.getLong(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getInt(5)
        );

    }

}
