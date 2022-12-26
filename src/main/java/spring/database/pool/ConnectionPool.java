package spring.database.pool;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//@RequiredArgsConstructor - не получается сделать через ломбок по какой-то причине
@Slf4j
@Component(value = "pool1")
public class ConnectionPool {
	
	//@Value("${db.username}")
	private final String username;
	//@Value("${db.pool.size}")
	private final Integer poolSize;
	
	public ConnectionPool(@Value("${db.username}") String username, @Value("${db.pool.size}") Integer poolSize) {
		super();
		this.username = username;
		this.poolSize = poolSize;
	}

	@PostConstruct
	public void init() {
		log.info("Init connection pool");
	}
	
	@PreDestroy
	private void destroy() {
		log.info("Clean connection pool");
	}

	@Override
	public String toString() {
		return "ConnectionPool [username=" + username + ", poolSize=" + poolSize + "]";
	}
	
}
