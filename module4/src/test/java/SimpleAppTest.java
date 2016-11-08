import static org.junit.Assert.*;

import lab.model.Person;
import org.junit.*;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.model.UsualPerson;
import lab.model.Country;

import java.util.List;
import java.util.ArrayList;

public class SimpleAppTest {
	
	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "classpath:application-context.xml";

	private AbstractApplicationContext context;

	private Person expectedPerson;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				APPLICATION_CONTEXT_XML_FILE_NAME);
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		Person person = context.getBean("personAliaS", UsualPerson.class);
		person = context.getBean(UsualPerson.class); //Overload getBean()
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		UsualPerson person = new UsualPerson();
		person.setAge(35);
		person.setHeight(1.78F);
		person.setProgrammer(true);
		person.setName("John Smith");

		Country country = new Country();
		country.setId(1);
		country.setName("Russia");
		country.setCodeName("RU");

		person.setCountry(country);

		List<String> contacts = new ArrayList<String>();
		contacts.add("asd@asd.ru");
		contacts.add("+7-234-456-67-89");

		person.setContacts(contacts);

		return person;
	}
}
