package repositories;

import java.util.Set;

import dto.ReservaDTO;
import entities.Reserva;

public interface ReservaRepository {

	Set<ReservaDTO> findAll();
	Reserva findByIdReserva(Long id);
	Reserva insert();
	Reserva update();
	Reserva delete(Long id);
	
}
