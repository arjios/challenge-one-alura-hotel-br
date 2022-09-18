package service;

import java.util.Set;

import dto.ReservaDTO;
import repositories.ReservaRepository;

public class ReservaService {
	
	ReservaRepository reservaRepository;
	
	public Set<ReservaDTO> findAll() {	
		Set<ReservaDTO> reservas = reservaRepository.findAll();
		return reservas;
	}
	
	public ReservaDTO findByIdReserva(Long id) {

		return reservaRepository.findByIdReserva(id);
	}

}
