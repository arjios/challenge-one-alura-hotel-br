package repositories;

import java.util.Set;

import entities.Reserva;

public interface ReservaRepository {

	Set<Reserva> findAll();
	Reserva findByIdReserva(Long id);
	Reserva insert();
	Reserva update();
	Reserva delete(Long id);
	
}
