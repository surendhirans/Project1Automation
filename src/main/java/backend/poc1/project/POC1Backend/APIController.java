package backend.poc1.project.POC1Backend;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class APIController 
{
	@Autowired
	ResourceService service;
	
	@PostMapping("/new")
	public String makeCreate(@RequestBody Resource res)
	{
		return service.create(res).getResName()+" has recruited";
	}
	
	@GetMapping("/home")
	public List<Resource> makeList()
	{
		return service.list();
	}
	
	@GetMapping("/getting/{quiz}")
	public Optional<Resource> makeRead(@PathVariable("quiz") int quiz)
	{
		return service.read(quiz);
	}
	
	@PutMapping("/update")
	public String makeUpdate(@RequestBody Resource res)
	{
		return service.create(res).getResName()+" has updated";
	}
	@DeleteMapping("/del/{unique}")
	public String makeRemove(@PathVariable("unique") int unique)
	{
		return service.remove(unique);
	}
}