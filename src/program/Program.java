package program;

import dao.CategoryDAO;
import dao.CategoryDAOImpl;
import entity.Category;

import javax.security.sasl.SaslClient;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        CategoryDAO categoryDAO = new CategoryDAOImpl();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("=====QUAN LY DANH MUC=====");
            System.out.println("1. Danh sach danh muc");
            System.out.println("2. Them moi danh muc");
            System.out.println("3. Sua danh muc");
            System.out.println("4. Xoa danh muc");
            System.out.println("5. Tim kiem");
            System.out.println("6. Thoat");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    List<Category> categories = categoryDAO.getAllCategory();
                    for (Category category : categories){
                        System.out.println(category.toString());
                    }
                    break;
                case 2:
                    Category category = new Category();
                    System.out.println("Nhap thong tin danh muc");
                    category.inputData(scanner);
                    if(categoryDAO.addCagegory(category)){
                        System.out.println("Them moi thanh cong");
                    } else {
                        System.out.println("Loi, vui long nhap lao");
                    }
                    break;
                case 3:
                    System.out.println("Moi ban nhap vao id can sua");
                    int id = Integer.parseInt(scanner.nextLine());
                    Category categoryEdit = categoryDAO.findByID(id);
                    if (categoryEdit == null){
                        System.err.println("Rat tiec khong tim thay danh muc nao co id = " + id);
                    } else {
                        System.out.println("Co phai ban muon thay doi thong tin cua danh muc nay:");
                        System.out.println(categoryEdit.toString());
                        System.out.println("Nhap thong tin moi");
                        System.out.println("Nhap ten danh muc moi");
                        categoryEdit.setCategoryName(scanner.nextLine());
                        System.out.println("Nhap ten trang thai danh muc moi");
                        categoryEdit.setCategoryStatus(Boolean.parseBoolean(scanner.nextLine()));
                        if (categoryDAO.updateCategory(categoryEdit)){
                            System.out.println("Cap nhat thanh cong");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Moi ban nhap ma muon xoa");
                    int idDelete = Integer.parseInt(scanner.nextLine());
                    if (categoryDAO.findByID(idDelete) != null){
                        categoryDAO.deleteCategory(idDelete);
                    } else {
                        System.err.println("Khong tim co danh muc nao co id = " + idDelete);
                    }
                    break;
                case 5:
                    System.out.println("Moi ban nhap vao tu khoa muon tim kiem");
                    String keyWord = scanner.nextLine();
                    List<Category> list = categoryDAO.searchByName(keyWord);
                    int count = 0;
                    for (Category category1 : list){
                        System.out.println(category1.toString());
                        count++;
                    }
                    if (count == 0){
                        System.err.println("Khong tim thay ket qua nao voi tu khoa: " + keyWord);
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Moi chon lai");
            }
        } while (true);
    }
}
