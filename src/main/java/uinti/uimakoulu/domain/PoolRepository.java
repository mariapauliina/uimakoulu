package uinti.uimakoulu.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface PoolRepository extends CrudRepository<Pool, Long> {
	List<Pool> findByPoolName(String poolname); 
}

