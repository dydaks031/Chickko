package kr.chickko.core.db;

import java.io.IOException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import kr.chickko.collection.SexyMap;

import java.util.List;
import java.util.Map;

@Configuration
@PropertySource("properties/databases.properties")
@MapperScan(
	basePackages = "min.seung.yu.core.db",
	annotationClass = Mapper.class 	
)
public class CommDao implements CommDaoFacade {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Value("${default.driver}") 	String driverClassName;
	@Value("${default.url}") 		String url;
	@Value("${default.username}") 	String username;
	@Value("${default.password}") 	String password;
	
	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }
	
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException{
		
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		
		factoryBean.setDataSource(dataSource());
		factoryBean.setConfigLocation( applicationContext.getResource("classpath:mybatis/configuration.xml") );
		factoryBean.setMapperLocations( applicationContext.getResources("classpath:mybatis/mapper/*.xml") );
		
		return factoryBean;
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws IOException, Exception{
		return new SqlSessionTemplate( sqlSessionFactoryBean().getObject() );
	}

	@Override
	public int selectInt(String namespace) throws IOException, Exception {
		return sqlSessionTemplate().selectOne(namespace);
	}
	@Override
	public int selectInt(String namespace, SexyMap params) throws IOException, Exception {
		return sqlSessionTemplate().selectOne(namespace, params);
	}
	
	@Override
	public String selectStr(String namespace) throws IOException, Exception {
		return sqlSessionTemplate().selectOne(namespace);
	}
	@Override
	public String selectStr(String namespace, SexyMap params) throws IOException, Exception {
		return sqlSessionTemplate().selectOne(namespace, params);
	}

	@Override
	public SexyMap select(String namespace) throws IOException, Exception {
		return new SexyMap( (Map)sqlSessionTemplate().selectOne(namespace) );
	}
	
	@Override
	public SexyMap select(String namespace, SexyMap params) throws IOException, Exception {
		return new SexyMap( (Map)sqlSessionTemplate().selectOne(namespace, params) );
	}
	
	@Override
	public List<SexyMap> selectList(String namespace) throws IOException, Exception {
		return sqlSessionTemplate().selectList(namespace);
	}
	
	@Override
	public List<SexyMap> selectList(String namespace, SexyMap params) throws IOException, Exception {
		return sqlSessionTemplate().selectList(namespace,params);
	}
}
