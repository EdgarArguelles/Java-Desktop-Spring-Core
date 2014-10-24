package spring.services;

import com.mysema.query.types.expr.BooleanExpression;
import java.util.List;
import org.springframework.data.domain.Sort;
import spring.Application;
import spring.models.QUser;
import spring.models.User;
import spring.repositories.UserRepository;

public class UserSvc {

    public List<User> getAll() {
        UserRepository repository = Application.springContext.getBean(UserRepository.class);
        //List<Usuario> list = repository.findAll(new Sort(Sort.Direction.ASC, "id"));
        List<User> list = repository.findAllByOrderByIdAsc();
        return list;
    }

    public User get(int id) {
        UserRepository repository = Application.springContext.getBean(UserRepository.class);
        User user = repository.findOne(id);
        return user;
    }

    public List<User> getByName(String name) {
        UserRepository repository = Application.springContext.getBean(UserRepository.class);
        //List<User> list = repository.findByNameOrderByIdDesc(name);
        List<User> list = repository.findByNameIgnoreCase(name, new Sort(Sort.Direction.DESC, "id"));
        return list;
    }

    public void save(User user) {
        UserRepository repository = Application.springContext.getBean(UserRepository.class);
        repository.save(user);
    }

    public List<User> getConsulta(String name) {
        UserRepository repository = Application.springContext.getBean(UserRepository.class);
        QUser query = QUser.user;
        BooleanExpression condicion = query.name.containsIgnoreCase(name);
        List<User> list = repository.findAll(condicion);
        return list;
    }

    public void example() {
        for (int i = 1; i < 8; i++) {
            save(new User("name " + i, "pass " + i, 1));
        }
        
        List<User> list = getAll();
        for (User u : list) {
            System.out.println(u);
        }
        System.out.println("******************");
        
        User us = get(1);
        us.setName("name 2");
        save(us);
        System.out.println(us);
        System.out.println("******************");
        
        list = getByName("name 2");
        for (User u : list) {
            System.out.println(u);
        }
        System.out.println("******************");
        
        list = getConsulta("e 2");
        for (User u : list) {
            System.out.println(u);
        }
        System.out.println("******************");
    }
}
