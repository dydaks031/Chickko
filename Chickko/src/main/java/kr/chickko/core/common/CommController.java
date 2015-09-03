package kr.chickko.core.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import kr.chickko.core.db.CommDao;

public class CommController {
	
	@Autowired
	protected CommDao CommDao;
	@Autowired
	protected ApplicationContext appContext;
	
	protected Map<String, Object> reqBodyMap;               //request json body map
	protected Map<String, Object> reqHeadMap;               //request json head map
	
	
	public void init(HttpServletRequest req){         
		reqBodyMap = (Map<String,Object>)req.getAttribute("body");      //request json중 body map
		reqHeadMap = (Map<String,Object>)req.getAttribute("header");      //request json중 head map
		reqHeadMap.put("resultCode", 1);
		reqHeadMap.put("resultMsg", "");
	}
	
	public String getParmString(String key){                         
	      return getParmString(key, "");
	   }
	   
	   /**
	    * input parameter중 key에 해당하는 parameter를 return 하고 
	    * key에 해당하는 parameter의 값이 없을경우 기본값으로 입력받은 defaultValue를 return
	    * @param key
	    * @param defaultValue
	    * @return
	    */
	public String getParmString(String key, String defaultValue){
		String s = MapUtils.getString(reqBodyMap, key, defaultValue);
		if(StringUtils.isEmpty(s)){
			s = defaultValue;
		}
		return s;
	}
	   
}
