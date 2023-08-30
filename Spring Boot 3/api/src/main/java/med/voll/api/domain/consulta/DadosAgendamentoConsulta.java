package med.voll.api.domain.consulta;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(
    @JsonAlias({"medico_id", "id_medico", "id"})
    Long medicoid,

    @NotNull
    @JsonAlias({"paciente_id", "id_paciente", "id"})
    Long pacienteid,

    @NotNull
    @Future
    @JsonAlias({"data_agendamento", "data_consulta"})
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime data){
}
