package br.com.fiap.trashdisposal.controller;

import br.com.fiap.trashdisposal.model.DisposalAppointment;
import br.com.fiap.trashdisposal.service.DisposalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/appointments")
public class DisposalAppointmentController {

    @Autowired
    private DisposalAppointmentService service;

    @GetMapping
    public List<DisposalAppointment> getAllAppointments() {
        return service.getAllAppointments();
    }

    @PostMapping
    public DisposalAppointment createAppointment(@RequestBody DisposalAppointment appointment) {
        return service.createAppointment(appointment);
    }

    @PutMapping("/{id}")
    public DisposalAppointment updateAppointment(@PathVariable Long id, @RequestBody DisposalAppointment appointment) {
        return service.updateAppointment(id, appointment);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        service.deleteAppointment(id);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}