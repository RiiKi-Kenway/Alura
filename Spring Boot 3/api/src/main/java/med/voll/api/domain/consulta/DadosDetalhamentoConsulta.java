package med.voll.api.domain.consulta;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long consultaid, Long medicoid, Long pacienteid, LocalDateTime data) {
}
