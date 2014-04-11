package net.tecgurus.data.layer;

import org.springframework.stereotype.Repository;

@Repository(UserRepository.HIBERNATE_IMPL)
public class UserRepositoryHibernateImpl implements UserRepository {

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
	public int registerUser(String userName, String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return 0;
	}

}
