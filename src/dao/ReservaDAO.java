package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
			st.execute("SELECT * FROM RESERVA");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				ReservaDTO dto = new ReservaDTO();
				dto.setId(rs.getLong(1));
				
				LocalDate entrada = rs.getDate(2).toLocalDate();
				dto.setDataEntrada(entrada.atStartOfDay().toInstant(ZoneOffset.UTC));

				LocalDate saida = rs.getDate(3).toLocalDate();
				dto.setDataEntrada(saida.atStartOfDay().toInstant(ZoneOffset.UTC));
				
				dto.setIdReserva(rs.getInt(4));
				reservas.add(dto);
				System.out.println(reservas);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Ocorreu erro na leitura das Reservas.");
			e.printStackTrace();
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
	public ReservaDTO insert(ReservaDTO entity) {
		String sql = "INSERT INTO RESERVA(data_entrada, data_saida, id_reserva, forma_pagamento) VALUES (?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			System.out.println("ReservaDAO: insert()");
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			LocalDate entrada = LocalDate.ofInstant(entity.getDataEntrada(), ZoneId.systemDefault());
			Date e = Date.valueOf(entrada);
			LocalDate saida = LocalDate.ofInstant(entity.getDataSaida(), ZoneId.systemDefault());
			Date s = Date.valueOf(saida);
			ps.setDate(1, e);
			ps.setDate(2, s);
			ps.setLong(3, entity.getIdReserva());
			ps.setNString(4, entity.getFormaPagamento());
			ps.execute();
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
