package spring.integration.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.TestConstructor.AutowireMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.RequiredArgsConstructor;
import spring.ApplicationRunner;
import spring.configuration.DatabaseProperties;
import spring.database.entity.Company;
import spring.dto.CompanyReadDto;
import spring.integration.annotattion.IT;
import spring.listener.entity.EntityEvent;
import spring.service.CompanyService;

@IT
@RequiredArgsConstructor
public class CompanyServiceIT {

	private static final Integer COMPANY_ID = 1;

	private final CompanyService companyService;
	
	private final DatabaseProperties databaseProperties;
	
	@Test
	void findById() {
		
		var actualResult = companyService.findById(COMPANY_ID);

		assertTrue(actualResult.isPresent());

		var expectedResult = new CompanyReadDto(COMPANY_ID);
		actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

	}
}
