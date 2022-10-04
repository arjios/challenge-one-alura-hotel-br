package service;

import java.util.HashSet;
import java.util.Set;

import dao.HospedeDAO;
import dto.HospedeDTO;
import entities.Hospede;
import repositories.HospedeRepository;

public class HospedeService {
	
	private Set<HospedeDTO> hospedesDTO = new HashSet<>();
	
	HospedeRepository hospedeRepository = new HospedeDAO();
	
	public Set<HospedeDTO> findAll() {	
		Set<Hospede> hospedes = hospedeRepository.findAll();
		for (Hospede hospede : hospedes) {
			hospedesDTO.add(new HospedeDTO(hospede));
		}
		return hospedesDTO;
	}

	public void insert(HospedeDTO dto) {
		hospedeRepository.insert(dto);
	}
	
	public HospedeDTO update(Long id, HospedeDTO hdto) {
		HospedeDTO hospedeDTO = new HospedeDTO();
		hospedeDTO = hospedeRepository.findByIdReserva(id);
		hospedeDTO.setId(hdto.getId());
		hospedeDTO.setNome(hdto.getNome());
		hospedeDTO.setSobrenome(hdto.getSobrenome());
		hospedeDTO.setTelefone(hdto.getTelefone());
		hospedeDTO.setDataNascimento(hdto.getDataNascimento());
		hospedeDTO.setNacionalidade(hdto.getNacionalidade());		
		return hospedeRepository.update(hospedeDTO.getId(), hospedeDTO);
	}

	public Long delete(Object obj) {
		String id_txt = obj.toString();
		Long id = (long) Integer.parseUnsignedInt(id_txt);
		ReservaService reservaService = new ReservaService();
		if(reservaService.delete(id) != null) {
			id = hospedeRepository.delete(id);
		} else {
			id = null;
		}
		return id;
	}

}
