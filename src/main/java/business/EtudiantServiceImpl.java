package business;

import data_access.StudentDAO;
import dto.StudentDTO;
import business.mapper.StudentMapper;
import model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class EtudiantServiceImpl implements EtudiantService {

    private final StudentDAO studentDAO = StudentDAO.getInstance();
    private final StudentMapper mapper = new StudentMapper();

    @Override
    public List<StudentDTO> getAllStudents() throws SQLException {

        List<Student> listStudent = studentDAO.getAll();

        return listStudent.stream()
                .map(mapper::mapToDto)
                .collect(Collectors.toList());

    }

    public void insertStudent( StudentDTO toInsert ){

    }
}
