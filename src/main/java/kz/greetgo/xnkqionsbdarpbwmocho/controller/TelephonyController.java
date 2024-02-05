package kz.greetgo.xnkqionsbdarpbwmocho.controller;

import kz.greetgo.xnkqionsbdarpbwmocho.dto.TelephonyDTO;
import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
import kz.greetgo.xnkqionsbdarpbwmocho.model.TelephonyMongo;
import kz.greetgo.xnkqionsbdarpbwmocho.service.TelephonyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/from-postgres")
public class TelephonyController {
    @Autowired
    private TelephonyService telephonyService;

    @PostMapping
    public Telephony createTelephony(@RequestBody TelephonyDTO telephonyDTO) {
        return telephonyService.createTelephony(telephonyDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Telephony> getTelephonyById(@PathVariable Long id) {
        return telephonyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Telephony> getTelephonyMongoByPhoneNUmber(@PathVariable String phoneNumber) {
        return telephonyService.findByPhoneNumber(phoneNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Page<Telephony> getAllTelephony(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "25") int size) {
        return telephonyService.findAllWithFilter(size, page);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Telephony> updateTelephony(@PathVariable Long id, @RequestBody TelephonyDTO telephonyDTO) {
        return telephonyService.updateTelephony(id, telephonyDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelephonyById(@PathVariable Long id) {
        telephonyService.deleteTelephony(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/byPhoneNumber")
    public ResponseEntity<Void> deleteByPhoneNumber(@RequestParam String phoneNumber) {
        telephonyService.deleteByPhoneNumber(phoneNumber);
        return ResponseEntity.ok().build();
    }
}
