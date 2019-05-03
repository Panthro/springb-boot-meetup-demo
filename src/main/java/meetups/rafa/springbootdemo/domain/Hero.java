package meetups.rafa.springbootdemo.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data               // --> Lombok annotation, for getter, setter, equals/hashcode, tostring, etc
@NoArgsConstructor  // --> Lombok annotation for default constructor
@AllArgsConstructor // --> Lombok annotation for all args constructor
@Document
public class Hero {

    public enum Universe {
        DC, MARVEL
    }

    @Id
    private String id;

    private String name;
    private Universe universe;
}
