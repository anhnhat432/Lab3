
import java.util.List;

public class DoctorManagementService {
    private DoctorManagement doctorManagement;

    public DoctorManagementService() {
        doctorManagement = new DoctorManagement();
    }

    public String addDoctor(int id, String name, String specialization) {
        Doctor doctor = new Doctor(id, name, specialization);
        doctorManagement.addDoctor(doctor);
        return "Doctor added successfully!";
    }

    public String findDoctorById(int id) {
        Doctor foundDoctor = doctorManagement.findDoctorById(id);
        if (foundDoctor != null) {
            return "Doctor Found: " + foundDoctor.toString();
        } else {
            return "Doctor not found.";
        }
    }

    public String removeDoctorById(int id) {
        boolean removed = doctorManagement.removeDoctorById(id);
        if (removed) {
            return "Doctor removed successfully.";
        } else {
            return "Doctor not found.";
        }
    }

    public List<Doctor> listDoctors() {
        return doctorManagement.listDoctors();
    }
}
