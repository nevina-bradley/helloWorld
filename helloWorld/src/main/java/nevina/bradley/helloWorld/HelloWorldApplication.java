package nevina.bradley.helloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloWorldApplication {

	@Autowired
	private MessageRepo messageRepo;
	@GetMapping("/{name}")
	public Message helloWorld(@PathVariable("name") String name){
		Message msg = new Message("hiiii " + name);
		msg = messageRepo.save(msg);
		return msg;
	}

	@GetMapping("/all")
	public Iterable<Message> getAll(){
		return messageRepo.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldApplication.class, args);
	}

}
