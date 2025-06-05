/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Dao.UserDao;
import Model.User;
import java.util.List;

/**
 *
 * @author garci
 */
public class UserService {

    UserDao userDao = new UserDao();

    public User getUser(int cedula) throws Exception {
        return userDao.getByCedula(cedula);
    }

    public List<User> getAll() throws Exception {
        return userDao.getAll();
    }

    public boolean save(User user) throws Exception {
        return userDao.add(user);
    }

    public boolean update(User user) throws Exception {
        return userDao.update(user);
    }
        public boolean delete(int user) throws Exception {
        return userDao.delete(user);
    }
}
