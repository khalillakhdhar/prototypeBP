package com.elitech.services;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.elitech.dto.UserDTO;
import com.elitech.model.Role;
import com.elitech.model.User;
import com.elitech.repository.RoleRepository;
import com.elitech.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

private final UserRepository userRepository;
private final RoleRepository roleRepository;
private final ModelMapper modelMapper;
	
	@Override
	public UserDTO createUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user=modelMapper.map(userDTO,User.class);
		Set<Role> roles=user.getRoles();
		userDTO.getRoles().forEach(r->
		{
			roles.add(r);
		}
				);
		user.setRoles(roles);
		userRepository.save(user);
		return modelMapper.map(user, UserDTO.class);
		
		
	
						
				
		
	}

	@Override
	public UserDTO updateUser(long id, UserDTO userDTO) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(id))
		{
			return modelMapper.map(userRepository.save(modelMapper.map(userDTO, User.class)),UserDTO.class);
		}
		return null;
	}

	@Override
	public UserDTO getUserById(long id) {
		// TODO Auto-generated method stub
		if(userRepository.existsById(id))
			return modelMapper.map(userRepository.findById(id).get(), UserDTO.class);
		return null;
	}

	@Override
	public Page<UserDTO> getAllUsers(Pageable pageable) {
		// TODO Auto-generated method stub
		Page<User> users= userRepository.findAll(pageable);
		return users.map(u->modelMapper.map(u, UserDTO.class));
		
	}

	@Override
	public void deleteUser(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);

	}

}
