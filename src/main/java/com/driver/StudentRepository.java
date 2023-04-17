package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
     Map<String,Student> students=new HashMap<>();
     Map<String,Teacher> teachers=new HashMap<>();

     Map<String,List<String>> pairMap=new HashMap<>();
     public void addStudent(Student student)
     {
         students.put(student.getName(),student);
     }

    public void addTeacher(Teacher teacher)
    {
        teachers.put(teacher.getName(),teacher);
    }

    public void addPair(String student,String teacher)
    {
      if (!pairMap.containsKey(teacher))
      {
          pairMap.put(teacher,new ArrayList<>());
      }
      pairMap.get(teacher).add(student);
    }

    public Student getStudent(String name)
    {
       // Student student1=new Student();
      return students.get(name);
    }

    public Teacher getTeacher(String name)
    {
      //  Teacher teacher=new Teacher();
      return teachers.get(name);
    }

    public List<String> getStudentsByTeacherName(String name)
    {
           return pairMap.get(name);
    }

    public List<String> getAllStudents()
    {
        List<String> list=new ArrayList<>();
        for (String s:students.keySet())
        {
            list.add(s);
        }
        return list;
    }
    public void deleteTeacherByName(String name)
    {
        for(String s:pairMap.get(name))
        {
           students.remove(s);
        }

        teachers.remove(name);
        pairMap.remove(name);
    }

    public void deleteAllTeachers()
    {
        for (String teacher:teachers.keySet())
        {
            deleteTeacherByName(teacher);
        }
    }
}
