package cat.itacademy.barcelonactiva.ariso.demo.s05.t02.n01.model.dto;

public class JWTAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";

	public JWTAuthResponse(String accessToken) {
		super();
		this.accessToken = accessToken;
	}

	public JWTAuthResponse(String accessToken, String tokenType) {
		super();
		this.accessToken = accessToken;
		this.tokenType = tokenType;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

}
