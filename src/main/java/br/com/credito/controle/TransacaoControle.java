package br.com.credito.controle;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.credito.dto.TransacaoDto;
import br.com.credito.servico.TransacaoServico;

@RestController
@RequestMapping("transacao")
public class TransacaoControle {
	
	@Autowired
	private TransacaoServico transacaoServico;
	
	@PostMapping
	public ResponseEntity<TransacaoDto>criarTransacao(@RequestBody TransacaoDto transacaoDto){
		var transacao = transacaoServico.criarTransacao(transacaoDto);
		var uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("{id}").buildAndExpand(transacao.getId()).toUri();
		return ResponseEntity.created(uri).body(new TransacaoDto(transacao));
	}
	
	@GetMapping
	public ResponseEntity<List<TransacaoDto>>listarTodas(){
		var todas = transacaoServico.listarTodas();
		return ResponseEntity.ok(todas);
	}

	@GetMapping("{id}")
	public ResponseEntity<TransacaoDto>buscarPorId(@PathVariable UUID id){
		var busca = transacaoServico.buscarPorId(id);
		return ResponseEntity.ok().body(new TransacaoDto(busca));
	}
	@PutMapping("{id}")
	public ResponseEntity<TransacaoDto>atualizarTransacao(@RequestBody TransacaoDto transacaoDto,UUID id){
		var atualizar = transacaoServico.atualizarTransacao(transacaoDto, id);
		return ResponseEntity.ok().body(new TransacaoDto(atualizar));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void>excluirTransacao(@PathVariable UUID id){
		transacaoServico.excluirTransacao(id);
		return ResponseEntity.noContent().build();
	}
}
