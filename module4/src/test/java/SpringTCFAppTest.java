import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lab.model.Country;
import lab.model.Person;
import lab.model.UsualPerson;

import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application-context.xml") //Чтобы указать адрес файла контекста
public class SpringTCFAppTest {
	
	@Autowired
	private Person person;

	private Person expectedPerson;
	

	@Before
	public void setUp() throws Exception {
		expectedPerson = getExpectedPerson();
	}

	@Test
	public void testInitPerson() {
		assertEquals(expectedPerson, person);
		System.out.println(person);
	}

	private UsualPerson getExpectedPerson() {
		val person = new UsualPerson()
				.setAge(35)
				.setHeight(1.78F)
				.setProgrammer(true)
				.setName("John Smith")
				.setCountry(new Country(1, "Russia", "RU"))
				.setContacts(Arrays.asList("asd@asd.ru", "+7-234-456-67-89"));

//		UsualPerson person = new UsualPerson();
//		person.setAge(35);
//		person.setHeight(1.78F);
//		person.setProgrammer(true);
//		person.setName("John Smith");
//
//		Country country = new Country();
//		country.setId(1);
//		country.setName("Russia");
//		country.setCodeName("RU");
//
//		person.setCountry(country);
//
//		List<String> contacts = new ArrayList<String>();
//		contacts.add("asd@asd.ru");
//		contacts.add("+7-234-456-67-89");
//
//		person.setContacts(contacts);

		return person;
	}

}
