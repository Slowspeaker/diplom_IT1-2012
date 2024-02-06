package kz.greetgo.xnkqionsbdarpbwmocho.controller;

import kz.greetgo.xnkqionsbdarpbwmocho.dto.TelephonyDTO;
import kz.greetgo.xnkqionsbdarpbwmocho.model.TelephonyMongo;
import kz.greetgo.xnkqionsbdarpbwmocho.service.TelephonyMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/telephony-mongo")
public class TelephonyMongoController {
    @Autowired
    private TelephonyMongoService telephonyMongoService;

    @PostMapping
    public ResponseEntity<TelephonyMongo> createTelephonyMongo(@RequestBody TelephonyDTO telephonyDTO) {
        TelephonyMongo createdTelephonyMongo = telephonyMongoService.createTelephonyMongo(telephonyDTO);
        return ResponseEntity.ok(createdTelephonyMongo);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<TelephonyMongo> getTelephonyMongoById(@PathVariable String id) {
        return telephonyMongoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<TelephonyMongo> getTelephonyMongoByPhoneNumber(@PathVariable String phoneNumber) {
        return telephonyMongoService.findByPhoneNumber(phoneNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<TelephonyMongo>> getAllTelephonyMongo(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<TelephonyMongo> telephonyMongos = telephonyMongoService.findAllWithFilter(size, page);
        return ResponseEntity.ok(telephonyMongos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelephonyMongo> updateTelephonyMongo(@PathVariable String id, @RequestBody TelephonyDTO telephonyDTO) {
        return telephonyMongoService.updateTelephonyMongo(id, telephonyDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelephonyMongoById(@PathVariable String id) {
        telephonyMongoService.deleteTelephonyMongo(id);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/phone")
    public ResponseEntity<Void> deleteByPhoneNumber(@RequestParam String phoneNumber) {
        telephonyMongoService.deleteByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().build();
    }
}
