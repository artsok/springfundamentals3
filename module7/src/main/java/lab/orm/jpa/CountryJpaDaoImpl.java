package lab.orm.jpa;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lab.orm.CountryDao;
import lab.model.Country;

@Repository
public class CountryJpaDaoImpl extends AbstractJpaDao implements CountryDao {


    @Override
    public void save(Country country) {
        Optional.ofNullable(emf.createEntityManager()).ifPresent(em -> {
            em.getTransaction().begin();
            em.persist(country);
            em.getTransaction().commit();
            em.close();
        });
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countryList = null;
        EntityManager em = emf.createEntityManager();
        if (Objects.nonNull(em)) {
            em.getTransaction().begin();
            countryList = em.createQuery("select c from Country c", Country.class).getResultList();
            em.getTransaction().commit();
        }
        em.close();
        return countryList;
    }

    @Override
    public Country getCountryByName(String name) {
        return null;
    }

}
