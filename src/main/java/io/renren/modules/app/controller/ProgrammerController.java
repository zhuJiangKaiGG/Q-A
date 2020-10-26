package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.ProgrammerEntity;
import io.renren.modules.app.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;



/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-06 09:09:54
 */
@RestController
@RequestMapping("generator/programmer")
public class ProgrammerController {
    @Autowired
    private ProgrammerService programmerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = programmerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		ProgrammerEntity programmer = programmerService.getById(id);

        return R.ok().put("programmer", programmer);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ProgrammerEntity programmer){
		programmerService.save(programmer);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ProgrammerEntity programmer){
		programmerService.updateById(programmer);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		programmerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 随机选题
     */
    @RequestMapping("/randomselect")
    public R randomSelect(){
        List<ProgrammerEntity>list = programmerService.randomSelect();
        return R.ok().put("page", list);
    }
}
