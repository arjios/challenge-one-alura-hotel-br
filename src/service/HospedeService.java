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

}
