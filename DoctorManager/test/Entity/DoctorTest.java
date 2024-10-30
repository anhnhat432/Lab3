package Entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DoctorTest {

    private Doctor doctor;

    @Before
    public void setUp() {
        doctor = new Doctor(1, "Dr. John Doe", "1980-01-15", "Cardiology", 5, "johndoe@example.com", "1234567890");
    }

    @Test
    public void testGetId() {
        assertEquals(1, doctor.getId());
    }

    @Test
    public void testSetId() {
        doctor.setId(2);
        assertEquals(2, doctor.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("Dr. John Doe", doctor.getName());
    }

    @Test
    public void testSetName() {
        doctor.setName("Dr. Jane Smith");
        assertEquals("Dr. Jane Smith", doctor.getName());
    }

    @Test
    public void testGetDateOfBirth() {
        assertEquals("1980-01-15", doctor.getDateOfBirth());
    }

    @Test
    public void testSetDateOfBirth() {
        doctor.setDateOfBirth("1975-03-10");
        assertEquals("1975-03-10", doctor.getDateOfBirth());
    }

    @Test
    public void testGetSpecialization() {
        assertEquals("Cardiology", doctor.getSpecialization());
    }

    @Test
    public void testSetSpecialization() {
        doctor.setSpecialization("Neurology");
        assertEquals("Neurology", doctor.getSpecialization());
    }

    @Test
    public void testGetAvailability() {
        assertEquals(5, doctor.getAvailability());
    }

    @Test
    public void testSetAvailability() {
        doctor.setAvailability(3);
        assertEquals(3, doctor.getAvailability());
    }

    @Test
    public void testGetEmail() {
        assertEquals("johndoe@example.com", doctor.getEmail());
    }

    @Test
    public void testSetEmail() {
        doctor.setEmail("janesmith@example.com");
        assertEquals("janesmith@example.com", doctor.getEmail());
    }

    @Test
    public void testGetMobile() {
        assertEquals("1234567890", doctor.getMobile());
    }

    @Test
    public void testSetMobile() {
        doctor.setMobile("0987654321");
        assertEquals("0987654321", doctor.getMobile());
    }

    @Test
    public void testToString() {
        String expected = "Doctor{id=1, name=Dr. John Doe, dateOfBirth=1980-01-15, specialization=Cardiology, availability=5, email=johndoe@example.com, mobile=1234567890}";
        assertEquals(expected, doctor.toString());
    }
}
