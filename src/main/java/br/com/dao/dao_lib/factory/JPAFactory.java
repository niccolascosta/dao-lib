package br.com.dao.dao_lib.factory;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.dao.dao_lib.configuration.annotation.Configuration;

@ApplicationScoped
public class JPAFactory {

	private EntityManagerFactory emf;

	@Inject
	@Configuration
	private Properties properties;

	public void close(@Disposes EntityManager em) {
		if (em.isOpen()) {
			em.close();
		}
	}

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return this.emf.createEntityManager();
	}

	@PostConstruct
	public void loadEMF() {
		this.emf = Persistence.createEntityManagerFactory(this.properties.getProperty("dao.lib.persistenceUnid"));
	}

	@PreDestroy
	public void preDestroy() {
		if (this.emf.isOpen()) {
			this.emf.close();
		}
	}
}
