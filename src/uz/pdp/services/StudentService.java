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
