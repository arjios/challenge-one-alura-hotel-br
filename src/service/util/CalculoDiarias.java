package service.util;

import java.time.Instant;

public class CalculoDiarias {

	public static Double valorDiarias(Double v, Instant dataEntrada, Instant dataSaida) {
		return v * CalculaDiasEntreDatas.DiasEntreDatas(dataEntrada, dataSaida);
	}
}
