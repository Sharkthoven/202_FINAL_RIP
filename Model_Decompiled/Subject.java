package sit.int202.exam.model;

public class Subject
{
    private final int semester;
    private final String subjectId;
    private final String title;
    private final double credit;
    
    public Subject(final int semester, final String id, final String title, final double credit) {
        this.subjectId = id;
        this.title = title;
        this.credit = credit;
        this.semester = semester;
    }
    
    public int getSemester() {
        return this.semester;
    }
    
    public String getSubjectId() {
        return this.subjectId;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public double getCredit() {
        return this.credit;
    }
    
    @Override
    public String toString() {
        return String.format("%7s %-50s %3.1f", this.subjectId, this.title, this.credit);
    }
}