package com.example.quiz2.Service;

import com.example.quiz2.Model.Students;
import com.example.quiz2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher>teachers=new ArrayList<>();

    public void add(Teacher teacher){
        teachers.add(teacher);
    }

    public ArrayList get(){
        return teachers;
    }

    public boolean update(int id,Teacher teacher){
        for (int i=0;i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.set(i,teacher);
                return true;
            }}
        return false;
    }


    public boolean delete(int id){
        for(int i=0; i<teachers.size();i++){
            if(teachers.get(i).getId()==id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }


    public Teacher byId(int id,Teacher teacher){
        for (Teacher teacher1:teachers){
            if(teacher1.getId()==id){
                return teacher1;
            }
        }
        return null;
    }

    public ArrayList bySalary(int salary){
        ArrayList<Teacher>salarys=new ArrayList<>();
        for(Teacher teacher1:teachers){
            if(teacher1.getSalary()>=salary){
                 salarys.add(teacher1);
            }
        }return salarys;

    }





}
