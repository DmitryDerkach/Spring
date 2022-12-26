package spring.service;

import java.util.Optional;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.database.entity.Company;
import spring.database.repository.CompanyRepository;
import spring.dto.CompanyReadDto;
import spring.listener.entity.AccessType;
import spring.listener.entity.EntityEvent;

@Service
@RequiredArgsConstructor
public class CompanyService {

    //private final CrudRepository<Integer, Company> companyRepository;
	private final CompanyRepository companyRepository;
    private final UserService userService;
    private final ApplicationEventPublisher eventPublisher;

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
            .map(entity -> {
                eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                return new CompanyReadDto(entity.getId());
            });
    }
}
