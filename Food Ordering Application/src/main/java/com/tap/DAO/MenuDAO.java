package com.tap.DAO;

import java.util.List;
import com.tap.model.menu;


public interface MenuDAO {

	 void addMenu(menu m);

	    menu getMenu(int id);

	    void updateMenu(menu m);

	    void deleteMenu(int id);

	    List<menu> getAllMenu();
}
