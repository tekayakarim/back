package com.pfe.main.controller;

import java.util.HashSet;




import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.main.entity.JwtRole;
import com.pfe.main.entity.JwtUser;
import com.pfe.main.model.JwtERole;
import com.pfe.main.model.JwtResponse;
import com.pfe.main.model.JwtUserDetails;
import com.pfe.main.model.LoginRequest;
import com.pfe.main.model.MessageResponse;
import com.pfe.main.model.SignupRequest;
import com.pfe.main.repository.JwtRoleRepository;
import com.pfe.main.repository.JwtUserRepository;
import com.pfe.main.security.JwtUtils;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	JwtUserRepository userRepository;

	@Autowired
	JwtRoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUseNname(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		JwtUserDetails userDetails = (JwtUserDetails) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUserName(signUpRequest.getUserName())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		JwtUser user = new JwtUser(signUpRequest.getUserName(), 
							 signUpRequest.getCin(),
							 encoder.encode(signUpRequest.getPassword()));

		Set<String> strRoles = signUpRequest.getRole();
		Set<JwtRole> roles = new HashSet<>();

		if (strRoles == null) {
			JwtRole employeRole = roleRepository.findByName(JwtERole.ROLE_EMPLOYE)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(employeRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "chefpark":
					JwtRole chefparkRole = roleRepository.findByName(JwtERole.ROLE_CHEFPARK)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefparkRole);

					break;
				case "chefhierarchique":
					JwtRole chefhierarchiqueRole = roleRepository.findByName(JwtERole.ROLE_CHEFHIERARCHIQUE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(chefhierarchiqueRole);

					break;
				case "agentDAAF":
					JwtRole agentDAAFRole = roleRepository.findByName(JwtERole.ROLE_AGENTDAAF)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(agentDAAFRole);

					break;
				case "admin":
					JwtRole adminRole = roleRepository.findByName(JwtERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				default:
					JwtRole employeRole = roleRepository.findByName(JwtERole.ROLE_EMPLOYE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(employeRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
