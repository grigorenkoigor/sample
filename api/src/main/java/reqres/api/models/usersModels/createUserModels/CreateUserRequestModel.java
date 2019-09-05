package reqres.api.models.usersModels.createUserModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class CreateUserRequestModel{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;
}