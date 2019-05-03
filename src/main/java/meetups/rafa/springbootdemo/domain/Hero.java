package meetups.rafa.springbootdemo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data               // --> Lombok annotation, for getter, setter, equals/hashcode, tostring, etc
@NoArgsConstructor  // --> Lombok annotation for default constructor
@AllArgsConstructor // --> Lombok annotation for all args constructor
public class Hero {

    public enum Universe {
        DC, MARVEL
    }

    private String name;
    private Universe universe;
}
