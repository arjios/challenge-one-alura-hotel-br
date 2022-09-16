package entities;

import java.io.Serializable;
import java.time.Instant;

public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Instant dataEntrada;
	private Instant dataSaida;
	private Integer idReserva;
	
	public Reserva() {
	}

	public Reserva(Long id, Instant dataEntrada, Instant dataSaida, Integer idReserva) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.idReserva = idReserva;
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

	public void setDataSaida(Instant dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
