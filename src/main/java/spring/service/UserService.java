package spring.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import spring.database.repository.UserRepository;
import spring.database.repository.CompanyRepository;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    //private final CrudRepository<Integer, Company> companyRepository;
    private final CompanyRepository companyRepository;

}
