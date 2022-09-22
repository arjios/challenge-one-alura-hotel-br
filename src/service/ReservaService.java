package service;

import java.util.Set;

import dao.ReservaDAO;
import dto.ReservaDTO;
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
		return reservaRepository.findByIdReserva(id);
	}
	
	public ReservaDTO insert(ReservaDTO dto) {
//		hospedeRepository.insert();
		System.out.println("reservaService" + " -03- " + dto.getIdReserva());
		return reservaRepository.insert(dto);
	}

}
