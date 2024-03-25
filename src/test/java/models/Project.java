package models;

import java.util.Objects;

public class Project {
    private int id;
    private String name;
    private String announcement;
    private boolean isShowAnnouncement;
    private int projectType;
    private boolean isEnableTCApprovals;
    private boolean dasdas;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public boolean isShowAnnouncement() {
        return isShowAnnouncement;
    }

    public void setShowAnnouncement(boolean showAnnouncement) {
        isShowAnnouncement = showAnnouncement;
    }

    public int getProjectType() {
        return projectType;
    }

    public void setProjectType(int projectType) {
        this.projectType = projectType;
    }

    public boolean isEnableTCApprovals() {
        return isEnableTCApprovals;
    }

    public void setEnableTCApprovals(boolean enableTCApprovals) {
        isEnableTCApprovals = enableTCApprovals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return isShowAnnouncement == project.isShowAnnouncement && projectType == project.projectType && isEnableTCApprovals == project.isEnableTCApprovals && Objects.equals(name, project.name) && Objects.equals(announcement, project.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, announcement, isShowAnnouncement, projectType, isEnableTCApprovals);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", announcement='" + announcement + '\'' +
                ", isShowAnnouncement=" + isShowAnnouncement +
                ", projectType=" + projectType +
                ", isEnableTCApprovals=" + isEnableTCApprovals +
                '}';
    }
}
