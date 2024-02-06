package kz.greetgo.xnkqionsbdarpbwmocho.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document
@Data
public class TelephonyMongo {
    @Id
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("secondary_phone_number")
    private String secondaryPhoneNumber;

    @JsonProperty("creation_date")
    private String creationDate;


    public TelephonyMongo( String name, String birthYear, String phoneNumber, String secondaryPhoneNumber, String creationDate) {

        this.name = name;
        this.birthYear = birthYear;
        this.phoneNumber = phoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.creationDate = creationDate;
    }

    public TelephonyMongo() {

    }

}
