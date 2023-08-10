package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank(message = "{logradouro.notBlank}")
        String logradouro,
        @NotBlank(message = "{bairro.notBlank}")
        String bairro,
        @NotBlank(message = "{cep.notBlank}")
        @Pattern(regexp = "\\d{8}", message = "{cep.invalido}")
        String cep,
        @NotBlank(message = "{cidade.notBlank}")
        String cidade,
        @NotBlank(message = "{uf.notBlank}")
        String uf,
        String complemento,
        String numero) {
}
