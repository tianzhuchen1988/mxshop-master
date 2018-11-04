package cn.com.ydream.user.repository;

import cn.com.ydream.user.domain.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends PagingAndSortingRepository<Demo, Integer> {
    Demo findByDemoName(String demoName);
}
