package kz.greetgo.xnkqionsbdarpbwmocho.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Setter
@Getter
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

    public TelephonyMongo(String id, String name, LocalDate birthYear, String phoneNumber, String secondaryPhoneNumber, LocalDate creationDate) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.creationDate = creationDate;
    }

    public TelephonyMongo() {

    }

}
