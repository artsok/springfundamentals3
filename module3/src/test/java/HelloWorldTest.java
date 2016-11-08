import lab.model.Company;
import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelloWorldTest {

	protected static final String APPLICATION_CONTEXT_XML_FILE_NAME = "/src/main/resources/application-context.xml";

	private UsualPerson expectedPerson;

	private AbstractApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new FileSystemXmlApplicationContext(
				new String[] { APPLICATION_CONTEXT_XML_FILE_NAME });
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		UsualPerson person = (UsualPerson) context.getBean("person", Person.class);
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	@Test
	public void testCompany() {
		Company company = context.getBean("company", Company.class);
        System.out.println(company.getCountry() + " " + company.getPerson().getName());
        assertEquals(company.getCompanyName(), "SberTech");
		//assertTrue(company.getPerson() ==  (UsualPerson) context.getBean("person", Person.class));

	}


	private UsualPerson getExpectedPerson() {
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
