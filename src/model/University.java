package model;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String className;
    private String classroom;
    private Teacher Teacher;
    private List<Student> students;
    private static int classCounter = 0;

    public University(String className, String classroom, Teacher teacher, List<Student> students) {
        this.className = className;
        this.classroom = classroom;
        this.Teacher = teacher;
        this.students = new ArrayList<>();
        classCounter++;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public Teacher getTeacher() {
        return Teacher;
    }

    public void setTeacher(Teacher teacher) {
        Teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

   public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
   }

   public void removeStudent(Student student){
        students.remove(student);
   }

    public static int getClassCounter() {
        return classCounter;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Class: ").append(className)
                .append("\nClassroom: ").append(classroom)
                .append("\nTeacher: ").append(Teacher.getName())
                .append("\nStudents (").append(students.size()).append("):\n");

        for (Student student : students) {
            sb.append("  - ").append(student.toString()).append("\n");
        }

        return sb.toString();
    }
}
