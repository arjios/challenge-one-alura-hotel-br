package controllers;

import java.util.Set;

import javax.swing.JTable;

import dto.ReservaDTO;
import service.ReservaService;

public class ReservaController {

	private ReservaService reservaService = new ReservaService();
	private ReservaDTO reservaDTO = new ReservaDTO();

	public Set<ReservaDTO> findAllReservas() {
		Set<ReservaDTO> obj = reservaService.findAll();
		return obj;
	}
	
	public ReservaDTO findReservaByName(Long idReserva) {	
		return reservaService.findByIdReserva(idReserva);
	}
	
	public ReservaDTO inserirReserva(ReservaDTO dto) {
		reservaDTO = reservaService.insert(dto);
		return reservaDTO;
	}
	
	public Long deletarReserva(Object obj) {
		Long id = reservaService.delete(obj);
		return id;
	}
	
}

