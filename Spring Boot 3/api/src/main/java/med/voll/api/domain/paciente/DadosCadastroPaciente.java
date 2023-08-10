package med.voll.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank(message = "{paciente.nome.notBlank}")
        String nome,
        @NotBlank(message = "{paciente.email.notBlank}")
        @Email(message = "{paciente.email.invalido}")
        String email,

        @NotBlank(message = "{paciente.telefone.notBlank}")
        String telefone,
        @NotBlank(message = "{paciente.cpf.notBlank}")
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}", message = "{paciente.cpf.invalido}")
        String cpf,

        @NotNull(message = "{paciente.endereco.notNull}")
        @Valid
        DadosEndereco endereco) {
}