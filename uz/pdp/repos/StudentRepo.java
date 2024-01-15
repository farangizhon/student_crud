package uz.pdp.repos;

import uz.pdp.db.Repository;
import uz.pdp.entity.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repository<Student> {
    List<Student> students;
    private static final String PATH = "src/uz/pdp/db/student_db.txt";
    private static StudentRepo singleton;

    private StudentRepo(List<Student> students) {
        this.students = students;
    }
    public static StudentRepo getInstance() {
        if (singleton == null) { // if the object has not been created yet
            singleton = new StudentRepo(loadData());
        }
        return singleton;
    }
    @SuppressWarnings("unchecked")
    private static List<Student> loadData() {
        // when the streams are inside try catch, they are automatically closed
        try (InputStream inputStream = new FileInputStream(PATH);
             ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);)
        {
            return (List<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>(); // when there's no object, the catch clause works
        }
    }

    @Override
    public void save(Student student) {
        students.add(student);
        uploadData();
    }

    private void uploadData() {
        try (OutputStream outputStream = new FileOutputStream(PATH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);)
        {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void update(Student student, Integer id) {

    }

    @Override
    public void delete(Student student) {

    }
}