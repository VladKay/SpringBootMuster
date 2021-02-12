package mainFolder.service;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFolder.controller.models.BusinessDto;
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
        return "branche";
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
    public String getPullRequest(){
        return "Pull Request";
    }



// Klasse zum Übergeben der Werte von GetBusiness
    public BusinessDto createBusiness(){
        BusinessDto business = new BusinessDto();

        business.setBusinessID(1);
        business.setName("Bonafide Bones The Butcher");
        business.setAdressLine1("Landsdown Road");
        business.setAdressLine2("Willesborough");
        business.setAdressLine3("");
        business.setLocality("");
        business.setTown("Ashford");
        business.setCounty("Kent");
        business.setPostCode("TN7 OPZ");
        business.setCountry("United Kingdom");
        business.setTelephone("01233 2349 234");
        business.setWebsite("http://www.bonafide-bones-the-butcher.co.uk");
        business.setIndustry("Butcher");
        business.setSICCode("1123");
        business.setTurnover("12231");
        business.setRegistrationNumber("1341");
        business.setEmployeeNumber("1-20");

        return business;
    }
}


