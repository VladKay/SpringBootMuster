package mainFolder.service;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFolder.controller.models.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceImpl {
    //private RestTemplate restTemplate;
    private final ObjectMapper mapper = new ObjectMapper();
    ArrayList<Student> students=new ArrayList<Student>();
    public ServiceImpl(){}
    /*public ServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }*/

    public  ArrayList<Student> getStudents(){
        return students;
    }

    public String addStudent(String jsonObject) throws JsonProcessingException {
            Student newStudent = mapper.readValue(jsonObject, Student.class);
            newStudent.setId(students.size()+1);
            students.add(newStudent);
            return "Student wurde erfolgreich gespeichert";
    }

    public String deleteStudent(long id) throws JsonProcessingException {
        for(Student student: students){
            if(student.getId()==id){
                students.remove(student);
                return "Student mit Id "+id+" wurde erfolgreich geloescht";
            }
        }
        return "Es gibt kein Student mit dem Id "+id;
    }

    public String getPostsPlainJSON() { //Eine Methode fuer die Request an andere Web Seite.
        //String url = "https://jsonplaceholder.typicode.com/posts";
        String url="http://localhost:8080/list";
        RestTemplate restTemplate =new RestTemplate();
        RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();
        restTemplate=restTemplateBuilder.build();
        return restTemplate.getForObject(url, String.class);
    }
}
