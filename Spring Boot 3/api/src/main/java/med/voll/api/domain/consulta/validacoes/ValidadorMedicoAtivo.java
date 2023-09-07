package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;

public class ValidadorMedicoAtivo {

    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.medicoid() == null) {
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.medicoid());

        if (!medicoEstaAtivo) {
            throw new ValidacaoException("Consulta náo pode ser agendada com médico excluído.");
        }
    }
}
