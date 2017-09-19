package com.wura.dojo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.wura.dojo.models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long> {

		@Query("SELECT n, d FROM Ninja n JOIN n.dojo d")
		List<Object[]> joinAll();
}
