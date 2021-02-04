package service;

public interface PagamentoOnlineService {
	
	double taxaDePagamento(double valor);
	double juros(double valor, int meses);
	
}
