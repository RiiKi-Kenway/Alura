package med.voll.api.paciente;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosDetalhamentoMedico;
import med.voll.api.medico.Medico;

public record DadosDetalhamentoPaciente(Long pacienteid, String nome, String email, String telefone, String cpf, Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getPacienteid(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf(), paciente.getEndereco());
    }
}
