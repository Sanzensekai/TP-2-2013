/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ensisa;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ASUS
 */
@Local
public interface NewsBeanLocal
{
    List<News> listAllNews();
    News createNews(News news); //Prend un objet java et le sérialise afin de le stocker dans la base.

    public News getNews(Long id);
}
