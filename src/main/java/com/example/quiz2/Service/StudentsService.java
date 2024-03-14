package com.example.quiz2.Service;

import com.example.quiz2.Model.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentsService {
    ArrayList<Students>students=new ArrayList<>();

    public void add(Students student){
        students.add(student);
    }

    public ArrayList get(){
        return students;
    }

    public boolean update(int id,Students student){
        for(int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.set(i,student);
                return true;
            }}
        return false;
    }

    public boolean delete(int id){
        for (int i=0;i<students.size();i++){
            if(students.get(i).getId()==id){
                students.remove(i);
                return true;
            }

        }

        return false;
    }


    public Students byname(String name){
        for(Students students1:students){
            if(students1.getName().equalsIgnoreCase(name)){
                return students1;
            }
        }
        return null;
    }

    public ArrayList bymajor(String major){
        ArrayList<Students> majors=new ArrayList<>();
        for(Students students1:students){
            if (students1.getMajor().equalsIgnoreCase(major)){
                majors.add(students1);
            }
        }
        return majors;
    }
}
