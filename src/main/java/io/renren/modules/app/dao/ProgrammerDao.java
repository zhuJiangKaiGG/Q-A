package io.renren.modules.app.dao;

import io.renren.modules.app.entity.ProgrammerEntity;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-06 09:09:54
 */
@Mapper
public interface ProgrammerDao extends BaseMapper<ProgrammerEntity> {

}
