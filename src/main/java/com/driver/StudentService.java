package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher)
    {
        studentRepository.addTeacher(teacher);
    }

    public void addPair(String student,String teacher)
    {
        studentRepository.addPair(student,teacher);
    }
    public Student getStudent(String name)
    {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacher (String name){
        return studentRepository.getTeacher(name);
    }
    public List<String> getStudentsByTeacherName(String name)
    {
        return studentRepository.getStudentsByTeacherName(name);
    }

    public List<String> getAllStudents()
    {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String name)
    {
        studentRepository.deleteTeacherByName(name);
    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }
}
