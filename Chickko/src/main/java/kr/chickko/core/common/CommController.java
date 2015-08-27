package kr.chickko.core.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import kr.chickko.core.db.CommDao;

public class CommController {
	
	@Autowired
	protected CommDao CommDao;
	@Autowired
	protected ApplicationContext appContext;
}
