import data_access.SectionDAO;
import data_access.SectionDAOImpl;
import model.Section;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        SectionDAO dao = new SectionDAOImpl();

        System.out.println("-- GET ALL --");
        List<Section> sections = dao.getAll();
        sections.forEach( sect -> System.out.format("%d - %s - %d\n", sect.getId(), sect.getName(), sect.getDelegateId()));

        System.out.println("-- GET ONE --");
        Section section = dao.getOne(1010);
        System.out.format("%d - %s - %d\n", section.getId(), section.getName(), section.getDelegateId());


        System.out.println("-- INSERT --");
        Section section1 = new Section( 9999, "test insert", 12 );
        if( dao.insert(section1) )
            System.out.println("success");
        else
            System.out.println("failure");

        section = dao.getOne(9999);
        System.out.format("%d - %s - %d\n", section.getId(), section.getName(), section.getDelegateId());


        System.out.println("-- UPDATE --");
        section1.setName("test modified");
        section1.setDelegateId(18746);
        if( dao.update( section1 ) )
            System.out.println("success");
        else
            System.out.println("failure");

        section = dao.getOne(9999);
        System.out.format("%d - %s - %d\n", section.getId(), section.getName(), section.getDelegateId());


        System.out.println("-- DELETE --");
        if( dao.delete(section1.getId()) )
            System.out.println("success");
        else
            System.out.println("failure");

    }

}
