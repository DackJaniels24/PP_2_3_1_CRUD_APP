package web.userDAO;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl {
@PersistenceContext(unitName = "entityManager")
private EntityManager entityManager;

    public List<User>index(){
        return entityManager.createQuery("select u from User u", User.class)
                .getResultList();
    }
    public User show(Integer id) {
        TypedQuery<User> q = entityManager.createQuery("select u from User u where u.id=:id", User.class);
        q.setParameter("id", id);
         return q.getResultList().stream().findAny().orElse(null);
    }
    @Transactional
    public void remove(int id) {
        entityManager.remove(show(id));
    }

    @Transactional
    public void update(int id, User user) {
        entityManager.merge(user);
    }

    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }
}
