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
	
	@RequestMapping(value="getAllTwo.do", produces="application/json; charset=utf-8")
	@ResponseBody
	public <Gson> String getAllTwo(HttpServletRequest request){
		
		List<Girl> findAllList = girlsService.getAll();
		Gson gson = new Gson();
		String json = gson.toJson(findAllList);
		return json;
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
		
}
