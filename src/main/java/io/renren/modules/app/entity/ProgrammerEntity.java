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
@TableName("programmer")
public class ProgrammerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 题目名称
	 */
	private String name;
	/**
	 * 题目类型
	 */
	private String type;
	/**
	 * 题目出处
	 */
	private String provenance;
	/**
	 * 题目答案
	 */
	private String answer;

}
