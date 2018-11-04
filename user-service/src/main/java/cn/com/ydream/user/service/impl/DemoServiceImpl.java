package cn.com.ydream.user.service.impl;

import cn.com.ydream.common.enums.ErrorCodeEnum;
import cn.com.ydream.user.domain.Demo;
import cn.com.ydream.user.domain.DemoStatusEnum;
import cn.com.ydream.user.exception.DemoServiceException;
import cn.com.ydream.user.repository.DemoRepository;
import cn.com.ydream.user.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public Demo saveDemo(Demo demo) {
        Demo existing = demoRepository.findByDemoName(demo.getDemoName());

        //Assert.isNull(existing, "demo名称已存在" + demo.getDemoName());
        if(existing != null){
            throw new DemoServiceException(ErrorCodeEnum.DEMO1002, demo.getDemoName());
        }

        demo.setCreateId(1);
        demo.setCreateTime(new Date());
        demo.setDemoStatus(DemoStatusEnum.getDefault());

        log.info("创建了一个demo: {}", demo.getDemoName());

        return demoRepository.save(demo);
    }

    @Override
    public Demo findDemoById(Integer demoId) {
        Assert.notNull(demoId, "demoId不能为空");

        return demoRepository.findOne(demoId);
    }

    @Override
    public Page<Demo> findDemoListByPage(Pageable pageable) {
        return demoRepository.findAll(pageable);
    }

    @Override
    public Demo updateDemo(Demo demo) {
        return demoRepository.save(demo);
    }

    @Override
    public void deleteDemo(Integer demoId) {
        demoRepository.delete(demoId);
    }
}
