package app.sample.styledotmesample.model;

import java.util.Objects;

public class Member {

    private String name;
    private String role;
    private String profilePhotoUrl;
    private Integer tasks;
    private Integer progress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public Integer getTasks() {
        return tasks;
    }

    public void setTasks(Integer tasks) {
        this.tasks = tasks;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", profilePhotoUrl='" + profilePhotoUrl + '\'' +
                ", tasks=" + tasks +
                ", progress=" + progress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(name, member.name) &&
                Objects.equals(role, member.role) &&
                Objects.equals(profilePhotoUrl, member.profilePhotoUrl) &&
                Objects.equals(tasks, member.tasks) &&
                Objects.equals(progress, member.progress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role, profilePhotoUrl, tasks, progress);
    }
}
