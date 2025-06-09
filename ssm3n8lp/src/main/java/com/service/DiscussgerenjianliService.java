package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussgerenjianliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussgerenjianliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussgerenjianliView;


/**
 * 个人简历评论表
 *
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
public interface DiscussgerenjianliService extends IService<DiscussgerenjianliEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussgerenjianliVO> selectListVO(Wrapper<DiscussgerenjianliEntity> wrapper);
   	
   	DiscussgerenjianliVO selectVO(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
   	
   	List<DiscussgerenjianliView> selectListView(Wrapper<DiscussgerenjianliEntity> wrapper);
   	
   	DiscussgerenjianliView selectView(@Param("ew") Wrapper<DiscussgerenjianliEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussgerenjianliEntity> wrapper);
   	
}

