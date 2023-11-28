package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.UserDto;

public class UserDao {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager=factory.createEntityManager();
    
    public void saveUser(UserDto dto)
    {
    	manager.getTransaction().begin();
    	manager.persist(dto);
    	manager.getTransaction().commit();
    	
    }
    public UserDto findByEmail(String email)
    {
    	Query query=manager.createQuery("select x from UserDto x where email=?1").setParameter(1, email);
    	List<UserDto>list=query.getResultList();
    	if(!list.isEmpty())
    		return list.get(0);
    	else
    		return null;
    	
    }
}
