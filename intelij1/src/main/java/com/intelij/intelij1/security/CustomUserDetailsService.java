package com.intelij.intelij1.security;

import com.intelij.intelij1.entity.Role;
import com.intelij.intelij1.entity.User;
import com.intelij.intelij1.repository.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

        private UserRepository userRepository;
        public CustomUserDetailsService(UserRepository userRepository){
            this.userRepository=userRepository;
        }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

          User user= userRepository.findByUsernameOrEmail(username,username)
                  .orElseThrow(() ->
                          new UsernameNotFoundException("User not found with username or email:" +username));

          return new org.springframework.security.core.userdetails.User(user.getEmail(),
                  user.getPassword(),mapRolesAuthorities(user.getRoles()));

    }
    private List<SimpleGrantedAuthority> mapRolesAuthorities(Set<Role> roles){
            return  roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
