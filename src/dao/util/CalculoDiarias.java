package dao.util;

import java.time.Instant;

public class CalculoDiarias {

	private CalculaDiasEntreDatas calculaDiasEntreDatas = new CalculaDiasEntreDatas();
	
	public CalculoDiarias() {
	}

	public Double calculaValorDiariasTotal(Double v, Instant dataEntrada, Instant dataSaida) {
		return v * calculaDiasEntreDatas.DiasEntreDatas(dataEntrada, dataSaida);
	}
}
