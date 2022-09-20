package service;

import java.util.Set;

import dao.ReservaDAO;
import dto.ReservaDTO;
import repositories.ReservaRepository;

public class ReservaService {
	
	ReservaRepository reservaRepository = new ReservaDAO();
	
//	HospedeRepository hospedeRepository;
	
	
	public Set<ReservaDTO> findAll() {	
		Set<ReservaDTO> reservas = reservaRepository.findAll();
		return reservas;
	}
	
	public ReservaDTO findByIdReserva(Long id) {
		return reservaRepository.findByIdReserva(id);
	}
	
	public ReservaDTO insert(ReservaDTO dto) {
//		hospedeRepository.insert();
		System.out.println("ReservaService: insert()");
		return reservaRepository.insert(dto);
	}

}
