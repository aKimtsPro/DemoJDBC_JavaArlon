package data_access;

import model.Section;

import java.util.List;

public interface DAO<MODEL,ID> {

    // CREATE
    boolean insert(MODEL model);

    // READ
    MODEL getOne(ID id);
    List<MODEL> getAll();

    // UPDATE
    boolean update(MODEL model);

    // DELETE
    boolean delete(ID id);

}
