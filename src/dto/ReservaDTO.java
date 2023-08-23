package dto;

import java.time.Instant;

import entities.Reserva;

public class ReservaDTO {

	private Long id;
	private Instant dataEntrada;
	private Instant dataSaida;
	private Integer idReserva;
	private String formaPagamento;
	private Double valor;
	
	public ReservaDTO() {

	}
	
	public ReservaDTO(Instant dataEntrada, Instant dataSaida, Integer idReserva) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.idReserva = idReserva;
	}
	
	public ReservaDTO(Reserva entity) {
		id = entity.getId();
		dataEntrada = entity.getDataEntrada();
		dataSaida = entity.getDataSaida();
		idReserva = entity.getIdReserva();
		formaPagamento = entity.getFormaPagamento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Instant getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Instant dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Instant getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Instant date) {
		this.dataSaida = date;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
