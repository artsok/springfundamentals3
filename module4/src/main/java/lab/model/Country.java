package lab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Country implements Serializable, ApplicationListener{

	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String codeName;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("test " + applicationEvent.getTimestamp());
    }
}
