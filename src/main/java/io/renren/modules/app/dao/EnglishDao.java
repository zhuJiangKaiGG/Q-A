package io.renren.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.app.entity.EnglishEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-06 09:09:54
 */
@Mapper
public interface EnglishDao extends BaseMapper<EnglishEntity> {

    void updateNums(@Param("list") List<Integer> list);

    List<EnglishEntity> randomSelect(@Param("limit") int limit);

    List<EnglishEntity> addInToday();
}
