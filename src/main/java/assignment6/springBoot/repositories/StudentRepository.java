/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment6.springBoot.repositories;

import assignment6.springBoot.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ahlamabudiab
 */
public interface StudentRepository extends JpaRepository<Student,Integer> {
    
}
