package com.xyyh.lazylob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xyyh.lazylob.entity.User;

public interface UserRepository  extends JpaRepository<User, Long>{

}
