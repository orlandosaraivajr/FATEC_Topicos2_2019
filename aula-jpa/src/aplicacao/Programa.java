package aplicacao;

import java.util.List;

import dominio.Pessoa;
import dominio.PessoaController;

public class Programa {

	public static void main(String[] args) {
		Pessoa p1 = new Pessoa(null,"Orlando","orlando@gmail.com","1111");
		Pessoa p2 = new Pessoa(null,"Teste","teste@gmail.com","22222");
		Pessoa p3 = new Pessoa(null,"Ana","ana@gmail.com","3333");
		/*
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		*/
		PessoaController controlador = new PessoaController();
		// https://blog.caelum.com.br/entidades-managed-transient-e-detached-no-hibernate-e-jpa/
		/*
		controlador.salvar(p1);
		controlador.salvar(p2);
		controlador.salvar(p3);
		*/
		/* Removendo passando o objeto p2 */
		controlador.remover(p2);
		/* Removendo passando o id do registro (int) */
		// controlador.remover(17);
		
		List<Pessoa> lista = null;
		lista = controlador.buscarTodos();
		System.out.println("Pessoas encontradas : "+ lista.size());
		for(Pessoa pessoa: lista) {
			System.out.println(pessoa);
		}
		controlador.fechar();
	}

}
