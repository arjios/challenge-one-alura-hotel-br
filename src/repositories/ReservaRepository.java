package repositories;

import java.util.Set;

import dto.ReservaDTO;
import entities.Reserva;

public interface ReservaRepository {

	Set<Reserva> findAll();
	Reserva findByIdReserva(Long id);
	ReservaDTO insert(ReservaDTO reserva);
	ReservaDTO update(Long id, ReservaDTO dto);
	Long delete(Long id);
}
