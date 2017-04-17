package live.chenchen.springdemo.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import live.chenchen.springdemo.pojo.AcarsVo;

import live.chenchen.springdemo.dao.AcarsVoMapper;

@Service
@Transactional
public class AcarsService {
	
	@Resource
	private AcarsVoMapper acarsVoMapper;
	
	public int insert(AcarsVo g) {
		// TODO Auto-generated method stub
		int i = acarsVoMapper.insert(g);
		return i;
	}
	
	public int del(String id) {
		int i = 0;
		if(id != null && id != "") {
			i = acarsVoMapper.deleteByPrimaryKey(id);
		}
		return i;
	}
	

}
