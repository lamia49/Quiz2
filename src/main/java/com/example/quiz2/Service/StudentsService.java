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
}
