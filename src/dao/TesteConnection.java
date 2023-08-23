package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import factory.ConnectionFactory;

public class TesteConnection {

	public static void main(String[] args) {

			try {
				Connection con = ConnectionFactory.createConnection();
				Statement st =  con.createStatement();
				st.execute("SELECT * FROM RESERVA");
				ResultSet rs = st.getResultSet();
				while(rs.next()) {
					
					Long id = rs.getLong(1);
					Date dataEntrada = rs.getDate(2);
					Date dataSaida = rs.getDate(3);
					Integer idReserva = rs.getInt(4);
					System.out.println(id + " " + dataEntrada + " " + dataSaida + " " + idReserva);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}

}
