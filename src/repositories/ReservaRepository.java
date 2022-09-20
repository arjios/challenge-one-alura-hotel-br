package repositories;

import java.util.Set;

import dto.ReservaDTO;
import entities.Reserva;

public interface ReservaRepository {

	Set<ReservaDTO> findAll();
	ReservaDTO findByIdReserva(Long id);
	ReservaDTO insert(ReservaDTO dto);
	Reserva update(Long id, ReservaDTO dto);
	Reserva delete(Long id);
	
}
