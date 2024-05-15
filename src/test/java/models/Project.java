package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {
    @EqualsAndHashCode.Exclude
    private int id;
    private String name;
    private String announcement;

    @SerializedName(value = "show_announcement")
    @JsonProperty("show_announcement")
    private boolean showAnnouncement;

    @SerializedName(value = "suite_mode")
    @JsonProperty("suite_mode")
    private int suiteMode;
}
