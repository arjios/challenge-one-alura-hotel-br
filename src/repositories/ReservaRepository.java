package repositories;

import java.util.Set;

import dto.ReservaDTO;
import entities.Reserva;

public interface ReservaRepository {

	Set<ReservaDTO> findAll();
	Reserva findByIdReserva(Long id);
	ReservaDTO insert(ReservaDTO dto);
	Reserva update(Long id, ReservaDTO dto);
	Long delete(Long id);
}
