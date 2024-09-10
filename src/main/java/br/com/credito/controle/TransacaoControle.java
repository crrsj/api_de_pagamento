package br.com.credito.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}
