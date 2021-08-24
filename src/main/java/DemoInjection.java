import data_access.SectionDAO;
import data_access.SectionDAOImpl;
import model.Section;

public class DemoInjection {

    public static void main(String[] args) {

        SectionDAO dao = new SectionDAOImpl();

        dao.delete(1);

        Section section = new Section( 9999, "test insert", 12 );
        if( dao.insert(section) )
            System.out.println("success");
        else
            System.out.println("failure");

        String requete = " UPDATE Section " +
        " SET section_name = \"\", section_id=0001, section_name=\""+section.getName() + "\", delegate_id = " + section.getDelegateId() +
        " WHERE section_id = " + section.getId();

        section.setName( "\", section_id=0001, section_name=\""+section.getName() );
        dao.update( section );

    }

}
