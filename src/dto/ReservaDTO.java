package dto;

import java.time.Instant;

import entities.Reserva;

public class ReservaDTO {

	private Long id;
	private Instant dataEntrada;
	private Instant dataSaida;
	private Double idReserva;
	
	public ReservaDTO() {

	}
	
	public ReservaDTO(Instant dataEntrada, Instant dataSaida, Double idReserva) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.idReserva = idReserva;
	}
	
	public ReservaDTO(Reserva entity) {
		id = entity.getId();
		dataEntrada = entity.getDataEntrada();
		dataSaida = entity.getDataSaida();
		idReserva = entity.getIdReserva();
	}

	public Long getId() {
		return id;
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

	public void setDataSaida(Instant dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Double getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Double idReserva) {
		this.idReserva = idReserva;
	}

}
