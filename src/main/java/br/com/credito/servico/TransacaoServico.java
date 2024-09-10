package br.com.credito.servico;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.credito.dominio.Transacao;
import br.com.credito.dto.TransacaoDto;
import br.com.credito.repositorio.TransacaoRepositorio;

@Service
public class TransacaoServico {

	@Autowired
	private TransacaoRepositorio transacaoRepositorio;
	
	public Transacao criarTransacao(TransacaoDto transacaoDto) {
		var compra = new Transacao(transacaoDto);
		return transacaoRepositorio.save(compra);
	}
	
	public List<TransacaoDto>listarTodas(){
		var lista = transacaoRepositorio.findAll();
		return lista.stream().map(TransacaoDto::new).toList();
	}
	
	public Transacao buscarPorId(UUID id) {
		Optional<Transacao>buscar = transacaoRepositorio.findById(id);
		return buscar.get();
	}
	
	public Transacao atualizarTransacao(TransacaoDto transacaoDto,UUID id) {
		var atualizar = new Transacao(transacaoDto);
		atualizar.setId(id);
		return transacaoRepositorio.save(atualizar);
	}
	
	public void excluirTransacao(UUID id) {
		transacaoRepositorio.deleteById(id);
	}
}
