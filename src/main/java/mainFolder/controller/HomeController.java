package mainFolder.controller;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import mainFolder.controller.models.Student;
import mainFolder.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("students")
public class HomeController {
    @Autowired
    ServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<ArrayList<Student>> getStudents() {
        return ResponseEntity.ok(service.getStudents());
    }

    @PostMapping("/student/add")
    public ResponseEntity<String> addStudent(@RequestBody String body) throws JsonProcessingException {
        return ResponseEntity.ok(service.addStudent(body));
    }
    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable (name="id") long id) throws JsonProcessingException {
        return ResponseEntity.ok(service.deleteStudent(id));
    }
    @GetMapping("/get")
    public ResponseEntity<String> getTest(){
        return ResponseEntity.ok(service.getPostsPlainJSON());
    }
    @GetMapping("/getAllBuisenesses")
    public ResponseEntity<String> getAllBuisnesses(){
        return ResponseEntity.ok(service.getAllBusinesses());
    }
}