package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {

        if(!pacienteRepository.existsById(dados.pacienteid())){
            throw new ValidacaoException("Id do paciente informado não existe.");
        }

        if(dados.medicoid() != null && !medicoRepository.existsById(dados.medicoid())){
            throw new ValidacaoException("Id do médico informado não existe.");
        }

        validadores.forEach(v -> v.validar(dados));

        var paciente = pacienteRepository.getReferenceById(dados.pacienteid());
        var medico = escolherMedico(dados);

        if(medico == null){
            throw new ValidacaoException("Não existe médico disponível nesta data.");
        }

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {

        if(dados.medicoid() != null){
            return medicoRepository.getReferenceById(dados.medicoid());
        }

        if(dados.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando médico não é selecionado.");
        }

        return medicoRepository.sortMedicoLivrePorData(dados.especialidade(), dados.data());

    }

}
