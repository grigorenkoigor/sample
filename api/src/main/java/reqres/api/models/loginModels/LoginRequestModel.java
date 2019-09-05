package reqres.api.models.loginModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class LoginRequestModel{

	@JsonProperty("password")
	private String password;

	@JsonProperty("email")
	private String email;
}