import java.util.ArrayList;
import java.util.List;

public class DoctorManagement {
    private List<Doctor> doctors;

    public DoctorManagement() {
        doctors = new ArrayList<>();
    }

    // Add a doctor to the list
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Find a doctor by ID
    public Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Remove a doctor by ID
    public boolean removeDoctorById(int id) {
        Doctor doctor = findDoctorById(id);
        if (doctor != null) {
            doctors.remove(doctor);
            return true;
        }
        return false;
    }

    // List all doctors
    public List<Doctor> listDoctors() {
        return doctors;
    }
}
