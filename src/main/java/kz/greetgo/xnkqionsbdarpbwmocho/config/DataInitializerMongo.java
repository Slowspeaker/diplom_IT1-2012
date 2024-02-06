//package kz.greetgo.xnkqionsbdarpbwmocho.config;
//
//
//import jakarta.annotation.PostConstruct;
//import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
//import kz.greetgo.xnkqionsbdarpbwmocho.repository.TelephonyMongoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.util.Arrays;
//
//@Component
//public class DataInitializerMongo {
//
//    @Autowired
//    private TelephonyMongoRepository telephonyMongoRepository;
//
//    @PostConstruct
//    public void initData() {
//        telephonyMongoRepository.deleteAll();
//
//        Telephony telephony1 = new Telephony(1L, "Имя пользователя 1", LocalDate.of(1990, 5, 15), "+1234567890", "+9876543210", LocalDate.now());
//        Telephony telephony2 = new Telephony(2L, "Имя пользователя 2", LocalDate.of(1985, 8, 22), "+1112223333", "+9998887777", LocalDate.now());
//        Telephony telephony3 = new Telephony(3L, "Имя пользователя 3", LocalDate.of(2000, 3, 10), "+5556667777", "+1231231234", LocalDate.now());
//
//        telephonyMongoRepository.saveAll(Arrays.asList(telephony1, telephony2, telephony3));
//    }
//}