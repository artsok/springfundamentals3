package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by User on 07.11.2016.
 */

@NoArgsConstructor
@Data
public class Company {

    private int id;
    private String companyName;
    private Person person;
    private Country country;

}
