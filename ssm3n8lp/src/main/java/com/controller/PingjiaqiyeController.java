package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.PingjiaqiyeEntity;
import com.entity.view.PingjiaqiyeView;

import com.service.PingjiaqiyeService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 评价企业
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-11 00:56:04
 */
@RestController
@RequestMapping("/pingjiaqiye")
public class PingjiaqiyeController {
    @Autowired
    private PingjiaqiyeService pingjiaqiyeService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingjiaqiyeEntity pingjiaqiye, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			pingjiaqiye.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiye")) {
			pingjiaqiye.setQiyezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingjiaqiyeEntity> ew = new EntityWrapper<PingjiaqiyeEntity>();
		PageUtils page = pingjiaqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiaqiye), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingjiaqiyeEntity pingjiaqiye, HttpServletRequest request){
        EntityWrapper<PingjiaqiyeEntity> ew = new EntityWrapper<PingjiaqiyeEntity>();
		PageUtils page = pingjiaqiyeService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingjiaqiye), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingjiaqiyeEntity pingjiaqiye){
       	EntityWrapper<PingjiaqiyeEntity> ew = new EntityWrapper<PingjiaqiyeEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingjiaqiye, "pingjiaqiye")); 
        return R.ok().put("data", pingjiaqiyeService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingjiaqiyeEntity pingjiaqiye){
        EntityWrapper< PingjiaqiyeEntity> ew = new EntityWrapper< PingjiaqiyeEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingjiaqiye, "pingjiaqiye")); 
		PingjiaqiyeView pingjiaqiyeView =  pingjiaqiyeService.selectView(ew);
		return R.ok("查询评价企业成功").put("data", pingjiaqiyeView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingjiaqiyeEntity pingjiaqiye = pingjiaqiyeService.selectById(id);
        return R.ok().put("data", pingjiaqiye);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingjiaqiyeEntity pingjiaqiye = pingjiaqiyeService.selectById(id);
        return R.ok().put("data", pingjiaqiye);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingjiaqiyeEntity pingjiaqiye, HttpServletRequest request){
    	pingjiaqiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingjiaqiye);

        pingjiaqiyeService.insert(pingjiaqiye);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingjiaqiyeEntity pingjiaqiye, HttpServletRequest request){
    	pingjiaqiye.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingjiaqiye);

        pingjiaqiyeService.insert(pingjiaqiye);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody PingjiaqiyeEntity pingjiaqiye, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingjiaqiye);
        pingjiaqiyeService.updateById(pingjiaqiye);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingjiaqiyeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<PingjiaqiyeEntity> wrapper = new EntityWrapper<PingjiaqiyeEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			wrapper.eq("zhanghao", (String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qiye")) {
			wrapper.eq("qiyezhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = pingjiaqiyeService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
