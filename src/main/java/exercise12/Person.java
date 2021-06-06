package exercise12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private boolean isMale;
}
