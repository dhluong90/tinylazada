package com.luongdinh.identityserver.service;

import java.util.ArrayList;
import java.util.Optional;

import com.luongdinh.identityserver.domain.UserEntity;
import com.luongdinh.identityserver.dto.UserRequestDto;
import com.luongdinh.identityserver.repository.UserRepository;
import com.luongdinh.tinylazada.common.service.AbstractCRUDService;

import org.bouncycastle.operator.bc.BcRSAAsymmetricKeyUnwrapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityServiceImpl extends AbstractCRUDService<UserEntity, Long, UserRepository>
        implements UserEntityService, UserDetailsService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserEntityServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public UserEntity signUpByEmail(UserRequestDto userRequestDto) {
        ModelMapper modelMapper = new ModelMapper();
        UserEntity user = modelMapper.map(userRequestDto, UserEntity.class);
        user.setEnryptedPassword(this.bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
        return userRepository.save(user);
    }

    @Override
    protected PagingAndSortingRepository<UserEntity, Long> getEntityRepository() {
        return userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserDetails> user = userRepository.findByEmail(username).map(item -> {
            return new org.springframework.security.core.userdetails.User(item.getEmail(), item.getEnryptedPassword(),
                    new ArrayList());
        });
        return user.orElse(null);
    }

}
