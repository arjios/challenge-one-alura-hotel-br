package controllers;

import java.time.Instant;
import java.util.Set;

import javax.swing.table.DefaultTableModel;

import dto.HospedeDTO;
import dto.ReservaDTO;
import service.HospedeService;

public class HospedeController {

	private HospedeService hospedeService = new HospedeService();
	
	public Set<HospedeDTO> findAllHospedes() {
		Set<HospedeDTO> obj = hospedeService.findAll();
		return obj;
	}
	
	public void inserirHospede(HospedeDTO dto) {
		hospedeService.insert(dto);
	}
	
	public HospedeDTO atualizarHospedes(DefaultTableModel dtm) {
		HospedeDTO hdto = new HospedeDTO();
		
		for(int i=1; i<dtm.getRowCount(); i++) {

			hdto.setId(Long.valueOf(dtm.getValueAt(i, 0).toString()));		
			
			hdto.setNome(dtm.getValueAt(i, 1).toString());
			
			hdto.setSobrenome(dtm.getValueAt(i, 2).toString());
			
			hdto.setDataNascimento(Instant.parse(dtm.getValueAt(i, 3).toString()));

			hdto.setNacionalidade(dtm.getValueAt(i, 4).toString());
			
			hdto.setTelefone(dtm.getValueAt(i, 5).toString());
			
			hdto.setIdReserva(Integer.valueOf(dtm.getValueAt(i, 6).toString()));
			
			hospedeService.update(Long.valueOf(hdto.getIdReserva()), hdto);
			hdto = new HospedeDTO();
		}
		return hdto;
	}

	public Long deletarHospede(Object obj) {
		Long id = hospedeService.delete(obj);
		return id;
	}
	
}
