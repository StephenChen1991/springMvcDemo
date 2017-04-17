package live.chenchen.springdemo.test;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.csair.newparse.AcarsFileClient;
import com.csair.soc.disp.monitor.data.constants.EsbConst;

import live.chenchen.springdemo.pojo.AcarsVo;
import com.csair.soc.disp.monitor.data.entity.AcarsVoOld;

import live.chenchen.springdemo.service.AcarsService;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})  

public class TestAcarsProcessor {
	
	private static Logger logger = Logger.getLogger(TestAcarsProcessor.class);  

    @Resource  
    private AcarsService acarsService = null;  
    
    @Test  
    public void test1() {  
		System.setProperty("file.encoding", "utf-8");
		BasicConfigurator.configure();
		AcarsFileClient afc = new AcarsFileClient();
		File[] acarsFiles = afc.readAcarsFile("D://tmp//ACARS-Parser-master//ACARS-All");
		List<AcarsVoOld> newAcarsVoList =  afc.acarsParse(acarsFiles);
		for(AcarsVoOld vo : newAcarsVoList){ 
			String s = UUID.randomUUID().toString();
			AcarsVo ac = new AcarsVo();
			ac.setId(s);
			ac.setArvarpcd(vo.getArvArpCd());
			ac.setCuralt(vo.getCurAlt());
			ac.setCurcas(vo.getCurCas());
			ac.setCurfob(vo.getCurFob());
			ac.setCurgw(vo.getCurGw());
			ac.setCurlat(vo.getCurLat());
			ac.setCurlon(vo.getCurLon());
			ac.setCurff(vo.getCurFf());
			ac.setCurmach(vo.getCurMach());
			ac.setCurmh(vo.getCurMh());
			ac.setCurtemp(vo.getCurTemp());
			ac.setCurwd(vo.getCurWd());
			ac.setCurws(vo.getCurWs());
			ac.setCurzfw(vo.getCurZfw());
			ac.setDeparpcd(vo.getDepArpCd());
			ac.setDirection(vo.getDirection());
			ac.setDspdt(vo.getDspDt());
			ac.setEstdis(vo.getEstDis());
			ac.setEstfob(vo.getEstFob());
			ac.setEsttime(vo.getEstTime());
			ac.setFltnr(vo.getFltNr());
			ac.setFltsuffix(vo.getFltSuffix());
			ac.setLastarinc(vo.getLastArinc());
			ac.setNextfuel(vo.getNextFuel());
			ac.setNexttime(vo.getNextTime());
			ac.setNextwp(vo.getNextWp());
			ac.setTailnr(vo.getTailNr());
			ac.setTelexdt(vo.getTelexDt());
			//ac.setTelexmsg(vo.getTelexMsg());
			ac.setType(vo.getType());
			int i  = acarsService.insert(ac);  	
		}
    }
}
