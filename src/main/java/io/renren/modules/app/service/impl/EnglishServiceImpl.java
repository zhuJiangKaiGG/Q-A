package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.renren.modules.app.dao.EnglishDao;
import io.renren.modules.app.entity.EnglishEntity;
import io.renren.modules.app.service.EnglishService;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;



@Service("englishService")
public class EnglishServiceImpl extends ServiceImpl<EnglishDao, EnglishEntity> implements EnglishService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<EnglishEntity> page = this.page(
                new Query<EnglishEntity>().getPage(params),
                new QueryWrapper<EnglishEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<EnglishEntity> randomSelect() {
        List<EnglishEntity> entities = baseMapper.randomSelect(10);
        return entities;
    }

    @Override
    public void batchSave(EnglishEntity[] englishes) {
        this.saveBatch(Arrays.asList(englishes));
    }

    @Override
    public List<EnglishEntity> addInToday() {
        List<EnglishEntity> entities = baseMapper.addInToday();
        return entities;
    }

}
