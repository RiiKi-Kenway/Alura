package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.endereco.DadosEndereco;

public record DadosCadastroMedico(
        @NotBlank(message = "{medico.nome.notBlank}")
        String nome,
        @NotBlank(message = "{medico.email.notBlank}")
        @Email(message = "{medico.email.invalido}")
        String email,
        @NotBlank(message = "{medico.telefone.notBlank}")
        String telefone,
        @NotBlank(message = "{medico.crm.notBlank}")
        @Pattern(regexp = "\\d{4,6}", message = "{medico.crm.invalido}")
        String crm,
        @NotNull(message = "{medico.especialidade.notNull}")
        Especialidade especialidade,
        @NotNull(message = "{medico.endereco.notNull}")
        @Valid
        DadosEndereco endereco) {
}
