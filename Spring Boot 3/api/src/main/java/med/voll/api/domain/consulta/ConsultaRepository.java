package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    boolean existsByPacienteIdAndDataBetween(Long pacienteid, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    boolean existsByMedicoIdAndData(Long medicoid, LocalDateTime data);

}
