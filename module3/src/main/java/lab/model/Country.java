package lab.model;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor //Lombock впишет конструктор вместо нас. Refactor на классе -> AllLombock. На этапе компиляции генерит код.
@AllArgsConstructor
//@Setter //Для каждой переменной генерит сеттер
//@Getter //Для каждоq переменной генерит геттер
//@ToString //Реализация метода toString
//@EqualsAndHashCode //Генерация Equals и HashCode
//Data заменяет геттер/сетер/то стринг/ еквалс

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String codeName;



}
