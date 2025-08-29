import model.Classes;
import model.Student;
import model.Teacher;
import service.UniversityService;

import java.util.*;

public class UniversityMenu {
    UniversityService universityService = new UniversityService();
    Scanner sc = new Scanner(System.in);


    public void printMenu(){
        int option;
        do{
            System.out.println("Bienvenido al SIA");
            System.out.println("Seleccione una opcion");
            System.out.println("1. Mostrar todos los profesores");
            System.out.println("2. Mostrar todas las clases");
            System.out.println("3. Crear estudiante y agregarlo a una clase existente");
            System.out.println("4. Crear nueva clase, agregar profesor y alumnos");
            System.out.println("5. Mostrar clases de un alumno");
            System.out.println("6. Salir :p");
            option = sc.nextInt();
            sc.nextLine();

            switch (option){
                case 1:
                    listTeachers();
                    break;
                case 2:
                    listClasses();
                    break;
                case 3:
                    addStudentToClass();
                    break;
                case 4:
                    createNewClass();
                    break;
                case 5:
                    findClassesByStudentId();
                    break;
                case 6:
                    System.out.println("Hasta luego :)");
                    break;
                default:
                    System.out.println("Not valid option");
            }
        }while (option != 6);
    }

    private void listTeachers(){
        System.out.println("==========Teachers==========");
        for (Teacher t : universityService.getTeachers()){
            System.out.println(t.getDetails());
        }
    }

    private void listClasses(){
        System.out.println("==========Classes==========");
        for (Classes c : universityService.getClasses()){
            System.out.println(c.getDetails());
        }
    }

    private void addStudentToClass(){
        System.out.println("Ingrese el nombre del estudiante");
        String name = sc.nextLine();
        System.out.println("Ingrese la edad del estudiante");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("\n--- Clases disponibles ---");
        for (Classes c : universityService.getClasses()) {
            System.out.println("• " + c.getClassName());
        }

        System.out.println("Ingrese nombre de la clase");
        String className = sc.nextLine();

        boolean ok = universityService.addStudentsToClass(name, age, className);
        if (ok) {
            System.out.println("Estudiante creado e inscrito en \"" + className + "\".");
        } else {
            System.out.println("Clase \"" + className + "\" no encontrada. Verifique el nombre.");
        }

        sc.nextLine();

        universityService.addStudentsToClass(name, age, className);
        System.out.println("Estudiante agregado exitosamente: \n"+
                "Nombre: " +  name + " | Edad: " + age + " | Clase: " + className);
    }

    private void createNewClass(){
        System.out.println("Ingrese nombre de la clase");
        String className = sc.nextLine();
        System.out.println("Ingrese el aula: ");
        String classroom = sc.nextLine();

        System.out.println("\n--- Profesores disponibles ---");
        for (Teacher t : universityService.getTeachers()) {
            System.out.println("ID: " + t.getId() + " | " + t.getName());
        }

        System.out.println("Ingrese Id del profesor: ");
        int teacherId = sc.nextInt();
        sc.nextLine();


        System.out.println("\n--- Estudiantes disponibles ---");
        for (Student s : universityService.getStudents()) {
            System.out.println("ID: " + s.getId() + " | " + s.getName());
        }

        System.out.println("Ingrese ID de los estudiantes: ");
        String[] ids = sc.nextLine().split(" ");
        List<Integer> studentId = new ArrayList<>();
        for (String id : ids){
            id = id.replaceAll("[^0-9]", "");
            if (!id.isEmpty()) {
                studentId.add(Integer.parseInt(id));
            }
        }

        universityService.createClass(className, classroom, teacherId, studentId);
        System.out.println("Clase crada exitosamente :)");
    }

    private void findClassesByStudentId(){
        System.out.println("Ingrese ID del estudiante: ");
        int studentId = sc.nextInt();
        List<Classes> found = universityService.findClassesByStudentId(studentId);

        if(found.isEmpty()){
            System.out.println("El estudiante no esta inscrito en ninguna clase");
        }else {
            System.out.println("El estudiante esta inscrito en: ");
            for (Classes c : found){
                System.out.println(c.getDetails());
            }
        }
    }
}
