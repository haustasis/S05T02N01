package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.exceptions.PlayersException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {

	@Value("${app.jwt-secret}")
	private String jwtSecret;
	@Value("${app.jwt-expiration-milliseconds}")
	private int jwtExpirationInMs;

	// generate token
	public String generateToken(Authentication authentication) {
		String username = authentication.getName();
		Date currentDate = new Date();
		Date expireDate = new Date(currentDate.getTime() + jwtExpirationInMs);

		String token = Jwts.builder().setSubject(username).setIssuedAt(new Date()).setExpiration(expireDate)
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		return token;
	}

	public String getUsernameFromJWT(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}

	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) {
			throw new PlayersException(HttpStatus.BAD_REQUEST, "JWT firma no valida.");
		} catch (MalformedJwtException ex) {
			throw new PlayersException(HttpStatus.BAD_REQUEST, "JWT token no valido.");
		} catch (ExpiredJwtException ex) {
			throw new PlayersException(HttpStatus.BAD_REQUEST, "JWT token expirado.");
		} catch (UnsupportedJwtException ex) {
			throw new PlayersException(HttpStatus.BAD_REQUEST, "JWT token no soportado.");
		} catch (IllegalArgumentException ex) {
			throw new PlayersException(HttpStatus.BAD_REQUEST, "JWT esta vacio.");
		}
	}

}
