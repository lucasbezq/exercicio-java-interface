package service;

public class PaypalService implements PagamentoOnlineService {

	private static final double PORCENTAGEM_TAXA = 0.02;
	private static final double JUROS_MENSAIS = 0.01;

	@Override
	public double taxaDePagamento(double valor) {
		return valor * PORCENTAGEM_TAXA;
	}

	@Override
	public double juros(double valor, int meses) {
		return valor * JUROS_MENSAIS * meses;
	}

}
