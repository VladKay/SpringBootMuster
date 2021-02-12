package mainFolder.application;
import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("mainFolder")
public class Application {

    private static final String POSTS_API_URL = "https://interact.leadforensics.com/WebApi_v2/Business/GetBusiness?businessid=1101281";

    public static void main(String[] args) { SpringApplication.run(Application.class);//start Application }

        }
    }
