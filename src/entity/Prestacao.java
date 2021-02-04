package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private Date vencimento;
	private Double valor;

	public Prestacao() {
	}

	public Prestacao(Date vencimento, Double valor) {
		super();
		this.vencimento = vencimento;
		this.valor = valor;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return sdf.format(vencimento) + ", " + String.format("%.2f", valor);
	}

}
