package service.util;

import java.time.Instant;

public class CalculaDiasEntreDatas {
	
	private static Long dias;
	private static Integer numeroDias;

	static Integer DiasEntreDatas(Instant dataInicio, Instant dataFim) {
		
		dias = ((dataFim.getEpochSecond() - dataInicio.getEpochSecond()) / 86400);

		numeroDias = Integer.valueOf(dias.intValue());

		return numeroDias;
	}
}
