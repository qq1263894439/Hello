package com.pinyougou.sellergoods.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.pojo.TbBrandExample.Criteria;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;




//品牌管理接口
@Service
public class BrandServiceImpl implements BrandService {
	/**
	 *查询所有品牌列表
	 */
	@Autowired
	private TbBrandMapper brandMapper;
	@Override
	public List<TbBrand> findAll() {
		//查询所有
		return brandMapper.selectByExample(null);
	}
	
	/**
	 * PageHelper分页
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(null);
	
		return new PageResult(page.getTotal(), page.getResult());
	}
	/**
	 * 添加品牌
	 */
	@Override
	public void add(TbBrand tbBrand) {
		brandMapper.insert(tbBrand);
		
	}

	/**
	 * 根据ID查询实体
	 */
	@Override
	public TbBrand findOne(Long id) {
		
		return brandMapper.selectByPrimaryKey(id);
	
	}

	/**
	 * 修改
	 */
	@Override
	public void update(TbBrand brand) {
		brandMapper.updateByPrimaryKey(brand);
	
	}

	@Override
	public void delete(Long[] ids) {
		for (Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
		
	}

	@Override
	public PageResult findPage(TbBrand brand, int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);//分页
		
		TbBrandExample exampl =new TbBrandExample();
		Criteria criteria = exampl.createCriteria();
		
		if(brand != null){
			if (brand.getName()!=null && brand.getName().length()>0) {
				criteria.andNameLike("%"+brand.getName()+"%");
			}
			if(brand.getFirstChar()!=null && brand.getFirstChar().length()>0) {
				criteria.andFirstCharEqualTo(brand.getFirstChar());
			}
		}
		Page<TbBrand> page = (Page<TbBrand>) brandMapper.selectByExample(exampl);
		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		
		return brandMapper.selectOptionList();
	}
	
	
	

}
