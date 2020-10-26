package io.renren.modules.app.service.impl;

import io.renren.modules.app.dao.ProgrammerDao;
import io.renren.modules.app.entity.ProgrammerEntity;
import io.renren.modules.app.service.ProgrammerService;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;




@Service("programmerService")
public class ProgrammerServiceImpl extends ServiceImpl<ProgrammerDao, ProgrammerEntity> implements ProgrammerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ProgrammerEntity> page = this.page(
                new Query<ProgrammerEntity>().getPage(params),
                new QueryWrapper<ProgrammerEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<ProgrammerEntity> randomSelect() {
        Integer count = this.baseMapper.selectCount(new QueryWrapper<ProgrammerEntity>());

        Random random = new Random();
        int flag = count > 10 ? 10 : count;
        Set set = new HashSet();

        while (true){
            if (set.size() >= flag) {
                break;
            }
            set.add(random.nextInt(count) + 1);
        }

        List<ProgrammerEntity> entities = this.baseMapper.selectList(new QueryWrapper<ProgrammerEntity>().in("id",set));
        return entities;
    }

}
