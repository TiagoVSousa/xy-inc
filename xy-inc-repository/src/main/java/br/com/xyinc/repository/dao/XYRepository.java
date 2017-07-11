package br.com.xyinc.repository.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.xyinc.repository.entity.POI;

@Repository
public interface XYRepository extends JpaRepository<POI, Integer>, Serializable{

	List<POI> findAll();
}
