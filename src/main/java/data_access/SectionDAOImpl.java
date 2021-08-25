package data_access;

import model.Section;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SectionDAOImpl implements SectionDAO {
    @Override
    public boolean insert(Section section) {


        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stmt = connection.prepareStatement(" INSERT INTO Section " +
                        " VALUES ( ? , ? , ? ); ");
        ) {

            stmt.setInt(1, section.getId());
            stmt.setString(2, section.getName());
            stmt.setInt(3, section.getDelegateId());

            int nbrLinesAffected = stmt.executeUpdate();

            return nbrLinesAffected > 0;

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;

    }



    private Section convertToSection(ResultSet rs) throws SQLException {

        int id = rs.getInt("section_id");
        String name = rs.getString("section_name");
        int delegateId = rs.getInt("delegate_id");

        return new Section(id, name, delegateId);

    }
    @Override
    public Section getOne(Integer id) {

        try(
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement stmt = connection.prepareStatement(" SELECT * FROM Section WHERE section_id = ? ")
        ) {
            stmt.setInt(1, id);
            try( ResultSet rs = stmt.executeQuery() ){
                if( rs.next() ){
                    return convertToSection( rs );
                }
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return null;

    }
    @Override
    public List<Section> getAll() {
        try(
                Connection connection = ConnectionFactory.getConnection();
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(" SELECT * FROM Section; ");
        ) {

            List<Section> list = new ArrayList<>();
            while( rs.next() ){
                list.add( convertToSection(rs) );
            }
            return list;

        }
        catch (SQLException ex){
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean update(Section section) {

        try (
                Connection co = ConnectionFactory.getConnection();
                PreparedStatement stmt = co.prepareStatement(" UPDATE Section " +
                        " SET section_name = ?, delegate_id = ? " +
                        " WHERE section_id = ?");
        ){
            stmt.setString(1, section.getName());
            stmt.setInt(2, section.getDelegateId());
            stmt.setInt(3, section.getId());

            int affected = stmt.executeUpdate();
            return affected > 0;
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean delete(Integer id) {

        try (
                Connection co = ConnectionFactory.getConnection();
                Statement stmt = co.createStatement();
        ){
            int affected = stmt.executeUpdate(" DELETE FROM Section WHERE section_id = "+ id );
            return affected > 0;
        }
        catch( SQLException ex ){
            ex.printStackTrace();
        }
        return false;
    }
}
