package com.registro.modelDOMEN;

import java.time.LocalDate;
import java.util.Objects;

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

	public Hospedagem () {
		super();
	}
	
	public Hospedagem(Long id, Viajante viajante, Integer estabelecimento, Integer reserva, LocalDate dataentrada,
			LocalDate datasaida, TipoHospedagem tipo, StatusHospedagem status) {
		super();
		this.id = id;
		this.viajante = viajante;
		this.estabelecimento = estabelecimento;
		this.reserva = reserva;
		this.dataentrada = dataentrada;
		this.datasaida = datasaida;
		this.tipo = tipo;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Viajante getViajante() {
		return viajante;
	}

	public void setViajante(Viajante viajante) {
		this.viajante = viajante;
	}

	public Integer getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Integer estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Integer getReserva() {
		return reserva;
	}

	public void setReserva(Integer reserva) {
		this.reserva = reserva;
	}

	public LocalDate getDataentrada() {
		return dataentrada;
	}

	public void setDataentrada(LocalDate dataentrada) {
		this.dataentrada = dataentrada;
	}

	public LocalDate getDatasaida() {
		return datasaida;
	}

	public void setDatasaida(LocalDate datasaida) {
		this.datasaida = datasaida;
	}

	public TipoHospedagem getTipo() {
		return tipo;
	}

	public void setTipo(TipoHospedagem tipo) {
		this.tipo = tipo;
	}

	public StatusHospedagem getStatus() {
		return status;
	}

	public void setStatus(StatusHospedagem status) {
		this.status = status;
		
	}
		@Override // faz verificação do identificador unico  /* @Data faz hashCode*/
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Hospedagem other = (Hospedagem) obj;
			return id == other.id;
		}

		@Override
		public String toString() {
			return "Hospedagem [id=" + id + ", estabelecimento=" + estabelecimento + ", reserva=" + reserva + ", Data de entrada=" + datasaida
					+ ", Data de saída=" + datasaida + ", Tipo=" + tipo + ", Status=" + status + "]";
		}
		
	}
