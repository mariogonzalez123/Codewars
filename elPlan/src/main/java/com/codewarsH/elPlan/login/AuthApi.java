package com.codewarsH.elPlan.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewarsH.elPlan.jwt.JwtTokenUtil;
import com.codewarsH.elPlan.model.User;
import com.codewarsH.elPlan.repositorio.UserRepository;


@RestController
public class AuthApi {
	@Autowired AuthenticationManager authManager;
	@Autowired JwtTokenUtil jwtUtil;
	@Autowired UserRepository userRepository;
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			
			User userFromDatabase = userRepository.findByUsername(request.getUsername());
			
			
//			String encodedPassword = new BCryptPasswordEncoder().encode(request.getPassword());
//			Authentication authentication = authManager.authenticate(
//					new UsernamePasswordAuthenticationToken(
//							request.getUsername(),encodedPassword)
//			);
//			
//			User user = (User) authentication.getPrincipal();
			if(new BCryptPasswordEncoder().matches(request.getPassword(), userFromDatabase.getPassword())){
				String accessToken = jwtUtil.generateAccessToken(userFromDatabase);
				AuthResponse response = new AuthResponse(userFromDatabase.getUsername(), accessToken);
				
				return ResponseEntity.ok().body(response);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}
			
			
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
}
