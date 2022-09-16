package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import dto.ReservaDTO;
import entities.Reserva;
import factory.ConnectionFactory;
import repositories.ReservaRepository;

public class ReservaDAO implements ReservaRepository {
	
	private ReservaDTO reservaDTO;
	
	private Set<ReservaDTO> reservas = new HashSet<>();

	@Override
	public Set<ReservaDTO> findAll() {
		try {
			Connection con = ConnectionFactory.createConnection();
			Statement st =  con.createStatement();
			st.execute("SELECT * FROM RESERVAS");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				reservaDTO = new ReservaDTO();
				reservaDTO.setId(rs.getLong(1));
				reservaDTO.setDataEntrada(rs.getDate(2).toInstant());
				reservaDTO.setDataSaida(rs.getDate(3).toInstant());
				reservaDTO.setIdReserva(rs.getInt(4));
				reservas.add(reservaDTO);
				System.out.println(reservas);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservas;
	}

	@Override
	public Reserva findByIdReserva(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva insert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva update() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
