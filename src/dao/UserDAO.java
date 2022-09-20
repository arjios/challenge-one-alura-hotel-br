package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import dto.UserDTO;
import factory.ConnectionFactory;
import repositories.UserRepository;

public class UserDAO implements UserRepository {
	
	private UserDTO userDTO = new UserDTO();
	
	private Set<UserDTO> users = new HashSet<>();

	@Override
	public Set<UserDTO> findAll() {
		try {
			Connection con = ConnectionFactory.createConnection();
			Statement st =  con.createStatement();
			st.execute("SELECT * FROM USER");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				userDTO.setId(rs.getLong(1));
				userDTO.setNome(rs.getNString(2));
				users.add(userDTO);
				System.out.println(users);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public UserDTO findById(Long id) {
		try {
			Connection con = ConnectionFactory.createConnection();
			Statement st =  con.createStatement();
			st.execute("SELECT * FROM USER WHERE ID = ?");
			ResultSet rs = st.getResultSet();
			userDTO.setId(rs.getLong(1));
			userDTO.setNome(rs.getString(2));
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public UserDTO findByName(String name) {
		String sql = "select * from user";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery(sql);
			while(rs.next()) {
				if(name.equals(rs.getString(2))) {
					userDTO.setNome(name);
					userDTO.setNome(rs.getString(2));
					userDTO.setSenha(rs.getString(3));
				}
			}
		} catch (Exception e) {
			System.out.println("Ocorreu erro na leitura do nome em User.");
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
		return userDTO;
	}

}
