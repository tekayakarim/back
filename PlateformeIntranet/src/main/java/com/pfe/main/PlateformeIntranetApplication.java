package com.pfe.main;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.pfe.main.entity.JwtRole;
import com.pfe.main.entity.JwtUser;
import com.pfe.main.model.JwtERole;
import com.pfe.main.repository.JwtRoleRepository;
import com.pfe.main.repository.JwtUserRepository;

@SpringBootApplication(exclude = { org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class PlateformeIntranetApplication {
	
	@Autowired
	JwtUserRepository jwtUserRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtRoleRepository jwtRoleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PlateformeIntranetApplication.class, args);
	}
	@Bean
	public CommandLineRunner init(JwtRoleRepository jwtRoleRepository) {

		return new CommandLineRunner() {
			public void run(String... strings) throws Exception {
				
				if(jwtRoleRepository.findAll().size() == 0)
				{
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_AGENTDAAF));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFDAAF));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFHIERARCHIQUE));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_CHEFPARK));
					jwtRoleRepository.save(new JwtRole(JwtERole.ROLE_EMPLOYE));
						
				
				}
				if(jwtUserRepository.findAll().size()==0)
				{
					Set<JwtRole> roles = new HashSet<JwtRole>();
					JwtRole adminRole = new JwtRole(JwtERole.ROLE_ADMIN);
					roles.add(adminRole);

					JwtUser user=new JwtUser();
					
					user.setUserName("admin");
					user.setCin("admin");
					user.setNom("admin");
					user.setPrenom("admin");
					user.setPassword(
					 encoder.encode("admin"));
					user.setRoles(roles);
					user.setEmail("abdelkarimbentekaya@gmail.com");
					jwtUserRepository.save(user);
				}

				
				
			}
		};
	}


}
