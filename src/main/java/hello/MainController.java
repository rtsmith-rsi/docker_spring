package hello;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;
import java.util.List;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.beans.factory.annotation.Autowired;



@Controller
public class MainController {
    @Autowired
    private RequestRepository repository;

    @GetMapping("/main")
    public void main(Model model) {
        HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String ip = req.getRemoteAddr();
        String time = ZonedDateTime.now().toString();

        repository.save(new Request(time, ip));

        List<Request> requests = repository.findAll(Sort.by("id").descending());
        model.addAttribute("requests", requests);
    }
}
