package business;

import dto.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface EtudiantService {
    List<StudentDTO> getAllStudents() throws SQLException;
    void insertStudent( StudentDTO toInsert );
}
