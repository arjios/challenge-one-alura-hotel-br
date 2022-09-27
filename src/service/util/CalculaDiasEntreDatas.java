package service.util;

import java.time.Instant;

public class CalculaDiasEntreDatas {
	
	private static Long dias;
	private static Integer numeroDias;

	static Integer DiasEntreDatas(Instant dataInicio, Instant dataFim) {
		
		if(dataFim != null && dataInicio != null) {
			dias = ((dataFim.getEpochSecond() - dataInicio.getEpochSecond()) / 86400);

			numeroDias = Integer.valueOf(dias.intValue());
		} else {
			numeroDias = 0;
		}

		return numeroDias;
	}
}
