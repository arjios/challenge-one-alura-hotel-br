package service;

import java.util.Set;
import java.util.stream.Collectors;

import dto.ReservaDTO;
import entities.Reserva;
import repositories.ReservaRepository;

public class ReservaService {
	
	ReservaRepository reservaRepository;
	
	public Set<ReservaDTO> findAll() {	
		Set<Reserva> reservas = reservaRepository.findAll();
		return reservas.stream().map(x -> new ReservaDTO(x)).collect(Collectors.toSet());
	}
	
	public ReservaDTO findByIdReserva(Long id) {
		Reserva obj = reservaRepository.findByIdReserva(id);
		return new ReservaDTO(obj);
	}

}
