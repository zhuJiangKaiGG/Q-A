package io.renren.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import io.renren.modules.app.dao.EnglishDao;
import io.renren.modules.app.entity.EnglishEntity;
import io.renren.modules.app.service.EnglishService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String dateTime = (String) params.get("dateTime");
        QueryWrapper<EnglishEntity> wrapper = new QueryWrapper<>();
        if (!dateTime.isEmpty()) {
            Calendar calendar =  Calendar.getInstance();
            //要添加转换的格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                //使用Calendar类来实现日期的增减操作
                Date date = simpleDateFormat.parse(dateTime);
                calendar.setTime(date);
                calendar.add(Calendar.DAY_OF_YEAR, 1);
                Date time = calendar.getTime();
                String nextDay = simpleDateFormat.format(time);
                wrapper.ge("create_time", dateTime);
                wrapper.lt("create_time", nextDay);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        IPage<EnglishEntity> page = this.page(
                new Query<EnglishEntity>().getPage(params),
                wrapper
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
