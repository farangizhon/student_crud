package uz.pdp.services;

import uz.pdp.entity.Student;
import uz.pdp.repos.StudentRepo;
import uz.pdp.utils.Input;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private static final StudentRepo STUDENT_REPO = StudentRepo.getInstance();
    public static Optional<Student> findStudentById(Integer id) {
        List<Student> all = STUDENT_REPO.findAll();
        for (Student student : all) {
            if (student.getId() == id) { // equals is not working!!!
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }
    public static void printAll() {
        for (Student student : STUDENT_REPO.findAll()) {
            System.out.println(student);
        }
        System.out.println("----------------------");
    }
    public static void add() {
        Student student = new Student(
                Input.inputStr("Enter name"),
                Input.inputInt("Enter age")
        );
        STUDENT_REPO.save(student);
    }
    public static void delete() {
        Student student = chooseStudent();
        STUDENT_REPO.delete(student);
    }

    private static Student chooseStudent() {
        printAll();
        int id = Input.inputInt("Choose by id");
        Optional<Student> studentOpt = findStudentById(id);
        return studentOpt.orElseThrow(() -> new RuntimeException("user not found"));
    }
    public static void update() {
        Student student = chooseStudent();
        STUDENT_REPO.update(new Student(
                Input.inputStr("Enter name"),
                Input.inputInt("Enter age")
        ), student.getId());
    }
}
