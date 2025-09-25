/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6.springBoot.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import assignment6.springBoot.models.Student;
import assignment6.springBoot.repositories.StudentRepository;
import org.springframework.web.bind.annotation.PathVariable;
/**
 *
 * @author ahlamabudiab
 */
@RestController
public class mainController {
    @Autowired
    StudentRepository studentRepository;
    
    @RequestMapping("/")
    public String Index(){
        return String.format("%s", "JPA using SpringBoot");
    }
    @RequestMapping("/showallstd")
    public String showAll(){
        List<Student>students =studentRepository.findAll();
        String str="";
        for(Student s: students)
            str +=s+"<br>";
        return String.format("%s", str);
    }
     @RequestMapping("/show/{id}")
    public String show(@PathVariable Integer id){
        Student student =studentRepository.findById(id).get();
        
        return String.format("%s", student);
    }
     @RequestMapping("/delete/{id}")
    public String showDelete(@PathVariable Integer id){
        Student student =studentRepository.findById(id).orElse(null);
        if(student!=null){
            studentRepository.deleteById(id);
            return String.format("Deleted: %s",student);
        }else{
            return "No student to delete";
        }
    }
    @RequestMapping("/addstd")
    public String add(String name,String major,Double grade){
        Student student= new Student();
        student.setName(name);
        student.setMajor(major);
        student.setGrade(grade);
        studentRepository.save(student);
        return String.format("%s", student);
    }
    @RequestMapping("/updatestd/{id}")
    public String update(@PathVariable Integer id){
        Student student = studentRepository.findById(id).get();
        if(student != null){
            student.setName("Ola Salama");
            student.setMajor("CS");     
            student.setGrade(95.0); 
            studentRepository.save(student);
            return String.format("%s", student);
        }else{
            return "The student not found";
        
        }
    }
}
