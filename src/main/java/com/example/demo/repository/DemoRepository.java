package com.example.demo.repository;
import com.example.demo.model.DemoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface DemoRepository extends JpaRepository<DemoModel,Integer>
{

    @Query(value = "select * from raghavendran.raghav where raghav.district= :district",nativeQuery = true)
    DemoModel findByDistrict(String district);
}
