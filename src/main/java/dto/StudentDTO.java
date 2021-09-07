package dto;

public class StudentDTO {

    private long id;
    private String name;
    private int yearResult;
    private String sectionName;

    public StudentDTO() {
    }

    public StudentDTO(long id, String name, int yearResult, String sectionName) {
        this.id = id;
        this.name = name;
        this.yearResult = yearResult;
        this.sectionName = sectionName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearResult() {
        return yearResult;
    }

    public void setYearResult(int yearResult) {
        this.yearResult = yearResult;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
