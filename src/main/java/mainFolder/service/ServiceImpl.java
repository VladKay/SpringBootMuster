package mainFolder.service;

import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import mainFolder.controller.models.Student;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {
    ObjectMapper mapper = new ObjectMapper();
    ArrayList<Student> students=new ArrayList<Student>();

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
}
