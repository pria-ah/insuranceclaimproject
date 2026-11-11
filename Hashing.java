
import java.util.*;

class Hashing {

    public static void main(String[] args) {

        HashSet<String> claims = new HashSet<>();

        String[] policy = {
            "POL123", "pol123", "POL456", " POL123 "
        };

        String[] date = {
            "2026-11-10", "2026-11-10",
            "2026-11-11", "2026-11-10"
        };

        for (int i = 0; i < policy.length; i++) {

            String key = policy[i].trim().toLowerCase()
                         + "_" + date[i].trim();

            if (claims.contains(key)) {
                System.out.println("Duplicate: " + policy[i]);
            } else {
                claims.add(key);
                System.out.println("New Claim: " + policy[i]);
            }
        }
    }
}
