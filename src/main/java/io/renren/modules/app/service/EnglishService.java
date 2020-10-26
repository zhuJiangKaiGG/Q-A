package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.app.entity.EnglishEntity;


import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-06 09:09:54
 */
public interface EnglishService extends IService<EnglishEntity> {
    PageUtils queryPage(Map<String, Object> params);

    List<EnglishEntity> randomSelect();

    void batchSave(EnglishEntity[] englishes);

    List<EnglishEntity> addInToday();
}

