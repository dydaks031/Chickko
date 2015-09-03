package kr.chickko.login.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.chickko.ChickkoApplication;
import kr.chickko.collection.SexyMap;
import kr.chickko.core.common.CommController;
import kr.chickko.core.common.PackingManager;
import kr.chickko.util.TokenGenerator;
import kr.chickko.util.ZIPPER;
import kr.chickko.util.JSON;

@RestController
@RequestMapping("/login")
public class LoginController extends CommController {
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	public static void main(String[] args) {
        SpringApplication.run(ChickkoApplication.class, args);
    }
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(@RequestParam("param") String param) throws IOException, Exception{
		PackingManager pm = new PackingManager();
		pm.unpack(param);
		logger.info("/login/login.do  param => " + param);
		SexyMap requestParam = new SexyMap(JSON.fromJson(param, SexyMap.class));
		
		String sId = "dydaks031@gmail.com";
		String sPwd = "gusdn123#";
		
		
		
		TokenGenerator tg = new TokenGenerator();
		System.out.println(tg.getToken());
		return JSON.toJson(tg.getToken());
	}
}