package com.example.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.example.dao.UserRepo;
import com.example.dao.AppUser;

public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepo userRepo;

    public CustomUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		for (AppUser user : userRepo.getUsers()) {

            if (user.getUserName().equals(username)) {

                return User.withUsername(user.getUserName())
						.password(user.getPassword())
						.roles(user.getRole())
						.build();
            }
        }

        throw new UsernameNotFoundException("User not found: " + username);
	}

}
