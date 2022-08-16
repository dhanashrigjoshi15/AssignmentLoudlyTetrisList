package com.assignmentloudlytetrislist;

public class RepositoryData {

    private long id;
    private String repoName;
    private long repoLoginName;
    private long repoSize;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public long getRepoLoginName() {
        return repoLoginName;
    }

    public void setRepoLoginName(long repoLoginName) {
        this.repoLoginName = repoLoginName;
    }

    public long getRepoSize() {
        return repoSize;
    }

    public void setRepoSize(long repoSize) {
        this.repoSize = repoSize;
    }
}
