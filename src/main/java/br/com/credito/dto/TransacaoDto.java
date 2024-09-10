package br.com.credito.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import br.com.credito.dominio.Transacao;
import br.com.credito.enums.StatusCompra;
public record TransacaoDto(
		
		UUID id,
		
		String dataHora,
		
		String nomeTitular,
		
		Long numeroCartao,
		
		int codSeguranca,
		
		LocalDate validadeCartao,
		
		BigDecimal Total,
		
		StatusCompra statusCompra) {
	
	public TransacaoDto(Transacao transacao) {
		this(
				
				transacao.getId(),
				transacao.getDataHora(),
				transacao.getNomeTitular(),
				transacao.getNumeroCartao(),
				transacao.getCodSeguranca(),
				transacao.getValidadeCartao(),
				transacao.getTotal(),transacao.getStatusCompra());
	}

}
