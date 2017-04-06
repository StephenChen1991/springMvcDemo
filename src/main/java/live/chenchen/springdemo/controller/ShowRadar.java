//package live.chenchen.springdemo.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.ArrayList;  
//import java.util.List;  
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam; 
//import org.springframework.beans.factory.annotation.Autowired;  
//import org.springframework.stereotype.Service;  
//  
//import com.github.abel533.echarts.Option;  
//import com.github.abel533.echarts.Polar;  
//import com.github.abel533.echarts.code.Orient;  
//import com.github.abel533.echarts.code.Tool;  
//import com.github.abel533.echarts.code.Trigger;  
//import com.github.abel533.echarts.code.X;  
//import com.github.abel533.echarts.code.Y;  
//import com.github.abel533.echarts.data.Data;  
//import com.github.abel533.echarts.feature.DataView;  
//import com.github.abel533.echarts.feature.Mark;  
//import com.github.abel533.echarts.feature.Restore;  
//import com.github.abel533.echarts.feature.SaveAsImage;    
//
//public class ShowRadar {
//	
//    @RequestMapping("/showRadio")  
//    public ModelAndView showRadio(HttpServletRequest request)  
//    {  
//          
//      
//        List<AllocatedBudget> list = service.addInfo();  
//          
//          
//        String strContext =JSON.toJSONString(list);  
//        System.out.println(strContext);  
//          
//        request.setAttribute("strContext",strContext);  
//      
//          
//        return new ModelAndView("/radio1");  
//    }
//
//}
