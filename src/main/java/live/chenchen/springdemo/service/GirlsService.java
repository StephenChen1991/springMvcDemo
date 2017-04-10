package live.chenchen.springdemo.service;

import java.awt.print.Pageable;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import live.chenchen.springdemo.dao.GirlMapper;
import live.chenchen.springdemo.pojo.Girl;
import live.chenchen.springdemo.utils.BeanUtil;
import live.chenchen.springdemo.utils.PagedResult;

@Service
@Transactional
public class GirlsService {

	@Resource
	private GirlMapper girlsMapper;
	/**
	 * query all name
	 * @return
	 */
	public List<Girl> getAll() {

		List<Girl> girls = girlsMapper.getAll();
		return girls;
	}
	public PagedResult<Girl> getAllByPage(Integer pageNumber, Integer pageSize) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNumber, pageSize);
		List<Girl> girls = girlsMapper.getAll();
		return BeanUtil.toPagedResult(girls);
	}
	public int insert(Girl g) {
		// TODO Auto-generated method stub
		int i = girlsMapper.insert(g);
		return i;
	}
	public int del(String id) {
		int i = 0;
		if(id != null && id != "") {
			Integer sid = Integer.valueOf(id);
			i = girlsMapper.deleteByPrimaryKey(sid);
		}
		return i;
	}
	
	/**
	 * 更新操作to
	 * 回显示
	 */
	public Girl toUpdateByid(String id) { 
		 
		Girl girl = new Girl();
		if (id!=null&&id!="") {
			Integer sid = Integer.valueOf(id);
			  girl = girlsMapper.toUpdateByid(sid);
			   
		}
		return girl;
	}
	
	/**
	 * 更新操作 do
	 * 回显示
	 */
	public int doUpdateByid(Girl g) { 

		int i  = girlsMapper.doUpdateByid(g);
		
		return i;
	}

}
