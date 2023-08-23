package repositories;

import java.util.Set;

import dto.HospedeDTO;
import entities.Hospede;

public interface HospedeRepository {
	
	Set<Hospede> findAll();
	HospedeDTO findByIdHospede(Long id);
	void insert(HospedeDTO hospedeDTO);
	HospedeDTO update(Long idReserva, HospedeDTO hospdeDTO);
	Long delete(Long id);
	
}
