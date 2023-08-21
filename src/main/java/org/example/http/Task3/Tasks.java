package org.example.http.Task3;

import java.util.Objects;

public class Tasks {
    private int userId;
    private int id;
    private String title;
    private boolean completed = true;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return userId == tasks.userId && id == tasks.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, id);
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

}
