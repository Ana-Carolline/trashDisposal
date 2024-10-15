package br.com.fiap.trashdisposal.repository;

import br.com.fiap.trashdisposal.model.DisposalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DisposalAppointmentRepository extends JpaRepository<DisposalAppointment, Long> {
    Optional<DisposalAppointment> findById(Long id);
}
