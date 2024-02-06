package kz.greetgo.xnkqionsbdarpbwmocho.repository;

import kz.greetgo.xnkqionsbdarpbwmocho.model.TelephonyMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TelephonyMongoRepository extends MongoRepository<TelephonyMongo, String> {
    Optional<TelephonyMongo> findByPhoneNumber(String phoneNumber);
    void deleteByPhoneNumber(String phoneNumber);
}
