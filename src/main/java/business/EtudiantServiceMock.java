package business;

import dto.StudentDTO;

import java.util.List;

public class EtudiantServiceMock implements EtudiantService{
    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of(
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO(),
                new StudentDTO()
        );
    }

    @Override
    public void insertStudent(StudentDTO toInsert) {

    }
}
