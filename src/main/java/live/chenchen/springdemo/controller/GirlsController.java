package live.chenchen.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import live.chenchen.springdemo.pojo.Girl;
import live.chenchen.springdemo.pojo.Pie;
import live.chenchen.springdemo.service.GirlsService;
import live.chenchen.springdemo.utils.PagedResult;

@Controller
public class GirlsController {

	@Autowired
	private GirlsService girlsService;
	/**
	 * chaxun
	 */	
	@RequestMapping(value="getAllOne.do", produces="application/json; charset=utf-8")
	public ModelAndView getAllOne(HttpServletRequest request, Model model){
		ModelAndView modelAndView = new ModelAndView();
		List<Girl> findAllList = girlsService.getAll();
		modelAndView.addObject("findAllList", findAllList);
		modelAndView.setViewName("list");
		model.addAttribute("findAllList", findAllList);
		return modelAndView;
	}
	
	/**
	 * 
	 */
	@RequestMapping(value="getAllByPage.do")
	public String getAllByPage(@RequestParam(value="pageNumber", required=false, defaultValue="1")Integer pageNumber, 
			@RequestParam(value="pageSize", required=false, defaultValue="5")Integer pageSize, Model model){
		
		ModelAndView mav = new ModelAndView();
		PagedResult<Girl> pagedResult = girlsService.getAllByPage(pageNumber, pageSize);
		//mav.addObject("pagedResult", pagedResult);
		model.addAttribute("pagedResult", pagedResult);
		mav.setViewName("listByPage");
		
		return "listByPage";
	}
	
	/**
	 * 
	 */
	@RequestMapping(value="insert.do")
	@ResponseBody
	public String insert(HttpServletRequest request, Girl g){
		String name = (String) request.getAttribute("name");
		int i = girlsService.insert(g);
		if(i > 0){
			return "OK";
		}else{
			return "NG";
		}
	}
	
	@RequestMapping(value="del.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String del(String id) {
		int i = girlsService.del(id);
		if(i>0) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	/**
	 * 更新操作
	 * 回显示
	 */
	@RequestMapping(value="toUpdateByid.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public ModelAndView toUpdateByid(String id) {
		ModelAndView mv = new ModelAndView();
	    Girl girls = girlsService.toUpdateByid(id);
	    mv.addObject("girls", girls);
		mv.setViewName("toupdate");
		return mv; 
		
	}
	
	/**
	 * 更新操作
	 */
	@RequestMapping(value="doUpdateByid.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String doUpdateByid(Girl g) {
		
		int i = girlsService.doUpdateByid(g);
		if(i>0) {
			return "yes";
		} else {
			return "no";
		}
	}
	
	/*
	 * 玫瑰图
	 */
	@RequestMapping("getAllByPie.do")
	@ResponseBody
	public String getAllByPie() {
		List<Girl> glist = girlsService.getAll();
		List<Pie> plist = new ArrayList<Pie>();
		for (Girl girls : glist) {
			Pie pie = new Pie();
			pie.setValue(girls.getAge().toString());
			pie.setName(girls.getName());
			plist.add(pie);
		}
		Gson gson = new Gson();
		String json = gson.toJson(plist);
		return json;
	}
	
	/**
	 *  json
	 */
	@RequestMapping(value="getAllTwo.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public String getAllTwo(HttpServletRequest resquest) {		
		List<Girl> findAllList =  girlsService.getAll();
		Gson gson = new Gson();
		String json = gson.toJson(findAllList);
		return json;	
	}
}
