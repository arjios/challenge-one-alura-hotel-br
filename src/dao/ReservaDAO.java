package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		String sql = "SELECT * FROM RESERVAS";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservaDTO dto = new ReservaDTO();
				dto.setId(rs.getLong(1));
				dto.setDataEntrada(rs.getDate(2).toInstant());
				dto.setDataSaida(rs.getDate(3).toInstant());
				dto.setIdReserva(rs.getInt(4));
				reservas.add(dto);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Ocorreu erro na leitura das Reservas.");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reservas;
	}

	@Override
	public ReservaDTO findByIdReserva(Long id) {
		String sql = "SELECT id, data_entrada, data_saida, id_reserva FROM RESERVAS "
				+ "WHERE id_reserva = ?";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			ps.setLong(4, id);
			ps.executeQuery(sql);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Ocorreu erro na leitura da Reserva.");
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return reservaDTO;
	}

	@Override
	public Reserva insert(ReservaDTO entity) {
		boolean boo = false;
		String sql = "INSERT INTO FROM RESERVAS(dataEntrada, dataSaida, id_reserva) VALUES (?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			ps.setDate(1, (java.sql.Date) Date.from(entity.getDataEntrada()));
			ps.setDate(2, (java.sql.Date) Date.from(entity.getDataSaida()));
			ps.setLong(3, entity.getIdReserva());
			boo = ps.execute();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Reserva update(Long id, ReservaDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reserva delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
