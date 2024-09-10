package br.com.credito.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.credito.dominio.Transacao;

public interface TransacaoRepositorio extends JpaRepository<Transacao, UUID>{

}
