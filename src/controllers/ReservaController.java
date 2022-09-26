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
		System.out.println("reservaController" + " -02- " + dto.getIdReserva());
		reservaDTO = reservaService.insert(dto);
		return reservaDTO;
	}
	
	
	public boolean deletarReserva(Object obj) {
		boolean boo = false;
		if(reservaService.delete(obj)) {
			boo = true;
		}
		System.out.println(boo);
		return boo;
	}
	
}

