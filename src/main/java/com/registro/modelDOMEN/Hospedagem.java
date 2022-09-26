package com.registro.modelDOMEN;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.registro.model.enums.StatusHospedagem;
import com.registro.model.enums.TipoHospedagem;

@Entity
@Table(name="hospedagem")
public class Hospedagem {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JoinColumn(name = "id_viajante")
	/* precisa colocar cardinalidade*/
	private Viajante viajante;
	
	@Column
	private Integer estabelecimento;
	
	@Column
	private Integer reserva;
	
	@Column(name = "dataentrada")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataentrada;
	
	@Column(name = "datasaida")
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate datasaida;
	
	@Column
	@Enumerated(value = EnumType.STRING)
	private TipoHospedagem tipo;
	
	@Column(name = "stats")
	@Enumerated(value = EnumType.STRING)
	private StatusHospedagem status;

}