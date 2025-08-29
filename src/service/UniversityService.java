package service;

import model.Classes;
import model.FullTimeTeacher;
import model.PartTimeTeacher;
import model.Teacher;
import model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UniversityService {
    private List<Student> students;
    private List<Teacher> teachers;
    public List<Classes> classes;

    public UniversityService() {
        teachers = new ArrayList<>();
        students = new ArrayList<>();
        classes = new ArrayList<>();
        inicializarDatos();
    }

    private void inicializarDatos(){
        Teacher t1 = new FullTimeTeacher("Bruno Pruzsiani", 26, 5);
        Teacher t2 = new FullTimeTeacher("Silvana Pareja", 25, 2);
        Teacher t3 = new PartTimeTeacher("Camilo Ortiz", 30, 40);
        Teacher t4 = new PartTimeTeacher("Franyelica Garcia", 23, 25);

        teachers.add(t1);
        teachers.add(t2);
        teachers.add(t3);
        teachers.add(t4);

        Student s1 = new Student("Pedro Obando", 22);
        Student s2 = new Student("Andrea Ramos", 23);
        Student s3 = new Student("Juan Guzman", 24);
        Student s4 = new Student("Jesus Garcia", 20);
        Student s5 = new Student("Ana Martinez", 19);
        Student s6 = new Student("Maria Palacios", 21);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        Classes c1 = new Classes("Web Programming", "L-401", t1);
        c1.addStudent(s1);
        c1.addStudent(s2);
        Classes c2 = new Classes("Data Structure", "M-210", t3);
        c2.addStudent(s3);
        c2.addStudent(s4);
        Classes c3 = new Classes("Maths", "C-102", t4);
        c3.addStudent(s5);
        c3.addStudent(s6);
        Classes c4 = new Classes("DB Administration", "N-505", t2);
        c4.addStudent(s2);
        c4.addStudent(s5);

        classes.add(c1);
        classes.add(c2);
        classes.add(c3);
        classes.add(c4);
    }


    public List<Teacher> getTeachers(){
        return teachers;
    }

    public List<Student> getStudents(){
        return students;
    }

    public List<Classes> getClasses(){
        return classes;
    }

    public boolean addStudentsToClass(String studentName, int age, String className){
        Student newStudent = new Student(studentName, age);
        students.add(newStudent);

        for (Classes c : classes){
            if(c.getClassName().equalsIgnoreCase(className.trim())){
                c.addStudent(newStudent);
                return true;
            }
        }
        return false;
    }

    public void createClass(String className, String classroom, int teacherId, List<Integer> studentId){
        Teacher selectTeacher = null;
        for(Teacher t : teachers){
            if (t.getId() == teacherId){
                selectTeacher = t;
                break;
            }
        }

        if (selectTeacher == null)return;

        Classes newClass = new Classes(className, classroom, selectTeacher);

        for (Student s : students){
            if (studentId.contains(s.getId())){
                newClass.addStudent(s);
            }
        }

        classes.add(newClass);
    }

    public List<Classes> findClassesByStudentId(int studentId){
        List<Classes> result = new ArrayList<>();
        for (Classes c : classes){
            for (Student s : c.getStudents()){
                if (s.getId() == studentId){
                    result.add(c);
                    break;
                }
            }
        }
        return result;
    }



    /*public List<Student> createStudent() {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Bruno Pruzsi", 20));
        students.add(new Student("Ana Martinez", 22));
        students.add(new Student("Jose Buitrago", 21));
        students.add(new Student("Jesus Garcia", 22));
        students.add(new Student("Agustin Campos", 23));
        students.add(new Student("Gari Rodriguez", 19));
        return students;
    }*/

    /*private List<Teacher> createTeacher() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new FullTimeTeacher("Jorge Castillo", 10));
        teachers.add(new FullTimeTeacher("Julio Salazar", 5));
        teachers.add(new PartTimeTeacher("Juan Guzman", 40));
        teachers.add(new PartTimeTeacher("Valentina Garcia", 30));

        return teachers;
    }*/

    /*public List<Classes> createClasses() {
        List<Classes> classes = new ArrayList<>();
        List<Student> students = createStudent();
        List<Teacher> teachers = createTeacher();
        Classes numericalMethods = new Classes("Numerical Methods", "Room 101", teachers.get(2));
        numericalMethods.addStudent(students.get(0));
        numericalMethods.addStudent(students.get(1));
        numericalMethods.addStudent(students.get(2));
        classes.add(numericalMethods);

        Classes discreteMathematics = new Classes("Discrete Mathematics", "Room 301", teachers.get(0));
        discreteMathematics.addStudent(students.get(0));
        discreteMathematics.addStudent(students.get(1));
        discreteMathematics.addStudent(students.get(2));
        classes.add(numericalMethods);

        Classes dbAdministration = new Classes("Data Base Admministration", "Room 150", teachers.get(3));
        dbAdministration.addStudent(students.get(3));
        dbAdministration.addStudent(students.get(4));
        dbAdministration.addStudent(students.get(5));
        classes.add(numericalMethods);

        Classes english = new Classes("English", "Room 205", teachers.get(3));
        english.addStudent(students.get(1));
        english.addStudent(students.get(2));
        english.addStudent(students.get(3));
        classes.add(numericalMethods);

        return classes;
    }*/

    /*public void printTeachers(){
        System.out.println("Id | name | salary");
        teachers.forEach(System.out::println);
    }
    public void printStudents() {
        System.out.println("Id | name | age");
        students.forEach(System.out::println);
    }

    public void printClasses() {
        System.out.println("--- Classes ---");
        classes.forEach(System.out::println);
    }*/

    /*public void listClassesForStudent(int studentId) {
        Student student = students.stream().filter(s -> s.getId() == studentId).findFirst().orElse(null);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.println("Classes for " + student.getName() + ":");
        classes.stream().filter(c -> c.getStudents().contains(student)).forEach(System.out::println);
    }*/

    /*public void printClassDetail(String name) {
        Optional<Classes> foundClass = classes.stream()
                .filter(c -> c.getClassName().equalsIgnoreCase(name)) // compara por nombre
                .findFirst();

        if (classes.isPresent()) {
            Classes c = classes.get();
            System.out.println("Class: " + c.getClassName());
            System.out.println("Teacher: " + c.getTeacher().getName());
            System.out.println("Students:");
            c.getStudents().forEach(System.out::println);
        } else {
            System.out.println("Class not found.");
        }
    }*/
}