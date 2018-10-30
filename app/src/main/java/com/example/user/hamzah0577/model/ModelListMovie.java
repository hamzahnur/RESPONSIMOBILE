
package com.example.user.hamzah0577.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.user.hamzah0577.DataMovie;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ModelListMovie implements Parcelable
{

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private ArrayList<DataMovie> results = null;
    public final static Parcelable.Creator<ModelListMovie> CREATOR = new Creator<ModelListMovie>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ModelListMovie createFromParcel(Parcel in) {
            return new ModelListMovie(in);
        }

        public ModelListMovie[] newArray(int size) {
            return (new ModelListMovie[size]);
        }

    }
    ;

    protected ModelListMovie(Parcel in) {
        this.page = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalResults = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalPages = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.results, (com.example.user.hamzah0577.DataMovie.class.getClassLoader()));
    }

    public ModelListMovie() {
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public ArrayList<DataMovie> getResults() {
        return results;
    }

    public void setResults(ArrayList<DataMovie> results) {
        this.results = results;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(page);
        dest.writeValue(totalResults);
        dest.writeValue(totalPages);
        dest.writeList(results);
    }

    public int describeContents() {
        return  0;
    }

}
