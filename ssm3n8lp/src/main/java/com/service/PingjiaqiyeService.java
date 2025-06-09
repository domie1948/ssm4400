package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiaqiyeEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiaqiyeVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiaqiyeView;


/**
 * 评价企业
 *
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
public interface PingjiaqiyeService extends IService<PingjiaqiyeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiaqiyeVO> selectListVO(Wrapper<PingjiaqiyeEntity> wrapper);
   	
   	PingjiaqiyeVO selectVO(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
   	
   	List<PingjiaqiyeView> selectListView(Wrapper<PingjiaqiyeEntity> wrapper);
   	
   	PingjiaqiyeView selectView(@Param("ew") Wrapper<PingjiaqiyeEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiaqiyeEntity> wrapper);
   	
}

