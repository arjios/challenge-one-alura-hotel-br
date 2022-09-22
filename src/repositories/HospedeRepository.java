package repositories;

import java.util.Set;

import dto.HospedeDTO;

public interface HospedeRepository {
	
	Set<HospedeDTO> findAll();
	HospedeDTO findByIdReserva(Long id);
	HospedeDTO insert(HospedeDTO hospedeDTO);
	HospedeDTO update(Long idReserva, HospedeDTO hospdeDTO);
	HospedeDTO delete(Long id);
	
}
