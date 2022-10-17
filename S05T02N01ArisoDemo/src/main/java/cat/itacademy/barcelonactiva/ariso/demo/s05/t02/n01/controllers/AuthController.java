package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.controllers;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.Role;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.domain.User;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.JWTAuthResponse;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.LoginDto;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto.SignUpDto;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.RoleRepository;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.repository.UserRepository;
import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.security.JwtTokenProvider;

@RestController
@RequestMapping("/players/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@PostMapping("/signin")
	public ResponseEntity<JWTAuthResponse> authenticateUser(@RequestBody LoginDto loginDto) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginDto.getUsernameOrEmail(), loginDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String token = tokenProvider.generateToken(authentication);

		return ResponseEntity.ok(new JWTAuthResponse(token));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) {

		if (userRepository.existsByUsername(signUpDto.getUsername())) {
			return new ResponseEntity<>("EL usuario ya existe.", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpDto.getEmail())) {
			return new ResponseEntity<>("El email ya existe.", HttpStatus.BAD_REQUEST);
		}

		User user = new User();
		user.setName(signUpDto.getName());
		user.setUsername(signUpDto.getUsername());
		user.setEmail(signUpDto.getUsername());
		user.setEmail(signUpDto.getEmail());
		user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

		Role roles = roleRepository.findByName("ROLE_ADMIN").get();
		user.setRoles(Collections.singleton(roles));

		userRepository.save(user);

		return new ResponseEntity<>("Usuario registrado con exito.", HttpStatus.OK);

	}
}
