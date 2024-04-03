package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@Builder
@EqualsAndHashCode(exclude = "id")
@ToString
public class ProjectBuilder {
    private int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private int projectType;
    private boolean isEnableTCApprovals;
    private String test;
}
