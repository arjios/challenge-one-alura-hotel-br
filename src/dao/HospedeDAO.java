package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
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
				hospede.setId(rs.getLong("id"));
				hospede.setNome(rs.getString("nome"));
				hospede.setSobrenome(rs.getString("sobrenome"));
				hospede.setTelefone(rs.getString("telefone"));
				
				LocalDate nascimento = rs.getDate("data_nascimento").toLocalDate();
				Instant instantNascimento = nascimento.atStartOfDay().toInstant(ZoneOffset.UTC);
				hospede.setDataNascimento(instantNascimento);
				
				hospede.setIdReserva(rs.getInt("id_reserva"));
				hospede.setNacionalidade(rs.getString("nacionalidade"));

			}
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return hospedes;
	}

	@Override
	public HospedeDTO findByIdReserva(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospedeDTO insert(HospedeDTO hospedeDTO) {
		// TODO Auto-generated method stub
		return null;
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
