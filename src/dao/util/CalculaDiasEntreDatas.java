package dao.util;

import java.time.Instant;

public class CalculaDiasEntreDatas {
	
	private Long dias;
	private Integer numeroDias;
	
	public CalculaDiasEntreDatas() {
		
	}

	public Integer DiasEntreDatas(Instant dataInicio, Instant dataFim) {
		
		dias = ((dataFim.getEpochSecond() - dataInicio.getEpochSecond()) / 86400);

		numeroDias = Integer.valueOf(dias.intValue());

		 return numeroDias;
	}
}
