package repositories;

import java.util.Set;

import dto.HospedeDTO;
import entities.Hospede;

public interface HospedeRepository {
	
	Set<Hospede> findAll();
	HospedeDTO findByIdReserva(Long id);
	HospedeDTO insert(HospedeDTO hospedeDTO);
	HospedeDTO update(Long idReserva, HospedeDTO hospdeDTO);
	HospedeDTO delete(Long id);
	
}
