package com.luongdinh.identityserver.repository;

import com.luongdinh.identityserver.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>  {
    
    
}
