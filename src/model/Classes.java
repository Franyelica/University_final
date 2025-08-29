package model;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    private String className;
    private String classroom;
    private  Teacher teacher;
    private  List<Student> students;


    public Classes(String className, String classroom, Teacher teacher) {
        this.className = className;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
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
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        if(!students.contains(student)){
            students.add(student);
        }
   }

   public void removeStudent(Student student){
        students.remove(student);
   }


    public String getDetails(){
        return "Class : " + className +
                " | Aula: " + classroom +
                " | Teacher: " + teacher.getName() +
                " | Students in this class: " + students.size();
    }
}
