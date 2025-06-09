package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussgerenjianliDao;
import com.entity.DiscussgerenjianliEntity;
import com.service.DiscussgerenjianliService;
import com.entity.vo.DiscussgerenjianliVO;
import com.entity.view.DiscussgerenjianliView;

@Service("discussgerenjianliService")
public class DiscussgerenjianliServiceImpl extends ServiceImpl<DiscussgerenjianliDao, DiscussgerenjianliEntity> implements DiscussgerenjianliService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussgerenjianliEntity> page = this.selectPage(
                new Query<DiscussgerenjianliEntity>(params).getPage(),
                new EntityWrapper<DiscussgerenjianliEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussgerenjianliEntity> wrapper) {
		  Page<DiscussgerenjianliView> page =new Query<DiscussgerenjianliView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussgerenjianliVO> selectListVO(Wrapper<DiscussgerenjianliEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussgerenjianliVO selectVO(Wrapper<DiscussgerenjianliEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussgerenjianliView> selectListView(Wrapper<DiscussgerenjianliEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussgerenjianliView selectView(Wrapper<DiscussgerenjianliEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
