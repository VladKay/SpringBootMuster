package mainFolder.service;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFolder.controller.models.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
    public  String getBeispiel() {
        return "vlad";
    }
    public String getAllBusinesses() {
        String url = "https://interact.leadforensics.com/WebApi_v2/Business/GetAllBusinesses?datefrom=10-05-2016 00:00:00&dateto=12-06-2016 23:59:59&pagesize=5&pageno=1";
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization-Token", "8kqVjkvDKLirolRWTDyYroX");
        headers.set("ClientID", "167316");
        HttpEntity request = new HttpEntity(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, request, String.class);
        return response.getBody();
    }
}
