package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "{nome.notBlank}")
        String nome,
        @NotBlank(message = "{email.notBlank}")
        @Email(message = "{email.invalido}")
        String email,
        @NotBlank(message = "{telefone.notBlank}")
        String telefone,
        @NotBlank(message = "{crm.notBlank}")
        @Pattern(regexp = "\\d{4,6}", message = "{crm.invalido}")
        String crm,
        @NotNull(message = "{especialidade.notNull}")
        Especialidade especialidade,
        @NotNull(message = "{endereco.notNull}")
        @Valid
        DadosEndereco endereco) {
}
