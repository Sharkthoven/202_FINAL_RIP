package sit.int202.exam.model;

import java.util.*;

public class CourseList
{
    private static final Map<Integer, List<Subject>> courses;
    private static final String data = "1,INT100,Information Technology Fundamentals,3\n1,INT101,Programming Fundamentals,3\n1,INT102,Web Technology,1\n1,INT114,Discrete Mathematics for Information Technology,3\n1,GEN101,Physical Education,1\n2,GEN111,Man and Ethics of Living,3\n2,LNG120,General English,3\n2,INT103,Advanced Programming,3\n2,INT104,User Experience Design,3\n2,INT105,Basic SQL,1\n3,INT107,Computing Platforms Technology,3\n3,INT200,Data Structures and Algorithms,1\n3,GEN121,Learning and Problem Solving Skills,3\n3,LNG220,Academic English,3\n3,INT201,Client-Side Web Programming I,2\n4,INT202,Server-Side Web Programming I,2\n4,INT205,Database Management System,3\n4,INT207,Network I,3\n4,INT214,Statistics for Information Technology,3\n4,GEN231,Miracle of Thinking,3\n5,LNG202,Business English,1\n5,INT203,Client-side Web Programming II,2\n5,INT204,Server-side Web Programming II,2\n5,INT206,Advanced Database,2\n5,INT208,Network II,2\n6,INT209,Development and Operations (DevOps),1\n6,INT210,Architecture Integration and Deployment,2\n6,INT221,Integrated Information Technology Project I,1\n6,LNG308,Technical Report Writing,1\n6,INT222,Integrated Information Technology Project II,2\n7,INT305,Semi-structured and Unstructured Data Management,2\n7,INT307,Security I,2\n7,INT314,Applied Mathematics for Data Science,3\n7,GEN241,Beauty of Life,3\n7,LNG320,Content-based Language Learning,3\n8,INT308,Security II,2\n8,INT319,Information Technology Professional Practice,4\n8,INT321,Information Technology Seminar I,1\n8,INT339,Preparation for Career Training,1\n8,INT340,Career Training**,2\n9,INT365,Capstone Information Technology Project I,3\n9,GEN351,Modern Management and Leadership,3\n9,GENxxx,GEN Elective I,3\n9,INT366,Capstone Information Technology Project II,3\n9,INTxxx,INT Elective I,3\n9,LNG224,Oral Communication,3\n9,INT322,Information Technology Seminar II,1\n9,LNG304,Meetings and Discussions,1\n9,INT370,Work Integrated Learning (24 \u0e2a\u0e31\u0e1b\u0e14\u0e32\u0e2b\u0e4c),9\n9,INT371,Experiential Learning Project I,3\n9,INT321,Information Technology Seminar I,1\n9,INT372,Experiential Learning Project II,3\n9,LNG224,Oral Communication I,1";
    
    public static List<Subject> getSubjectBySemester(final int semester) {
        return CourseList.courses.get(semester);
    }
    
    public static Subject getSubject(final int semester, final String subjectId) {
        for (final Subject subject : CourseList.courses.get(semester)) {
            if (subject.getSubjectId().equalsIgnoreCase(subjectId)) {
                return subject;
            }
        }
        return null;
    }
    
    private static Subject getSubject(final String[] subject) {
        return new Subject((int)Integer.valueOf(subject[0]), subject[1], subject[2], (double)Double.valueOf(subject[3].trim()));
    }
    
    private static void convertStringToSubject(final List<String[]> subjectList) {
        for (final String[] strings : subjectList) {
            final Subject s = getSubject(strings);
            List<Subject> list = CourseList.courses.get(s.getSemester());
            if (list == null) {
                list = new ArrayList<Subject>();
                CourseList.courses.put(s.getSemester(), list);
            }
            list.add(s);
        }
    }
    
    private static void mockupData() {
        final Scanner sc = new Scanner("1,INT100,Information Technology Fundamentals,3\n1,INT101,Programming Fundamentals,3\n1,INT102,Web Technology,1\n1,INT114,Discrete Mathematics for Information Technology,3\n1,GEN101,Physical Education,1\n2,GEN111,Man and Ethics of Living,3\n2,LNG120,General English,3\n2,INT103,Advanced Programming,3\n2,INT104,User Experience Design,3\n2,INT105,Basic SQL,1\n3,INT107,Computing Platforms Technology,3\n3,INT200,Data Structures and Algorithms,1\n3,GEN121,Learning and Problem Solving Skills,3\n3,LNG220,Academic English,3\n3,INT201,Client-Side Web Programming I,2\n4,INT202,Server-Side Web Programming I,2\n4,INT205,Database Management System,3\n4,INT207,Network I,3\n4,INT214,Statistics for Information Technology,3\n4,GEN231,Miracle of Thinking,3\n5,LNG202,Business English,1\n5,INT203,Client-side Web Programming II,2\n5,INT204,Server-side Web Programming II,2\n5,INT206,Advanced Database,2\n5,INT208,Network II,2\n6,INT209,Development and Operations (DevOps),1\n6,INT210,Architecture Integration and Deployment,2\n6,INT221,Integrated Information Technology Project I,1\n6,LNG308,Technical Report Writing,1\n6,INT222,Integrated Information Technology Project II,2\n7,INT305,Semi-structured and Unstructured Data Management,2\n7,INT307,Security I,2\n7,INT314,Applied Mathematics for Data Science,3\n7,GEN241,Beauty of Life,3\n7,LNG320,Content-based Language Learning,3\n8,INT308,Security II,2\n8,INT319,Information Technology Professional Practice,4\n8,INT321,Information Technology Seminar I,1\n8,INT339,Preparation for Career Training,1\n8,INT340,Career Training**,2\n9,INT365,Capstone Information Technology Project I,3\n9,GEN351,Modern Management and Leadership,3\n9,GENxxx,GEN Elective I,3\n9,INT366,Capstone Information Technology Project II,3\n9,INTxxx,INT Elective I,3\n9,LNG224,Oral Communication,3\n9,INT322,Information Technology Seminar II,1\n9,LNG304,Meetings and Discussions,1\n9,INT370,Work Integrated Learning (24 \u0e2a\u0e31\u0e1b\u0e14\u0e32\u0e2b\u0e4c),9\n9,INT371,Experiential Learning Project I,3\n9,INT321,Information Technology Seminar I,1\n9,INT372,Experiential Learning Project II,3\n9,LNG224,Oral Communication I,1");
        final List<String[]> subjectList = new ArrayList<String[]>(50);
        String[] str = null;
        while (sc.hasNextLine()) {
            str = sc.nextLine().split(",");
            subjectList.add(str);
        }
        convertStringToSubject(subjectList);
        sc.close();
    }
    
    public static String getAllCourseInString() {
        final StringBuilder sb = new StringBuilder(2800);
        for (final List<Subject> list : CourseList.courses.values()) {
            int semester = 0;
            for (final Subject subject : list) {
                if (subject.getSemester() != semester) {
                    semester = subject.getSemester();
                    sb.append("Semester: ").append(semester).append("\n");
                    sb.append("---------------------------------------\n");
                }
                sb.append("\t").append(subject).append("\n");
            }
        }
        return sb.toString();
    }
    
    static {
        courses = new HashMap<Integer, List<Subject>>();
        mockupData();
    }
}