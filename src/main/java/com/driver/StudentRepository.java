package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
     List<Student> students=new ArrayList<>();
     List<Teacher> teachers=new ArrayList<>();

     Map<String,List<String>> pairMap=new HashMap<>();
     public void addStudent(Student student)
     {
         students.add(student);
     }

    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }

    public void addPair(String student,String teacher)
    {
       List<String>list=pairMap.get(teacher);
       if (!pairMap.containsKey(teacher))
       {
           pairMap.put(teacher,new ArrayList<>());

       }
       pairMap.get(teacher).add(student);
    }

    public Student getStudent(String name)
    {
       // Student student1=new Student();
        for (Student student:students)
        {
            if(student.getName().equals(name))
            {
                if (name.equals(student.getName()))
                {
                    return student;
                }
                 break;
            }
        }
        return null;
    }

    public Teacher getTeacher(String name)
    {
      //  Teacher teacher=new Teacher();
        for (Teacher t:teachers)
        {
            if(t.getName().equals(name))
            {
                return t;
            }
        }
        return null;
    }

    public List<String> getStudentsByTeacherName(String name)
    {
           return pairMap.get(name);
    }

    public List<String> getAllStudents()
    {
        List<String> list=new ArrayList<>();
        for (Student s:students)
        {
            list.add(s.getName());
        }
        return list;
    }
    public void deleteTeacherByName(String name)
    {
        teachers.remove(name);
        pairMap.remove(name);
    }

    public void deleteAllTeachers()
    {
        teachers.clear();
        pairMap.clear();
    }
}
