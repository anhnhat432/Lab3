package doctor;

import Entity.Doctor;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ValidateTest {
    
    public ValidateTest() {
    }

    @Test
    public void testCheckInputIntLimit() {
        // Giả lập đầu vào và kiểm tra đầu ra
        // Cần sử dụng System.setIn để giả lập đầu vào từ Scanner
        // Ví dụ: assertEquals(5, Validate.checkInputIntLimit(1, 10));
    }

    @Test
    public void testCheckInputString() {
        // Giả lập đầu vào và kiểm tra đầu ra
        // Ví dụ: assertEquals("test", Validate.checkInputString(10));
    }

    @Test
    public void testCheckInputYN() {
        // Giả lập đầu vào cho "Y" và kiểm tra
        boolean resultY = Validate.checkInputYN(1);
        assertTrue(resultY);

        // Giả lập đầu vào cho "N" và kiểm tra
        boolean resultN = Validate.checkInputYN(1);
        assertFalse(resultN);
    }

    @Test
    public void testCheckString() {
        // Giả lập đầu vào và kiểm tra đầu ra
        // Ví dụ: assertEquals("test", Validate.checkString());
    }

    @Test
    public void testCheckDateOfBirth() {
        // Giả lập đầu vào cho ngày tháng và kiểm tra
        String dob = Validate.checkDateOfBirth();
        assertNotNull(dob);
        // Kiểm tra định dạng và giá trị hợp lệ
    }

    @Test
    public void testCheckEmail() {
        // Giả lập đầu vào cho email hợp lệ và không hợp lệ
        String validEmail = Validate.checkEmail();
        assertTrue(validEmail.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)+$"));

        String invalidEmail = Validate.checkEmail();
        assertFalse(invalidEmail.matches("^[\\w-\\.]+@[\\w-]+(\\.[\\w-]+)+$"));
    }

    @Test
    public void testCheckMobile() {
        // Giả lập đầu vào cho số di động hợp lệ và không hợp lệ
        String validMobile = Validate.checkMobile();
        assertTrue(validMobile.matches("^\\(\\d{3}\\)-\\d{3}-\\d{4}$"));

        String invalidMobile = Validate.checkMobile();
        assertFalse(invalidMobile.matches("^\\(\\d{3}\\)-\\d{3}-\\d{4}$"));
    }

    @Test
    public void testCheckCodeExist() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1, "John Doe", "01/01/1980", "Cardiology", 1, "john@example.com", "(123)-456-7890"));
        
        assertFalse(Validate.checkCodeExist(doctors, 1)); // ID tồn tại
        assertTrue(Validate.checkCodeExist(doctors, 2)); // ID không tồn tại
    }

    @Test
    public void testCheckDuplicate() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor(1, "John Doe", "01/01/1980", "Cardiology", 1, "john@example.com", "(123)-456-7890"));
        
        assertFalse(Validate.checkDuplicate(doctors, 1, "John Doe", "01/01/1980", "Cardiology", 1, "john@example.com", "(123)-456-7890")); // Trùng lặp
        assertTrue(Validate.checkDuplicate(doctors, 2, "Jane Doe", "02/02/1990", "Neurology", 2, "jane@example.com", "(321)-654-0987")); // Không trùng lặp
    }

    @Test
    public void testCheckChangeInfo() {
        Doctor doctor = new Doctor(1, "John Doe", "01/01/1980", "Cardiology", 1, "john@example.com", "(123)-456-7890");
        
        assertFalse(Validate.checkChangeInfo(doctor, 1, "John Doe", "01/01/1980", "Cardiology", 1, "john@example.com", "(123)-456-7890")); // Không thay đổi
        assertTrue(Validate.checkChangeInfo(doctor, 1, "Jane Doe", "02/02/1990", "Neurology", 2, "jane@example.com", "(321)-654-0987")); // Thay đổi
    }
}
