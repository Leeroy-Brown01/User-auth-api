package com.brown.user_auth_api.repository;

import com.brown.user_auth_api.models.NewUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <NewUser, Long> {


}
