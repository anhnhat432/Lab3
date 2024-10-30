package doctor;
import Entity.Doctor;
import doctor.Manager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ManagerTest {

    private ArrayList<Doctor> doctors;

    @Before
    public void setUp() {
        // Tạo danh sách bác sĩ để sử dụng cho tất cả các bài test
        doctors = new ArrayList<>();
    }

    @Test
    public void testAddDoctor() {
        // Trước khi thêm, danh sách rỗng
        Assert.assertEquals(0, doctors.size());

        // Thêm bác sĩ
        Manager.addDoctor(doctors);

        // Sau khi thêm, danh sách có 1 bác sĩ
        Assert.assertEquals(1, doctors.size());
    }

    @Test
    public void testUpdateDoctor() {
        // Thêm một bác sĩ trước để cập nhật
        Doctor doctor = new Doctor(1, "Dr. John Doe", "15/05/1980", "Cardiology", 3, "john@example.com", "0123456789");
        doctors.add(doctor);

        // Cập nhật thông tin bác sĩ
        Manager.updateDoctor(doctors);

        // Giả định phương thức update thay đổi tên bác sĩ thành "Updated Doctor"
        Assert.assertEquals("Updated Doctor", doctors.get(0).getName());
    }

    @Test
    public void testDeleteDoctor() {
        // Thêm một bác sĩ trước để xóa
        Doctor doctor = new Doctor(1, "Dr. John Doe", "15/05/1980", "Cardiology", 3, "john@example.com", "0123456789");
        doctors.add(doctor);

        // Xóa bác sĩ khỏi danh sách
        Manager.deleteDoctor(doctors);

        // Kiểm tra danh sách sau khi xóa
        Assert.assertEquals(0, doctors.size());
    }

    @Test
    public void testSearchDoctorById() {
        // Thêm một bác sĩ để tìm kiếm
        Doctor doctor1 = new Doctor(1, "Dr. John Doe", "15/05/1980", "Cardiology", 3, "john@example.com", "0123456789");
        doctors.add(doctor1);

        // Tìm kiếm bác sĩ theo ID
        Doctor foundDoctor = Manager.getDoctorByCode(doctors, 1);

        // Kiểm tra xem bác sĩ tìm thấy có đúng ID không
        Assert.assertNotNull(foundDoctor);
        Assert.assertEquals(1, foundDoctor.getId());
    }

    @Test
    public void testSortDoctorByDateOfBirth() {
        // Thêm vài bác sĩ với ngày sinh khác nhau
        Doctor doctor1 = new Doctor(1, "Dr. John Doe", "15/05/1980", "Cardiology", 3, "john@example.com", "0123456789");
        Doctor doctor2 = new Doctor(2, "Dr. Jane Smith", "20/07/1990", "Neurology", 2, "jane@example.com", "0987654321");
        doctors.add(doctor2);
        doctors.add(doctor1);

        // Sắp xếp bác sĩ theo ngày sinh
        Manager.sortDoctorByDateOfBirth(doctors);

        // Kiểm tra sau khi sắp xếp
        Assert.assertEquals("Dr. John Doe", doctors.get(0).getName());
        Assert.assertEquals("Dr. Jane Smith", doctors.get(1).getName());
    }

    @Test
    public void testDisplayDoctors() {
        // Thêm vài bác sĩ để hiển thị
        Doctor doctor1 = new Doctor(1, "Dr. John Doe", "15/05/1980", "Cardiology", 3, "john@example.com", "0123456789");
        Doctor doctor2 = new Doctor(2, "Dr. Jane Smith", "20/07/1990", "Neurology", 2, "jane@example.com", "0987654321");
        doctors.add(doctor1);
        doctors.add(doctor2);

        // Gọi phương thức hiển thị
        Manager.displayDoctors(doctors);

        // Kiểm tra rằng danh sách có đúng số lượng bác sĩ
        Assert.assertEquals(2, doctors.size());
    }
}
