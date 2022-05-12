package backend.poc1.project.POC1Backend;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
class Poc1BackendApplicationTests {

	@MockBean
	ResourceRepository repo;
	
	@Autowired
	ResourceService service;
	
	
	@Test
	void testList1() {
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
		Resource res4=new Resource(21004, "Kumar", new String[] {"Spring","Hibernate","Java"}, 250000, "Salem");
		
		when(repo.findAll()).thenReturn(Stream.of(res1,res2,res3,res4).collect(Collectors.toList()));
		
		assertNotNull(service.list());
	}
	@Test
	void testList2() {
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
		Resource res4=new Resource(21004, "Kumar", new String[] {"Spring","Hibernate","Java"}, 250000, "Salem");
		
		when(repo.findAll()).thenReturn(Stream.of(res1,res2,res3,res4).collect(Collectors.toList()));
		
		assertSame("Banglore",service.list().get(1).getResArea());
	}
	@Test
	public void testList3()
	{
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
		Resource res3=new Resource(20912, "Paul Roshan", new String[] {"HTML","BS","JS","React"}, 341000, "Chennai");
		Resource res4=new Resource(21004, "Kumar", new String[] {"Spring","Hibernate","Java"}, 250000, "Salem");
		
		when(repo.findAll()).thenReturn(Stream.of(res1,res2,res3,res4).collect(Collectors.toList()));
		
		assertTrue(Arrays.toString(service.list().get(1).getResSkills()).contains("Spring"));
	}
	
	@Test
	public void testCreate()
	{
		Resource res1=new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore");
		Resource res2=new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore");
		
		when(repo.save(res1)).thenReturn(res1);
		
		assertNotSame("Aarthi Aiyanar", service.create(res1).getResName());
	}
	@Test
	public void testRead()
	{
		Optional<Resource> res1=Optional.of(new Resource(21001, "Manoj Kumar", new String[] {"React","HTML","MUI","BS"}, 400000, "Banglore"));
		Optional<Resource> res2=Optional.of(new Resource(19023, "Aarthi Aiyanar", new String[] {"Python","Spring","React"}, 400000, "Banglore"));
		
		when(repo.findById(21001)).thenReturn(res1);
		
		assertFalse(service.read(21001).get().getResPay()<100000);
	}
	@Test
	public void testList4()
	{
		
		Resource res1= new Resource(12090, "sam", new String[] {"Spring","css"},50000,"Chennai");
		when(repo.save(res1)).thenReturn(res1);
	}
	@Test
	public void testList5() 
	{
		Optional<Resource> res1=Optional.of(new Resource(3030, "surendhiran", new String[] {"React","CSS","D#"},50000, "salem"));	
		Optional<Resource> res2=Optional.of(new Resource(3031, "James", new String[] {"React","CSS","Ruby"},48000, "salem"));
		Optional<Resource> res3=Optional.of(new Resource(3032, "Katt", new String[] {"React","CSS",},90000, "salem"));
		when(repo.findById(3032)).thenReturn(res3);
		assertFalse(service.read(3032).get().getResPay()<60000);
	}
	
	
	
}


