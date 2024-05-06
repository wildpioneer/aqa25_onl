package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Project {
    private String name;
    private String announcement;

    @SerializedName(value = "show_announcement")
    private boolean showAnnouncement;

    @SerializedName(value = "suite_mode")
    private int suiteMode;
}
