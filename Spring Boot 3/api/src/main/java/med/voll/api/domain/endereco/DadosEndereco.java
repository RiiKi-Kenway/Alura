package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "{endereco.logradouro.notBlank}")
        String logradouro,
        @NotBlank(message = "{endereco.bairro.notBlank}")
        String bairro,
        @NotBlank(message = "{endereco.cep.notBlank}")
        @Pattern(regexp = "\\d{8}", message = "{endereco.cep.invalido}")
        String cep,
        @NotBlank(message = "{endereco.cidade.notBlank}")
        String cidade,
        @NotBlank(message = "{endereco.uf.notBlank}")
        String uf,
        String complemento,
        String numero) {
}
