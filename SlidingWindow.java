
class SlidingWindow {

    public static void main(String[] args) {

        int[] claims = {120, 150, 130, 80, 110, 140, 160, 90};

        int left = 0;
        int max = 0;

        for (int right = 0; right < claims.length; right++) {

            if (claims[right] <= 100) {
                left = right + 1;
            }

            int length = right - left + 1;

            if (length > max)
                max = length;
        }

        System.out.println("Longest consecutive days: " + max);
    }
}
