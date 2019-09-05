package reqres.api.models.usersModels.listOfUsersResponseModel;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class ListOfUsersResponseModel {

	@JsonProperty("per_page")
	private int perPage;

	@JsonProperty("total")
	private int total;

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("page")
	private int page;

	@JsonProperty("total_pages")
	private int totalPages;
}