package com.dosja.Dosja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dosja.Dosja.model.Punet;

import java.util.UUID;

@Repository
public interface PunetRepository extends JpaRepository<Punet, UUID> {

}
