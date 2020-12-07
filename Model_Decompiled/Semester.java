package sit.int202.exam.model;

import java.util.*;

public class Semester
{
    private static final String[] TITLE;
    private int semester;
    List<Subject> subjects;
    
    public static String[] getAllSemesterText() {
        return Semester.TITLE;
    }
    
    public Semester(final int semester) {
        this.semester = semester;
        this.subjects = new ArrayList<Subject>();
    }
    
    public int getSemester() {
        return this.semester;
    }
    
    public void registerSubject(final Subject subject) {
        this.subjects.add(subject);
    }
    
    public void removeAllRegisteredCourse() {
        this.subjects.clear();
    }
    
    public String getSemesterText() {
        if (this.semester >= Semester.TITLE.length) {
            return null;
        }
        return Semester.TITLE[this.semester];
    }
    
    public List<Subject> getRegisteredCourse() {
        return this.subjects;
    }
    
    static {
        TITLE = new String[] { null, "\u0e20\u0e32\u0e04 1/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 1", "\u0e20\u0e32\u0e04 2/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 1", "\u0e20\u0e32\u0e04 1/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 2", "\u0e20\u0e32\u0e04 2/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 2", "\u0e20\u0e32\u0e04 1/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 3", "\u0e20\u0e32\u0e04 2/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 3", "\u0e20\u0e32\u0e04 1/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 4", "\u0e20\u0e32\u0e04 2/ \u0e1b\u0e35\u0e01\u0e32\u0e23\u0e28\u0e36\u0e01\u0e29\u0e32\u0e17\u0e35\u0e48 4", "\u0e20\u0e32\u0e04\u0e1e\u0e34\u0e40\u0e28\u0e29 \u0e42\u0e04\u0e23\u0e07\u0e01\u0e32\u0e23 WIL" };
    }
}