package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.Set;

import dto.HospedeDTO;
import entities.Hospede;
import factory.ConnectionFactory;
import repositories.HospedeRepository;

public class HospedeDAO implements HospedeRepository {
	
	private Hospede hospede;
	private Set<Hospede> hospedes = new HashSet<>();

	@Override
	public Set<Hospede> findAll() {
		try {
			Connection con = ConnectionFactory.createConnection();
			Statement st =  con.createStatement();
			st.execute("SELECT * FROM hospede");
			ResultSet rs = st.getResultSet();
			while(rs.next()) {
				Hospede hospede = new Hospede();
				hospede.setId(rs.getLong("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setSobrenome(rs.getString("sobrenome"));
				hospede.setTelefone(rs.getString("telefone"));
				
				LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
				Instant instantNascimento = nascimento.atStartOfDay().toInstant(ZoneOffset.UTC);
				hospede.setDataNascimento(instantNascimento);
				
				hospede.setIdReserva(rs.getInt("id_reserva"));
				hospede.setNacionalidade(rs.getString("nacionalidade"));
				hospedes.add(hospede);
			}
		} catch(Exception e) {
			System.out.println(e.getStackTrace() + " Erro: " + e.getMessage());
		}
		return hospedes;
	}

	@Override
	public HospedeDTO findByIdReserva(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(HospedeDTO hospedeDTO) {
		String sql = "INSERT INTO hospede" +
					"(nome, sobrenome, telefone, data_nascimento, id_reserva, nacionalidade)" +
					"VALUES (?, ?, ?, ?, ?, ?)";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConnectionFactory.createConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, hospedeDTO.getNome());
			ps.setString(2, hospedeDTO.getSobrenome());
			ps.setNString(3,  hospedeDTO.getTelefone());
			
			LocalDate entrada = LocalDate.ofInstant(hospedeDTO.getDataNascimento(), ZoneId.systemDefault());
			Date e = Date.valueOf(entrada);		
			ps.setDate(4,  e);
			
			ps.setLong(5, hospedeDTO.getIdReserva());
			ps.setNString(6, hospedeDTO.getNacionalidade());
			ps.execute();
			
		} catch(Exception e) {
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
	}

	@Override
	public HospedeDTO update(Long idReserva, HospedeDTO hospdeDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospedeDTO delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
