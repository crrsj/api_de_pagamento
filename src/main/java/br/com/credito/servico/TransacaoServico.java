package br.com.credito.servico;

import java.util.List;

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
}
