package service;

import java.util.Set;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entities.Reserva;
import repositories.ReservaRepository;
import service.util.CalculoDiarias;

public class ReservaService {
	
	ReservaRepository reservaRepository = new ReservaDAO();
	
//	HospedeRepository hospedeRepository;
	
	
	public Set<ReservaDTO> findAll() {	
		Set<ReservaDTO> reservas = reservaRepository.findAll();
		for (ReservaDTO reservaDTO : reservas) {
			reservaDTO.setValor(CalculoDiarias.valorDiarias(500.00, reservaDTO.getDataEntrada(), reservaDTO.getDataSaida()));
		}
		return reservas;
	}
	
	public ReservaDTO findByIdReserva(Long id) {
		ReservaDTO reservaDTO = new  ReservaDTO(reservaRepository.findByIdReserva(id));
		reservaDTO.setValor(CalculoDiarias.valorDiarias(500.00, reservaDTO.getDataEntrada(), reservaDTO.getDataSaida()));
		return reservaDTO;
	}
	
	public ReservaDTO insert(ReservaDTO dto) {
		dto.setValor(CalculoDiarias.valorDiarias(500.00, dto.getDataEntrada(), dto.getDataSaida()));
		return reservaRepository.insert(dto);
	}

}
