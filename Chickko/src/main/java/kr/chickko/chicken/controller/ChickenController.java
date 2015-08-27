package kr.chickko.chicken.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.chickko.ChickkoApplication;
import kr.chickko.collection.SexyMap;
import kr.chickko.core.common.CommController;
import kr.chickko.util.LOG;
import kr.chickko.util.ZIPPER;
import kr.chickko.util.JSON;

@RestController
@RequestMapping("/chicken")
public class ChickenController extends CommController {
	
	public static void main(String[] args) {
        SpringApplication.run(ChickkoApplication.class, args);
    }
	@RequestMapping("/getInfo")
	public String index() throws IOException, Exception{
		LOG.info("url : /chicken/getInfo");
//		SexyMap a = CommDao.select("sample.getUserMap");
		List<SexyMap> b = CommDao.selectList("chicken.getChickenInfoAll");
//		System.out.println(a);
//		System.out.println(ZIPPER.zip(JSON.toJson(b)));
		System.out.println(JSON.toJson(b));
		return JSON.toJson(JSON.toJson(b));
	}
}