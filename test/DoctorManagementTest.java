import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoctorManagementTest {
    private DoctorManagement doctorManagement;

    @Before
    public void setUp() {
        doctorManagement = new DoctorManagement();
    }

    @Test
    public void testAddDoctor() {
        Doctor doctor = new Doctor(1, "Dr. John", "Cardiology");
        doctorManagement.addDoctor(doctor);
        assertEquals(1, doctorManagement.listDoctors().size());
    }

    @Test
    public void testFindDoctorById() {
        Doctor doctor = new Doctor(1, "Dr. John", "Cardiology");
        doctorManagement.addDoctor(doctor);
        Doctor foundDoctor = doctorManagement.findDoctorById(1);
        assertNotNull(foundDoctor);
        assertEquals("Dr. John", foundDoctor.getName());
    }

    @Test
    public void testRemoveDoctorById() {
        Doctor doctor = new Doctor(1, "Dr. John", "Cardiology");
        doctorManagement.addDoctor(doctor);
        boolean removed = doctorManagement.removeDoctorById(1);
        assertTrue(removed);
        assertEquals(0, doctorManagement.listDoctors().size());
    }

    @Test
    public void testRemoveDoctorById_NotFound() {
        boolean removed = doctorManagement.removeDoctorById(999);
        assertFalse(removed);
    }
}
