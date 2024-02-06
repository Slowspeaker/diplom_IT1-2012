package kz.greetgo.xnkqionsbdarpbwmocho.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.greetgo.xnkqionsbdarpbwmocho.model.TelephonyMongo;
import kz.greetgo.xnkqionsbdarpbwmocho.repository.TelephonyMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializerMongo {

    @Autowired
    private TelephonyMongoRepository telephonyMongoRepository;

    @PostConstruct
    public void initData() {
        telephonyMongoRepository.deleteAll();

        ObjectMapper mapper = new ObjectMapper();
        try {
            InputStream resource = new ClassPathResource("telephonyDataMongo.json").getInputStream();
            List<TelephonyMongo> telephonyList = mapper.readValue(resource, new TypeReference<List<TelephonyMongo>>() {});
            telephonyMongoRepository.saveAll(telephonyList);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load telephony data from JSON", e);
        }
    }
}
