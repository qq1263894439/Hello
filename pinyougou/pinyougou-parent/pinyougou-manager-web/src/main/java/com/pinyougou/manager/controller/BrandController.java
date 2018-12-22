package com.pinyougou.manager.controller;


import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;

import entity.PageResult;
import entity.Result;




@RestController //相当于ResponseBody和Controller
@RequestMapping("/brand")
public class BrandController {

	@Reference //阿里巴巴包下面的远程注入
	private BrandService brandService;
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbBrand> findAll(){
		return brandService.findAll();
	}
	
	/**
	 * 分页
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult findPage(int page, int size) {
		return	brandService.findPage(page, size);
	}
	
	/**
	 * 增加
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbBrand brand) {
		
		try {
			brandService.add(brand);
			return new Result(true, "添加成功");
		} catch (Exception e) {
			
			e.printStackTrace();
			return new Result(false, "添加失败");
		}	
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbBrand brand) {
		
		try {
			brandService.update(brand);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	/**
	 * 获取实体ID
	 */
	@RequestMapping("/findOne")
	public TbBrand findOne(Long id) {
		return brandService.findOne(id);
	}
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	public Result delete(Long [] ids) {
		try {
			brandService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param size
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbBrand brand, int page , int size) {
		
		return brandService.findPage(brand, page, size);
		
	}
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
	return	brandService.selectOptionList();
	}
	
}
