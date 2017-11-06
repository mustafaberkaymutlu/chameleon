package net.epictimes.chameleon.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetPhotosResponse {

    @SerializedName("current_page")
    private Integer currentPage;

    @SerializedName("total_pages")
    private Integer totalPages;

    @SerializedName("total_items")
    private Integer totalItems;

    @SerializedName("photos")
    private List<Photo> photos = null;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

}
