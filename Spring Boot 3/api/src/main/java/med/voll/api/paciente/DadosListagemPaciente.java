package med.voll.api.paciente;

public record DadosListagemPaciente(Long pacienteid, String nome, String email, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getPacienteid(), paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }

}