package uz.pdp.repos;

import uz.pdp.db.Repository;
import uz.pdp.entity.Student;

import java.util.List;

public class StudentRepo implements Repository<Student> {
    List<Student> students;

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void update(Student student, Integer id) {

    }

    @Override
    public void delete(Student student) {

    }
}