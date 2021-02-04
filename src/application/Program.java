package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entity.Contrato;
import model.entity.Prestacao;
import service.ContratoService;
import service.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Entre com os dados da conta: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy):");
		Date data = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double valor = sc.nextDouble();

		Contrato contrato = new Contrato(numero, data, valor);

		System.out.print("Entre com o numero de parcelas: ");
		int parcelas = sc.nextInt();

		ContratoService contratoService = new ContratoService(new PaypalService());
		contratoService.processo(contrato, parcelas);

		System.out.println();
		System.out.println("PARCELAS: ");
		for (Prestacao p : contrato.getPrestacoes()) {
			System.out.println(p);
		}
		sc.close();
	}
}
