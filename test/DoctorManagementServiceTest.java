import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoctorManagementServiceTest {

    private DoctorManagementService service;

    @Before
    public void setUp() {
        service = new DoctorManagementService();
    }

    @Test
    public void testAddDoctor() {
        String result = service.addDoctor(1, "Dr. John", "Cardiology");
        assertEquals("Doctor added successfully!", result);

        assertEquals(1, service.listDoctors().size());
        Doctor addedDoctor = service.listDoctors().get(0);
        assertEquals(1, addedDoctor.getId());
        assertEquals("Dr. John", addedDoctor.getName());
        assertEquals("Cardiology", addedDoctor.getSpecialization());
    }

    @Test
    public void testFindDoctor() {
        service.addDoctor(1, "Dr. John", "Cardiology");
        String result = service.findDoctorById(1);
        assertTrue(result.contains("Dr. John"));

        // Test trường hợp không tìm thấy bác sĩ
        String notFoundResult = service.findDoctorById(999);
        assertEquals("Doctor not found.", notFoundResult);
    }

    @Test
    public void testRemoveDoctor() {
        service.addDoctor(1, "Dr. John", "Cardiology");
        String result = service.removeDoctorById(1);
        assertEquals("Doctor removed successfully.", result);

        // Đảm bảo bác sĩ đã bị xóa
        assertEquals(0, service.listDoctors().size());

        // Test trường hợp không tìm thấy ID để xóa
        String notFoundResult = service.removeDoctorById(999);
        assertEquals("Doctor not found.", notFoundResult);
    }

    @Test
    public void testListDoctors() {
        // Danh sách ban đầu phải rỗng
        assertTrue(service.listDoctors().isEmpty());

        // Sau khi thêm bác sĩ, danh sách phải có bác sĩ
        service.addDoctor(1, "Dr. John", "Cardiology");
        assertFalse(service.listDoctors().isEmpty());

        // Kiểm tra thông tin của bác sĩ trong danh sách
        Doctor listedDoctor = service.listDoctors().get(0);
        assertEquals(1, listedDoctor.getId());
        assertEquals("Dr. John", listedDoctor.getName());
    }
}
