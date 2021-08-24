package model;

public class Section {

    private int id;
    private String name;
    private int delegateId;

    public Section() {
    }

    public Section(int id, String name, int delegateId) {
        this.id = id;
        this.name = name;
        this.delegateId = delegateId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(int delegateId) {
        this.delegateId = delegateId;
    }
}
