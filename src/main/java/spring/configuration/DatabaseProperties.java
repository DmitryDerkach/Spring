package spring.configuration;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@ConstructorBinding
@ConfigurationProperties(prefix = "db")
public class DatabaseProperties {

	String username;
	String password;
	String driver;
	String url;
	String hosts;
	PoolProperties pool;
	List<PoolProperties> pools;
	Map<String, Object> properties;
	
	@Value
	public static class PoolProperties {
		Integer size;
		Integer timeout;
	}
}
