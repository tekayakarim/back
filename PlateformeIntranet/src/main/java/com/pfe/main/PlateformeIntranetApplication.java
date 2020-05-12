package com.pfe.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.pfe.main.entity.JwtRole;
import com.pfe.main.model.JwtERole;
import com.pfe.main.repository.JwtRoleRepository;

@SpringBootApplication(exclude = { org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class PlateformeIntranetApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateformeIntranetApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(JwtRoleRepository jwtRoleRepository) {

		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				if(jwtRoleRepository.findAll().size()==0)
				{
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_ADMIN));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_AGENTDAAF));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFDAAF));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFHIERARCHIQUE));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFPARK));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_EMPLOYE));
				}
			}
		};
	}

}
