package de.neuefische.hh2020ji.model;

import java.util.*;

public class StudentDB {

    private HashMap<Integer,Student> students;

    public StudentDB(List<Student> students) {
        this.students = new HashMap<>();
        for(Student student: students){
            add(student);
        }
    }

    public List<Student> list(){
        return new ArrayList<>(students.values());
    }



    public Student randomStudent(){
        int randomIndex = (int) (Math.random() * students.size());
        return list().get(randomIndex);
    }

    @Override
    public String toString(){
        String result = "StudentDB(\n";
        for(Student student : list()) {
            result += student.toString() + "\n";
        }
        result += ")";
        return result;
    }

    public void add(Student student) {
        students.put(student.getId(),student);
    }

    public void removeById(int id) {
        students.remove(id);
    }


    public Optional<Student> findByID(int id) {

        //diesen Teil hab ich mal so umgeschrieben, wie Jan es auch geschrieben hat, der
        //auskommentierte Teil unten ist unsere alte Version. Die Teste funktionieren nach wie vor.
        Student newStudent = students.get(id);
        if(students.containsKey(id)){
            return Optional.of(newStudent);
        }
        else{
            return Optional.empty();
        }


        /*if (newStudent == null) {
            return Optional.empty();
        }
        else {
            return Optional.of(newStudent);
        }*/
    }

}
