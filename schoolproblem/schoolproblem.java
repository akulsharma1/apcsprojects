package schoolproblem;

public class schoolproblem {
    
    public static student[] students = new student[35];
    public static classroom[] classrooms = new classroom[50];
    public static void main(String[] args) {

        student Helen = new student("Helen", 7.5);
        student rupin = new student("Rupin", 4.0);
        students[0] = Helen;
        students[1] = rupin;
        classroom b2 = new classroom(students, "B2");
        classrooms[0] = b2;
        school msj = new school(classrooms, "Jeff Evans");
        for (classroom x : msj.getClassrooms()) {
            if (x != null && x.getRoomNumber().equals("B2")) {
                for (student i : b2.getStudents()) {
                    if (i != null && i.getName().equals("Helen"))
                        System.out.println(i.getGpa());
                }
            }
        }
        
    }
}

class student {
    private String name;
    private double gpa;
    public student (String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }
    public String getName() {
        return name;
    }
    public double getGpa() {
        return gpa;
    }
}

class classroom {
    private student[] students;
    private String roomnumber;
    public classroom(student[] students, String roomnumber) {
        this.students = students;
        this.roomnumber = roomnumber;
    }
    public String getRoomNumber() {
        return roomnumber;
    }
    public student[] getStudents() {
        return students;
    }
    
}

class school {
    private classroom[] classrooms;
    private String principal;
    public school(classroom[] classrooms, String principal) {
        this.classrooms = classrooms;
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }
    public classroom[] getClassrooms() {
        return classrooms;
    }
}
