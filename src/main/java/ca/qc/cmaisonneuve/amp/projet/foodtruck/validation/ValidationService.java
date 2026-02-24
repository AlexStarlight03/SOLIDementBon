package ca.qc.cmaisonneuve.amp.projet.foodtruck.validation;

public class ValidationService {
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }

    public boolean isValidPhone(String phone) {
        if (phone == null) return false;
        String digits = phone.replaceAll("[^0-9]", "");
        return digits.length() >= 10 && digits.length() <= 15;
    }
}
