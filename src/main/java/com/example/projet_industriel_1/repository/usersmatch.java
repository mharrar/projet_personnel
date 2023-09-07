package com.example.projet_industriel_1.repository;

import com.example.projet_industriel_1.model.match;
import com.example.projet_industriel_1.model.usersmodel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface usersmatch extends JpaRepository<match,Integer> {

}
