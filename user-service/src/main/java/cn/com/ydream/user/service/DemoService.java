package cn.com.ydream.user.service;

import cn.com.ydream.user.domain.Demo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DemoService {
    Demo saveDemo(Demo demo);
    Demo findDemoById(Integer demoId);
    Page<Demo> findDemoListByPage(Pageable pageable);
    Demo updateDemo(Demo demo);
    void deleteDemo(Integer demoId);
}
