package ru.gb.oseminar.lesson4.service;

import ru.gb.oseminar.lesson4.data.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements UserService<Student> {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }

    @Override
    public void create(String firstName, String secondName, String patronymic, LocalDate dateOfBirth) {
        Long countMaxId = 0L;
        for (Student student: students){
                if (student.getStudentId() > countMaxId){
                    countMaxId = student.getStudentId();
            }
        }
        countMaxId++;
        Student student = new Student(firstName, secondName, patronymic, dateOfBirth, countMaxId);
        students.add(student);
    }

    @Override
    public Student findById(Long userId) {
        Student result = null;
        for (Student student : students){
            if (student.getStudentId().equals(userId)){
                result = student;
                break;
            }
        }
        return result;
    }

    public List<Student> findByIds(List<Long> studentIds) {
        List<Student> result = new ArrayList<>();
        for (Long id : studentIds){
            result.add(findById(id));
        }
        return result;
    }
}
