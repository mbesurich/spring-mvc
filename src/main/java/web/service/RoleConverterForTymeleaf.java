package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.Role;

@Component
public class RoleConverterForTymeleaf implements Converter<String, Role> {

    @Autowired
    UserDao userDao;

    @Override
    public Role convert(String s) {
        System.out.println("---------------------RoleConverterForTymeleaf ----------------------");
        return userDao.getRoleByName(s);
    }
}
