package dominio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaController {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PessoaController() {
		this.emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		this.em = emf.createEntityManager();
	}

	public void fechar() {
		this.em.close();
		this.emf.close();
	}
	
	public void salvar(Pessoa pessoa) {
		this.em.getTransaction().begin();
		this.em.persist(pessoa);
		this.em.getTransaction().commit();
	}

	public void remover(Pessoa pessoa) {
		this.em.getTransaction().begin();
		this.em.remove(pessoa);
		this.em.getTransaction().commit();
	}

	public void remover(int id) {
		Pessoa p = this.em.find(Pessoa.class, id);
		this.remover(p);
		/*
		this.em.getTransaction().begin();
		this.em.remove(p);
		this.em.getTransaction().commit();
		*/
	}
	
	public List<Pessoa> buscarTodos(){
		this.em.getTransaction().begin();
		List<Pessoa> lista = this.em.createQuery("SELECT p FROM Pessoa p").getResultList();
		this.em.getTransaction().commit();
		return lista;
	}
}
