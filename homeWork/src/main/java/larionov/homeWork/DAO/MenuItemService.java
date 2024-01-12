package larionov.homeWork.DAO;

import larionov.homeWork.entities.MenuItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MenuItemService {
    @Autowired
    MenuItemDAO menuItemDAO;

    public void saveMenuItem(MenuItem menuItem) {
        menuItemDAO.save(menuItem);
        log.info(menuItem.getNome() + " " + "Salvato Correttamente Nel DB");
    }
}
