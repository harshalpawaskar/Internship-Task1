package com.example.task1.Model;

import java.util.ArrayList;
import java.util.List;

public class PhotosData {
    private int page;
    private int pages;
    private int perpage;
    private int total;
    private List<PhotoDetails> photo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PhotoDetails> getPhotoDetails() {
        return photo;
    }

    public void setPhotoDetails(List<PhotoDetails> photo) {
        this.photo = photo;
    }
}
