package cn.com.ydream.user.controller;

import cn.com.ydream.common.wrapper.WrapMapper;
import cn.com.ydream.common.wrapper.Wrapper;
import cn.com.ydream.user.domain.Demo;
import cn.com.ydream.user.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/saveDemo", method = RequestMethod.PUT)
    public Wrapper<Integer> saveDemo(@Valid @RequestBody Demo demo){
        demoService.saveDemo(demo);
        return WrapMapper.ok();
    }

    @RequestMapping(value = "/{demoId}", method = RequestMethod.GET)
    public Wrapper<Demo> findDemoById(@PathVariable Integer demoId){
        Demo d = demoService.findDemoById(demoId);
        return WrapMapper.ok(d);
    }

    @RequestMapping(value = "/queryDemoListWithPage", method = RequestMethod.GET)
    public Wrapper<Page<Demo>> queryDemoListWithPage(
            @PageableDefault(sort = { "demoId" }, direction = Sort.Direction.DESC) Pageable pageable){
        return WrapMapper.ok(demoService.findDemoListByPage(pageable));
    }

    @RequestMapping(value = "updateDemo", method = RequestMethod.POST)
    public Wrapper updateDemo(@Valid @RequestBody Demo demo){
        demoService.saveDemo(demo);
        return WrapMapper.ok();
    }

    @RequestMapping(value = "/{demoId}", method = RequestMethod.DELETE)
    public Wrapper deleteDemo(@PathVariable Integer demoId){
        demoService.deleteDemo(demoId);
        return WrapMapper.ok();
    }
}
