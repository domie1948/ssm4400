package com.dao;

import com.entity.PingjiaqiyeEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiaqiyeVO;
import com.entity.view.PingjiaqiyeView;


/**
 * 评价企业
 * 
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
public interface PingjiaqiyeDao extends BaseMapper<PingjiaqiyeEntity> {
	
	List<PingjiaqiyeVO> selectListVO(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
	
	PingjiaqiyeVO selectVO(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
	
	List<PingjiaqiyeView> selectListView(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);

	List<PingjiaqiyeView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
	
	PingjiaqiyeView selectView(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
	
}
