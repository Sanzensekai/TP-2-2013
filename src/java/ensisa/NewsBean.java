/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ensisa;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ASUS
 */
@Stateless
public class NewsBean implements NewsBeanLocal
{
    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<News> listAllNews()
    {
        Query query = em.createQuery("SELECT n FROM News n ORDER BY n.date ASC"); // On doit créer une requête et ainsi s'adresser au gestionnaire d'entité.
        return query.getResultList();
    }
    
    /**
     *
     * @param news
     * @return
     */
    @Override
    public News createNews(News news)
    {
        em.persist(news);
        return news;
    }

    @Override
    public News getNews(Long id)
    {
        return em.find(News.class, id);
    }
}
