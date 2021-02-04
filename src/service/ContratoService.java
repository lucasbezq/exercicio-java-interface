package service;

import java.util.Calendar;
import java.util.Date;

import entity.Contrato;
import entity.Prestacao;

public class ContratoService {

	private PagamentoOnlineService pagamentoOnline;

	public ContratoService(PagamentoOnlineService pagamentoOnline) {
		this.pagamentoOnline = pagamentoOnline;
	}

	public void processo(Contrato contrato, int meses) {
		double cotaBasica = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			Date data = addMeses(contrato.getData(), i);
			double atualizarCota = cotaBasica + pagamentoOnline.juros(cotaBasica, i);
			double cotaTotal = atualizarCota + pagamentoOnline.taxaDePagamento(atualizarCota);
			contrato.addPrestacao(new Prestacao(data, cotaTotal));
		}
	}

	private Date addMeses(Date data, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

}
