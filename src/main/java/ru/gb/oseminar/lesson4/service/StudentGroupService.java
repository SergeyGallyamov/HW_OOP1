package ru.gb.oseminar.lesson4.service;

import ru.gb.oseminar.lesson4.data.Student;
import ru.gb.oseminar.lesson4.data.StudentGroup;
import ru.gb.oseminar.lesson4.data.Teacher;
import ru.gb.oseminar.lesson4.data.UserComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class StudentGroupService {
    private final List<StudentGroup> studentGroupList;

    public StudentGroupService() {
        this.studentGroupList = new ArrayList<>();
    }

    public StudentGroup createStudentGroup(Teacher teacher, List<Student> students) {
        Long maxGroupId = 0L;
        for (StudentGroup studentGroup : studentGroupList){
            if (studentGroup.getGroupId() > maxGroupId){
                maxGroupId = studentGroup.getGroupId();
            }
        }
        maxGroupId++;

        StudentGroup studentGroup = new StudentGroup(maxGroupId, teacher, students);
        studentGroupList.add(studentGroup);
        return studentGroup;
    }

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public Student getStudentFromStudentGroup(String firstName, String secondName){
        List<Student> result = new ArrayList<>();

        for(StudentGroup studentGroup : studentGroupList) {
            Iterator<Student> iterator = studentGroup.iterator();
            while (iterator.hasNext()) {
                Student student = iterator.next();
                if (student.getFirstName().equalsIgnoreCase(firstName)
                        && student.getSecondName().equalsIgnoreCase(secondName)) {
                    result.add(student);
                }
            }
            if (result.size() == 0) {
                throw new IllegalStateException(
                        String.format("Студент с именем %s и фамилией %s не найден", firstName, secondName)
                );
            }
            if (result.size() != 1) {
                throw new IllegalStateException("Найдено более одного студента с указанными именем и фамилией");
            }
        }
        return result.get(0);
    }

    public List<Student> getSortedStudentGroup(Long groupId) {
        List<Student> students = new ArrayList<>();
        for (StudentGroup studentGroup : studentGroupList) {
           if(groupId.equals(studentGroup.getGroupId())){
               students.addAll(studentGroup.getStudents());
               break;
           }
        }
        Collections.sort(students);
        return students;
    }

    public List<Student> getSortedByFIOStudentGroup(Long groupId){
        List<Student> students = new ArrayList<>();
        for (StudentGroup studentGroup : studentGroupList) {
            if(groupId.equals(studentGroup.getGroupId())){
                students.addAll(studentGroup.getStudents());
                break;
            }
        }
        students.sort(new UserComparator<Student>());
        return students;
    }
}
