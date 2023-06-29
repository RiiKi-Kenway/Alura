package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

  @Autowired
  private MedicoRepository repository;

  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {

    repository.save(new Medico(dados));

  }

  @GetMapping
  public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 2, page = 1, sort = {"nome", "crm"}) Pageable paginacao) {

    var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

    return ResponseEntity.ok(page);
  }

  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid DadosAtualicaoMedico dados){

    var medico = repository.getReferenceById(dados.medicoid());

    medico.atualizarInformacoes(dados);

    return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
  }

  @DeleteMapping("/{medicoid}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long medicoid){

    var medico = repository.getReferenceById(medicoid);
    medico.Excluir();

    return ResponseEntity.noContent().build();
  }

}