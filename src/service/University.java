package service;

import model.Classes;
import model.FullTimeTeacher;
import model.PartTimeTeacher;
import model.Teacher;
import model.Student;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Classes> classes;

    public University(List<Teacher> teachers, List<Student> students, List<Classes> classes) {
        this.teachers = teachers;
        this.students = students;
        this.classes = classes;
        inicializarDatos();
    }

    private void inicializarDatos(){
        teachers.add(new FullTimeTeacher("Jorge Castillo", 10));
        teachers.add(new FullTimeTeacher("Julio Salazar", 5));
        teachers.add(new PartTimeTeacher("Juan Guzman", 40));
        teachers.add(new PartTimeTeacher("Valentina Garcia", 30));

        students.add(new Student("Bruno Pruzsi", 20));
        students.add(new Student("Ana Martinez", 22));
        students.add(new Student("Jose Buitrago", 21));
        students.add(new Student("Jesus Garcia", 22));
        students.add(new Student("Agustin Campos", 23));
        students.add(new Student("Gari Rodriguez", 19));

        UniversityClass numericalMethods = new Classes("Numerical Methods", "Room 101", teachers.get(2));
        numericalMethods.addStudent(students.get(0));
        numericalMethods.addStudent(students.get(1));
        numericalMethods.addStudent(students.get(2));
        classes.add(numericalMethods);

        UniversityClass descreteMathematics = new Classes("Discrete Mathematics", "Room 301", teachers.get(0));
        numericalMethods.addStudent(students.get(0));
        numericalMethods.addStudent(students.get(1));
        numericalMethods.addStudent(students.get(2));
        classes.add(numericalMethods);

        UniversityClass dbAdministration = new Classes("Data Base Admministration", "Room 150", teachers.get(3));
        numericalMethods.addStudent(students.get(3));
        numericalMethods.addStudent(students.get(4));
        numericalMethods.addStudent(students.get(5));
        classes.add(numericalMethods);

        UniversityClass english = new Classes("English", "Room 205", teachers.get(3));
        numericalMethods.addStudent(students.get(1));
        numericalMethods.addStudent(students.get(2));
        numericalMethods.addStudent(students.get(3));
        classes.add(numericalMethods);

        public List<Teacher> getAllTeachers(){
            return new ArrayList<>(teachers);
        }

        public List<Student> getAllStudents(){
            return new ArrayList<>(students);
        }

        public List<Classer> getAllClasses() {
            return new ArrayList<>(classes);
        }

        public Student createStudent(String name, int age) {
            Student newStudent = new Student(name, age);
            students.add(newStudent);
            return newStudent;
        }

        public Classes createClass(String className, String classroom, Teacher teacher) {
            Classes newClass = new Classes(className, classroom, teacher);
            classes.add(newClass);
            return newClass;
        }

        public void addStudentToClass(Student student, Classes classes) {
            class.addStudent(student);
        }

        public List<Classes> findClassesByStudentId(String studentId){
            List<Classes> result = new ArrayList<>();
            for (Classes uniClass : classes){
                for (Student student : uniClass.getStudents()){
                    if (student.getId().equals(studentId)){
                        return.add(uniClass);
                        break;
                    }
                }
            }
            return result;
        }

        public Student findStudentById(String studentId) {
            return students.stream()
                    .filter(s -> s.getId().equals(studentId))
                    .findFirst()
                    .orElse(null);
        }

        public Classes findClassByName(String className) {
            return classes.stream()
                    .filter(c -> c.getClassName().equalsIgnoreCase(className))
                    .findFirst()
                    .orElse(null);
        }
    }


}
