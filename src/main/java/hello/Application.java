package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;


@SpringBootApplication
@RestController
public class Application {

    @Autowired
    private RequestRepository repository;

    @Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/")
    public String run(String args) throws Exception {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = req.getRemoteAddr();
        String time = ZonedDateTime.now().toString();

        repository.save(new Request(time, ip));

        List<Request> requests = repository.findAll();

        String allRequests = "";

        for (Request r : requests) {
            if (r != null) {
                allRequests += r.toString() + "&amp;";
            }
        }

        return allRequests;

    }


}
