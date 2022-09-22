package controllers;

import java.util.Set;

import dto.ReservaDTO;
import service.ReservaService;

public class ReservaController {

	
	private ReservaService reservaService = new ReservaService();
	private ReservaDTO reservaDTO = new ReservaDTO();
	
	public ReservaDTO inserirReserva(ReservaDTO dto) {
		System.out.println("reservaController" + " -02- " + reservaDTO.getIdReserva());
		reservaDTO = reservaService.insert(dto);
		return reservaDTO;
	}
	
	public Set<ReservaDTO> findAllReservas() {
		Set<ReservaDTO> obj = reservaService.findAll();
		return obj;
	}
	
}
