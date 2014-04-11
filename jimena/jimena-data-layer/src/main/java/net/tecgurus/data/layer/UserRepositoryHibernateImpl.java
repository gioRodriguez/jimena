package net.tecgurus.data.layer;

import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;
import net.tecgurus.data.layer.model.User;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository(UserRepository.HIBERNATE_IMPL)
public class UserRepositoryHibernateImpl implements UserRepository {

	private final SessionFactory _sessionFactory;
	
	@Autowired
	public UserRepositoryHibernateImpl(SessionFactory sessionFactory) {
		_sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean isValidUser(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmailRegistered(String userEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long registerUser(
			String userName, 
			String userEmail, 
			String userPassword
	) throws ServiceUnavailableException {
		try {
			User user = new User();
			user.setEmail(userEmail);
			user.setName(userName);
			user.setPassword(userPassword);
					
			return (Long) _sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			//TODO: log the error message
			throw new ServiceUnavailableException(e.getMessage(), e);
		}
	}
	
	
	
	
	

}
