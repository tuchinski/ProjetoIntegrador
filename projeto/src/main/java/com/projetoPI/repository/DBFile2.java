package com.projetoPI.repository;

import org.springframework.stereotype.Repository;

import com.projetoPI.model.DBFile;

import org.springframework.data.repository.CrudRepository;
@Repository

public interface DBFile2 extends CrudRepository<DBFile, String>{

}
