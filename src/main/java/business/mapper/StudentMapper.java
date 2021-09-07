package business.mapper;

import data_access.SectionDAO;
import data_access.SectionDAOImpl;
import dto.StudentDTO;
import model.Student;

public class StudentMapper {

    private final SectionDAO sectionDAO = new SectionDAOImpl();

    public StudentDTO mapToDto(Student model){
        return new StudentDTO(
                model.getId(),
                model.getFirstname()+" "+model.getLastname(),
                model.getYearResult(),
                sectionDAO.getOne(model.getSectionId()).getName()
        );
    }

}
