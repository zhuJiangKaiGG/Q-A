package io.renren.modules.app.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import io.renren.modules.app.entity.EnglishEntity;
import io.renren.modules.app.service.EnglishService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
@RequestMapping("generator/english")
public class EnglishController {
    @Autowired
    private EnglishService englishService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = englishService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){
		EnglishEntity english = englishService.getById(id);

        return R.ok().put("english", english);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody EnglishEntity english){
        english.setCreateTime(new Date());
		englishService.save(english);

        return R.ok();
    }
    /**
     * 批量保存
     */
    @RequestMapping("/batchSave")
    public R batchSave(@RequestBody EnglishEntity[] englishes){
        for (EnglishEntity english : englishes) {
            english.setCreateTime(new Date());
        }
        englishService.batchSave(englishes);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody EnglishEntity english){
		englishService.updateById(english);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
		englishService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

    /**
     * 随机查找单词
     */
    @RequestMapping("/randomselect")
    public R randomSelect(){
        List<EnglishEntity> englishEntities = englishService.randomSelect();
        return R.ok().put("page", englishEntities);
    }

    /**
     * 获取当日新增的单词
     */
    @RequestMapping("/addInToday")
    public R addInToday(){
        List<EnglishEntity> entities=englishService.addInToday();
        return R.ok().put("page", entities);
    }
}
