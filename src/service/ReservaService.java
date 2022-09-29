package service;

import java.util.HashSet;
import java.util.Set;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entities.Reserva;
import repositories.ReservaRepository;
import service.util.CalculoDiarias;

public class ReservaService {
	
	ReservaRepository reservaRepository = new ReservaDAO();
	
	Set<ReservaDTO> reservasDTO = new HashSet<>();
	
//	HospedeRepository hospedeRepository;
	
	
	public Set<ReservaDTO> findAll() {	
		for (Reserva reserva : reservaRepository.findAll()) {
			ReservaDTO dto = new ReservaDTO(reserva);
			dto.setValor(CalculoDiarias.valorDiarias(500.00, reserva.getDataEntrada(), reserva.getDataSaida()));
			reservasDTO.add(dto);
		}
		return reservasDTO;
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
	
	public Long delete(Object obj) {
		String id_txt = obj.toString();
		Long id = (long) Integer.parseUnsignedInt(id_txt);
		id = reservaRepository.delete(id);
		System.out.println(id);
		return id;
	}

}
