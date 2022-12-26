package spring.integration.database.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.RequiredArgsConstructor;
import spring.database.entity.Company;
import spring.database.repository.CompanyRepository;
import spring.integration.annotattion.IT;

@IT
@RequiredArgsConstructor
@Commit
class CompanyRepositoryIT {

	private final EntityManager entityManager;
	private final TransactionTemplate transactionTemplate;
	
	private final CompanyRepository companyRepository;
	private static final Integer APPLE_ID = 7;
	
	@Test
	void delete() {
		Optional<Company> maybeCompany = companyRepository.findById(APPLE_ID);
		assertTrue(maybeCompany.isPresent());
		maybeCompany.ifPresent(company -> companyRepository.delete(company));
		//Не забываем сделать flush(), потому что, по-умолчанию метод delete() не вызовется
		//пока у нас не произойдет "коммит" транзакции, либо мы не вызовем flush() явно
		entityManager.flush();
		assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
	}
	
	@Test
	void checkFindByQueries() {
		companyRepository.findByName("google");
		companyRepository.findAllByNameContainingIgnoreCase("a");
	}
	
	@Test
	void findById() {
		transactionTemplate.executeWithoutResult(tx -> {
			Company company = entityManager.find(Company.class, 1);
			assertNotNull(company);
			Assertions.assertThat(company.getLocales()).hasSize(2);
		});
	}
	
    @Test
    void save() {
        var company = Company.builder()
            .name("Apple")
            .locales(Map.of(
                "ru", "Apple описание",
                "en", "Apple description"
            ))
            .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

}
