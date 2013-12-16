/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ensisa;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ASUS
 */
@ManagedBean
@SessionScoped
public class NewsController //Tiers Métier
{
    // On demande au conteneur web de nous fournir une référence vers le composant 
    //métier référencé par l'interface métier newsBean netbean local
    @EJB
    private NewsBeanLocal newsBean;
    private News editedNews = new News();
    /**
     * Creates a new instance of NewsController
     */
    public NewsController()
    {
        
    }
    
    public List<News> getNews() // Définition de l'accesseur pour avoir la liste des news
    {
        return newsBean.listAllNews();
    }
    
    public News getEditedNews()
    {
        return editedNews;
    }
    
    public String doCreateNews() //Soit le nom de la page qui ssera retourné soit une règle qui correspond au nom de la page dans laquelle on navigue.
    {
        editedNews = new News();
        return "createNews.xhtml";
    }

    public String doAddNews()
    {
        editedNews.setdate(new Date());
        newsBean.createNews(editedNews);
        return "index.xhtml";
    }
    
    public String doShowNews()
    {
        FacesContext ctx = FacesContext.getCurrentInstance(); // on prend les différents contextes
        Long id = Long.parseLong(ctx.getExternalContext().getRequestParameterMap().get("news"));
        editedNews = newsBean.getNews(id);
        return "news.xhtml";
    }
}
