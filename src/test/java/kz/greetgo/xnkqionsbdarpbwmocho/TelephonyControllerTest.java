package kz.greetgo.xnkqionsbdarpbwmocho;

import kz.greetgo.xnkqionsbdarpbwmocho.controller.TelephonyController;
import kz.greetgo.xnkqionsbdarpbwmocho.service.TelephonyService;
import kz.greetgo.xnkqionsbdarpbwmocho.model.Telephony;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

public class TelephonyControllerTest {

    @Mock
    private TelephonyService telephonyService;

    @InjectMocks
    private TelephonyController telephonyController;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTelephonyByIdFound() {
        Long id = 1L;
        Telephony expectedTelephony = new Telephony();
        expectedTelephony.setId(id);
        // Предположим, что сервисный слой возвращает Telephony объект при вызове findById
        when(telephonyService.findById(id)).thenReturn(Optional.of(expectedTelephony));

        ResponseEntity<Telephony> response = telephonyController.getTelephonyById(id);

        assertNotNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 200);
        assertEquals(response.getBody().getId(), expectedTelephony.getId());

        verify(telephonyService).findById(id);
    }

    @Test
    public void testGetTelephonyByIdNotFound() {
        Long id = 2L;
        // Предположим, что сервисный слой не находит объект при вызове findById
        when(telephonyService.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Telephony> response = telephonyController.getTelephonyById(id);

        assertNull(response.getBody());
        assertEquals(response.getStatusCodeValue(), 404);

        verify(telephonyService).findById(id);
    }
}
