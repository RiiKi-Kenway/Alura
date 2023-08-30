package med.voll.api.domain.consulta;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;

    public void agendar(DadosAgendamentoConsulta dados) {

        if(!pacienteRepository.existsById(dados.pacienteid())){
            throw new ValidacaoException("Id do paciente informado não existe.");
        }

        if(dados.medicoid() != null && !medicoRepository.existsById(dados.medicoid())){
            throw new ValidacaoException("Id do médico informado não existe.");
        }

        var paciente = pacienteRepository.findById(dados.pacienteid()).get();
        var medico = medicoRepository.findById(dados.medicoid()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

}