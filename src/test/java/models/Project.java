package models;

import lombok.*;

@Data
@EqualsAndHashCode(exclude = "id")
public class Project {
    private int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private int projectType;
    private boolean isEnableTCApprovals;
}
