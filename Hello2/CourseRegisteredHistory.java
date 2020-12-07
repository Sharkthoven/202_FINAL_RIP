package sit.int202.exam.model;

import java.util.*;

public class CourseRegisteredHistory
{
    private Map<Integer, Semester> registerCourses;
    
    public CourseRegisteredHistory() {
        this.registerCourses = new HashMap<Integer, Semester>();
    }
    
    public void addCourseRegistered(final Semester semester) {
        this.registerCourses.put(semester.getSemester(), semester);
    }
    
    public Semester getRegisteredCoursebySemeter(final int semester) {
        return this.registerCourses.get(semester);
    }
    
    public Semester getRegisteredCoursebySemeter(final String semester) {
        return this.getRegisteredCoursebySemeter(Integer.valueOf(semester));
    }
    
    public Collection<Semester> getAllRegisteredCourses() {
        return this.registerCourses.values();
    }
}