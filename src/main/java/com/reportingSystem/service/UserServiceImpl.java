package com.reportingSystem.service;

import com.reportingSystem.dto.UserDto;
import com.reportingSystem.exception.CustomNotFound;
import com.reportingSystem.exception.NotUniqueUser;
import com.reportingSystem.mapper.DefaultMapper;
import com.reportingSystem.model.UserModel;
import com.reportingSystem.repository.RoleRepository;
import com.reportingSystem.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private MapperFacade mapperFacade = new DefaultMapper();

    @Override
    public UserModel getUser(String username) {
        return userRepository.findUserModelByUsername(username);
    }

    public void createUser(UserDto userDto) {
        if (getUser(userDto.getUsername()) != null) {
            throw new NotUniqueUser("Not unique Username");
        } else if (userRepository.findUserModelByEmail(userDto.getEmail()) != null) {
            throw new NotUniqueUser("Not unique Email");
        } else {
            userDto.setStatus(true);
            userDto.setRoles(Arrays.asList(roleRepository.findRoleModelByRoleName("ROLE_USER")));
            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(mapperFacade.map(userDto, UserModel.class));
        }
    }

    @Override
    public UserDto getUserDetails(String username) {
        try {
            return mapperFacade.map(userRepository.findUserModelByUsername(username), UserDto.class);
        } catch (NullPointerException e) {
            throw new CustomNotFound("User not found");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserModelByUsername(username);
    }
}
