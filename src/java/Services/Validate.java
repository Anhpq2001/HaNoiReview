/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Models.User;
import Models.UserDAO;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author anhph
 */
public class Validate {

    UserDAO userDAO = new UserDAO();

    boolean isExist(String account) {
        User user = userDAO.getOneByAccount(account);
        if (Objects.isNull(user)) {
            return false;
        }
        return true;
    }

    boolean isNotPassword(String password) {
        boolean check = true;
        int length = password.length();
        if (length >= 8 && length <= 16) {
            check = false;
        }
        return check;
    }

    boolean isNotDuplicate(String password, String rePassword) {
        boolean check = false;
        if(!password.equals(rePassword)){
           check = true;
        }
        return check;
    }

    boolean isNotEmail(String email) {
        // Định dạng của địa chỉ email
        String emailRegex = "^[a-zA-Z][a-zA-Z0-9]+@[a-z]+(.[a-zA-Z]+){1,3}$";

        // Tạo pattern từ regex
        Pattern pattern = Pattern.compile(emailRegex);

        // Tạo matcher để so khớp chuỗi email với pattern
        Matcher matcher = pattern.matcher(email);

        // Trả về kết quả kiểm tra
        return matcher.matches();
    }
    
    public Date getCurrentDate() {
        // Lấy ngày tháng năm hiện tại
        LocalDate currentDate = LocalDate.now();

        // Chuyển đổi từ LocalDate sang Date
        Date date = java.sql.Date.valueOf(currentDate);

        // Trả về ngày tháng năm hiện tại dưới dạng Date
        return date;
    }
}
