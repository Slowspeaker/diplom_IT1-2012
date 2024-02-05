package kz.greetgo.xnkqionsbdarpbwmocho.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class TelephonyMongo {
    @Id
    private String id;
    private String name;
    private LocalDate birthYear;
    private String phoneNumber;
    private String secondaryPhoneNumber;
    private LocalDate creationDate;
}
