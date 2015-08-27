package kr.chickko.core.db;

import java.io.IOException;
import java.util.List;
import kr.chickko.collection.SexyMap;

public interface CommDaoFacade {
	public int				selectInt(String namespace) 					throws IOException, Exception;
	public int				selectInt(String namespace, SexyMap params) 	throws IOException, Exception;
	public String			selectStr(String namespace) 					throws IOException, Exception;
	public String			selectStr(String namespace, SexyMap params) 	throws IOException, Exception;
	public SexyMap			select(String namespace) 						throws IOException, Exception;
	public SexyMap			select(String namespace, SexyMap params) 		throws IOException, Exception;
	public List<SexyMap>	selectList(String namespace) 					throws IOException, Exception;
	public List<SexyMap>	selectList(String namespace, SexyMap params) 	throws IOException, Exception;
}
