package br.com.credito.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transações")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	private String nomeTitular;
	private String numeroCartao;
	private int codSeguranca;
	private LocalDate validadeCartao;
	private BigDecimal total;

}
