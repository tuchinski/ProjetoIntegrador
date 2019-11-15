package com.projetoPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoPI.model.DBFile;


@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String>{
}
