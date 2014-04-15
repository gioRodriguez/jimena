package net.tecgurus.data.layer;

import java.util.List;

import net.tecgurus.data.layer.exceptions.ServiceUnavailableException;
import net.tecgurus.data.layer.model.User;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
	public boolean isValidUser(String userEmail, String userPassword) 
			throws ServiceUnavailableException {
		try{
			Criteria criteria = _sessionFactory
					.getCurrentSession()
					.createCriteria(User.class);
			
			criteria.add(Restrictions.eq("email", userEmail));
			criteria.add(Restrictions.eq("password", userPassword));
			
			List<User> result = criteria.list();
			return result.size() > 0;
		} catch(Exception e) {
			//TODO: log the error message
			throw new ServiceUnavailableException(e.getMessage(), e);
		}
	}

	@Override
	public boolean isEmailRegistered(String userEmail) 
			throws ServiceUnavailableException {
		try{
			Criteria criteria = _sessionFactory
					.getCurrentSession()
					.createCriteria(User.class);
			
			criteria.add(Restrictions.eq("email", userEmail));			
			
			List<User> result = criteria.list();
			return result.size() > 0;
		} catch(Exception e){
			//TODO: log the error message
			throw new ServiceUnavailableException(e.getMessage(), e);
		}
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
