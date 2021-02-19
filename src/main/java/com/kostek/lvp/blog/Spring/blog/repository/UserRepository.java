package com.kostek.lvp.blog.Spring.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kostek.lvp.blog.Spring.blog.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
