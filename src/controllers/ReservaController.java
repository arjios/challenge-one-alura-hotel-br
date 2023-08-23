package controllers;

import java.time.Instant;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.ParseInfo;

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

	public ReservaDTO atualizarReserva(DefaultTableModel dtm) {

		ReservaDTO rdto = new ReservaDTO();
		for(int i=1; i< dtm.getRowCount(); i++) {
			
			rdto = reservaService.findByIdReserva(Long.valueOf(dtm.getValueAt(i, 0).toString()));
	
			rdto.setIdReserva(Integer.valueOf(dtm.getValueAt(i, 0).toString()));

			rdto.setDataEntrada(Instant.parse(dtm.getValueAt(i, 1).toString()));

			rdto.setDataSaida(Instant.parse(dtm.getValueAt(i, 2).toString()));

			rdto.setValor(Double.valueOf(dtm.getValueAt(i, 3).toString()));
			
			rdto.setFormaPagamento(dtm.getValueAt(i, 4).toString());

			reservaService.update(rdto.getId(), rdto);
		}
		return reservaDTO;
	}
	
	
	public Long deletarReserva(Object obj) {
		Long id = reservaService.delete(obj);
		return id;
	}
	
}

