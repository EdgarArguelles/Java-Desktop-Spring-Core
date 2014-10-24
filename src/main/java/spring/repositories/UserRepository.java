package spring.repositories;

import java.util.List;
import com.mysema.query.types.Predicate;
import spring.models.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface UserRepository extends JpaRepository<User, Integer>, QueryDslPredicateExecutor<User> {

    @Override
    List<User> findAll(Predicate predicate);

    List<User> findAllByOrderByIdAsc();

    List<User> findAllByOrderByNameDesc();

    List<User> findByPassword(String password, Sort sort);

    List<User> findByPassword(String password);

    List<User> findByNameOrderByIdDesc(String name);

    List<User> findByNameIgnoreCase(String nombre, Sort sort);
}
