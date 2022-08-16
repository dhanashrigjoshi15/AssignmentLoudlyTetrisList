//Data class to handle 1st or main JSON object response

package com.assignmentloudlytetrislist.data;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class APIResponse {
        @SerializedName("total_count")
        private long totalCount;

        @SerializedName("incomplete_results")
        private boolean incompleteResults;

        @SerializedName("items")
        private ArrayList<RepositoryData> repositoryDataList;

        public ArrayList<RepositoryData> getRepositoryDataList() {
                return repositoryDataList;
        }
}
