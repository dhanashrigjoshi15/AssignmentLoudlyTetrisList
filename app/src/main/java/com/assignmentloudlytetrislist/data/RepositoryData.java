/* Data class to handle and display required data to list as
repository name, login name and size of repository*/

package com.assignmentloudlytetrislist.data;

import com.google.gson.annotations.SerializedName;

public class RepositoryData {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String repoName;

    @SerializedName("login")
    private String repoLoginName;

    @SerializedName("size")
    private int repoSize;

    @SerializedName("owner")
    private LoginOwner owner;

    @SerializedName("has_wiki")
    private boolean hasWiki;

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

    public String getRepoLoginName() {
        return repoLoginName;
    }

    public void setRepoLoginName(String repoLoginName) {
        this.repoLoginName = repoLoginName;
    }

    public int getRepoSize() {
        return repoSize;
    }

    public void setRepoSize(int repoSize) {
        this.repoSize = repoSize;
    }

    public LoginOwner getOwner() {
        return owner;
    }

    public void setOwner(LoginOwner owner) {
        this.owner = owner;
    }

    public boolean isHasWiki() {
        return hasWiki;
    }

    public void setHasWiki(boolean hasWiki) {
        this.hasWiki = hasWiki;
    }
}
