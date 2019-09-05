package reqres.api.models.usersModels.updateUserModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class UpdateUserRequestModel{

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;
}