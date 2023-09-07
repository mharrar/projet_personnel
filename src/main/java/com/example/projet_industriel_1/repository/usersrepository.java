package com.example.projet_industriel_1.repository;

import com.example.projet_industriel_1.model.usersmodel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface usersrepository extends JpaRepository<usersmodel,Integer> {
    Optional<usersmodel> findByloginAndPassword(String login, String password);




}
