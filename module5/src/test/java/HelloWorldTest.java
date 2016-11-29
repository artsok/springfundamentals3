import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME =
			"application-context.xml";

	private Person expectedPerson;

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
		        APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		Person person = context.getBean(
		        "person", Person.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private Person getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		return person;
	}
	
	@After
	public void tearDown() throws Exception{
		if (context != null)
			context.close();
	}
}
