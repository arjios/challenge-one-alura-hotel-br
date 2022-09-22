package service;

import java.util.Set;

import dao.HospedeDAO;
import dto.HospedeDTO;
import repositories.HospedeRepository;

public class HospedeService {
	
	HospedeRepository hospedeRepository = new HospedeDAO();
	
	public Set<HospedeDTO> findAll() {	
		Set<HospedeDTO> hospedes = hospedeRepository.findAll();
		return hospedes;
	}

}
