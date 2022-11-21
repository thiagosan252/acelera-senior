package net.atos.animals.security;

import javax.transaction.Transactional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import net.atos.animals.model.UserModel;
import net.atos.animals.repository.UserRepository;

@Service
@Transactional
public class UserDetailServiceImpl implements UserDetailsService {

	final UserRepository userRepository;
	
	public UserDetailServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
	UserModel userModel = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Usuario não Encontrado" + username));                       
		
		return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true, userModel.getAuthorities() );
	}
	


}
