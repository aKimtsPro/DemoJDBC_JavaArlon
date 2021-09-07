package model;

public class Student {

    private long id;
    private String firstname;
    private String lastname;
    private int yearResult;
    private int sectionId;

    public Student(long id, String firstname, String lastname, int yearResult, int sectionId) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.yearResult = yearResult;
        this.sectionId = sectionId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearResult() {
        return yearResult;
    }

    public void setYearResult(int yearResult) {
        this.yearResult = yearResult;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }
}
