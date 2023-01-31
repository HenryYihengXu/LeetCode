class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        int days = day;
        if (month < 3) {
            year -= 1;
            days += 365;
        }
        days += 365 * year + year / 4 - year / 100 + year / 400 + 1;

        int[] months = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        days += months[month - 1];
        String[] weekdays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return weekdays[(days - 2) % 7];
    }
}
