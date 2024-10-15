package br.com.fiap.trashdisposal.service;

import br.com.fiap.trashdisposal.model.DisposalAppointment;
import br.com.fiap.trashdisposal.repository.DisposalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DisposalAppointmentService {

    @Autowired
    private DisposalAppointmentRepository repository;

    public List<DisposalAppointment> getAllAppointments() {
        try {
            return repository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving appointments from the database", e);
        }
    }

    public DisposalAppointment createAppointment(DisposalAppointment appointment) {
        try {
            return repository.save(appointment);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error creating new appointment in the database", e);
        }
    }

    public DisposalAppointment updateAppointment(Long id, DisposalAppointment appointment) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Appointment with id " + id + " not found");
        }
        appointment.setId(id);
        try {
            return repository.save(appointment);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error updating appointment in the database", e);
        }
    }

    public void deleteAppointment(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("Appointment with id " + id + " not found");
        }
        try {
            repository.deleteById(id);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error deleting appointment from the database", e);
        }
    }
}