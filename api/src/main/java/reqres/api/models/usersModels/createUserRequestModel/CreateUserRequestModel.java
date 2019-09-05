package reqres.api.models.usersModels.createUserRequestModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class CreateUserRequestModel{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;
}