package com.jnu.sssp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jnu.sssp.entity.Department;

@Repository
public interface DepartmentRepository extends
		JpaRepository<Department, Integer> {

//	@QueryHints({ @QueryHint(name = org.hibernate.ejb.QueryHints.HINT_CACHEABLE, value = "true") })
//	@Query("FROM Department d")
//	List<Department> getAll();

}
