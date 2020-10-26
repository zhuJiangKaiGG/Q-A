package io.renren.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2020-10-06 09:09:54
 */
@Data
@TableName("english")
public class EnglishEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 单词名称
	 */
	private String name;
	/**
	 * 中文翻译
	 */
	private String chTranslate;
	/**
	 * 添加时间
	 */
	private Date createTime;
	/**
	 * 出现次数
	 */
	private Integer nums;

}
