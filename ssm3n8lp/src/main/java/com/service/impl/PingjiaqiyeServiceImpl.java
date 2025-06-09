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


import com.dao.PingjiaqiyeDao;
import com.entity.PingjiaqiyeEntity;
import com.service.PingjiaqiyeService;
import com.entity.vo.PingjiaqiyeVO;
import com.entity.view.PingjiaqiyeView;

@Service("pingjiaqiyeService")
public class PingjiaqiyeServiceImpl extends ServiceImpl<PingjiaqiyeDao, PingjiaqiyeEntity> implements PingjiaqiyeService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingjiaqiyeEntity> page = this.selectPage(
                new Query<PingjiaqiyeEntity>(params).getPage(),
                new EntityWrapper<PingjiaqiyeEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingjiaqiyeEntity> wrapper) {
		  Page<PingjiaqiyeView> page =new Query<PingjiaqiyeView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingjiaqiyeVO> selectListVO(Wrapper<PingjiaqiyeEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingjiaqiyeVO selectVO(Wrapper<PingjiaqiyeEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingjiaqiyeView> selectListView(Wrapper<PingjiaqiyeEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingjiaqiyeView selectView(Wrapper<PingjiaqiyeEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
