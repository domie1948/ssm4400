package com.dao;

import com.entity.DiscussgerenjianliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussgerenjianliVO;
import com.entity.view.DiscussgerenjianliView;


/**
 * 个人简历评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
public interface DiscussgerenjianliDao extends BaseMapper<DiscussgerenjianliEntity> {
	
	List<DiscussgerenjianliVO> selectListVO(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
	
	DiscussgerenjianliVO selectVO(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
	
	List<DiscussgerenjianliView> selectListView(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);

	List<DiscussgerenjianliView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
	
	DiscussgerenjianliView selectView(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
	
}
