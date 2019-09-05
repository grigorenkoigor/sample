package reqres.api.models.usersModels.singleUserResponseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import reqres.api.models.usersModels.singleUserResponseModel.Data;

import javax.annotation.Generated;

@Getter
@Setter
@Accessors(chain = true)
public class SingleUserResponseModel{

	@JsonProperty("data")
	private Data data;
}