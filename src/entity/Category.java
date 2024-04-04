package entity;

import java.util.Scanner;

public class Category {
    private int categoryId;
    private String categoryName;
    private Boolean categoryStatus;

    public Category() {
    }

    public Category(int categoryId, String categoryName, Boolean categoryStatus) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryStatus = categoryStatus;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Boolean getCategoryStatus() {
        return categoryStatus;
    }

    public void setCategoryStatus(Boolean categoryStatus) {
        this.categoryStatus = categoryStatus;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryStatus=" + categoryStatus +
                '}';
    }

    public void inputData(Scanner scanner){
        System.out.println("Nhap vao ten danh muc");
        categoryName = scanner.nextLine();
        System.out.println("Nhap vao trang thai: true/false");
        categoryStatus = Boolean.parseBoolean(scanner.nextLine());
    }
}
