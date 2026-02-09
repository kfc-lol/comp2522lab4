package ca.bcit.comp2522.bookstore;

/**
 * Represents a calendar date.
 * This class validates dates, determines leap years,
 * formats dates, and calculates the day of the week.
 *
 * @author Kian Castro
 * @author Jeevan Jandu
 * @version 1
 */
public class Date
{


    private static final int MIN_YEAR = 1800;

    private static final int CURRENT_YEAR = 2026;

    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;

    private static final int JAN_CODE = 1;
    private static final int FEB_CODE = 4;
    private static final int MAR_CODE = 4;
    private static final int APR_CODE = 0;
    private static final int MAY_CODE = 2;
    private static final int JUN_CODE = 5;
    private static final int JUL_CODE = 0;
    private static final int AUG_CODE = 3;
    private static final int SEP_CODE = 6;
    private static final int OCT_CODE = 1;
    private static final int NOV_CODE = 4;
    private static final int DEC_CODE = 6;

    private static final int LEAP_YEAR_JAN_FEB_ADJUSTMENT = 2;
    private static final int LEAP_YEAR_INTERVAL = 4;
    private static final int CENTURY_1800_OFFSET = 2;
    private static final int CENTURY_2000_OFFSET = 6;
    private static final int DAYS_PER_WEEK = 7;
    private static final int TWO_DIGITS = 10;
    private static final int MONTHS_PER_YEAR = 12;
    private static final int DAYS_IN_FEBRUARY = 28;
    private static final int DAYS_IN_FEBRUARY_IF_LEAPYEAR = 29;
    private static final int SHORT_MONTH = 30;
    private static final int LONG_MONTH = 31;
    private static final int YEARS_PER_CENTURY = 100;
    private static final int LEAP_CENTURY_INTERVAL = 400;
    private static final int YEAR_NINETEEN_HUNDRED = 1900;
    private static final int YEAR_TWO_THOUSAND = 2000;


    private static final int SATURDAY = 0;
    private static final int SUNDAY = 1;
    private static final int MONDAY = 2;
    private static final int TUESDAY = 3;
    private static final int WEDNESDAY = 4;
    private static final int THURSDAY = 5;
    private static final int FRIDAY = 6;

    private final int year;
    private final int month;
    private final int day;

    /**
     * Constructs a ca.bcit.comp2522.bookstore.Date object.
     *
     * @param year the year
     * @param month the month
     * @param day the day
     */
    public Date(final int year,
                final int month,
                final int day)
    {
        validateYear(year);
        validateMonth(month);
        validateDay(year,
                month,
                day);

        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * Year validation method.
     * @param year MUST be within the minimum year to the current year.
     */
    private static void validateYear(final int year)
    {
        if (MIN_YEAR > year || year > CURRENT_YEAR)
        {
            throw new IllegalArgumentException("Year must be within " + MIN_YEAR +   " to " + CURRENT_YEAR + ".");
        }
    }

    /**
     * Month validation method.
     * @param month MUST be within January to December
     */
    private static void validateMonth(final int month)
    {
        if (month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Month " + month + " is invalid.");
        }
    }

    /**
     * Day validation method.
     * @param year to determine if leap year
     * @param month to determine upper bound of days
     * @param day Must be within the first day of the selected month and the last day
     */
    private static void validateDay(final int year,
                                    final int month,
                                    final int day)
    {
        final int maxDay;
        maxDay = getDaysInMonth(year, month);

        if(day < 1 || day > maxDay)
        {
            throw new IllegalArgumentException("Day " + day + " is invalid.");
        }
    }


    /**
     * Returns the day value.
     *
     * @return the day
     */
    public int getDay()
    {
        return day;
    }

    /**
     * Returns the month value.
     *
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Returns the year value.
     *
     * @return the year
     */
    public int getYear()
    {
        return year;
    }

    /**
     * Returns the current year.
     *
     * @return current year
     */
    public static int getCurrentYear() {
        return CURRENT_YEAR;
    }

    /**
     * Returns the date formatted as YYYY-MM-DD.
     *
     * @return formatted date string
     */
    public String getYYYYMMDD()
    {
        return year + "-" + (month < OCTOBER ? "0" + month : month) + "-" +
                (day < TWO_DIGITS ? "0" + day :day);
    }

    /**
     * Calculates the day of the week for this date.
     * The constructor allows only years between 1800 - CURRENT_YEAR; months 1-12; and
     * days 1-31 (or 30, or 29, or 28: properly).
     *
     * @return the day of the week
     */
    public String getDayOfTheWeek()
    {

        int total;
        final int yy;

        // Initialize a running total that will accumulate values for the day-of-week calculation
        total = 0;

        // Add the appropriate century offset based on the year
        // Years 2000 and beyond use the 2000s century offset
        if (year >= YEAR_TWO_THOUSAND)
        {
            total += CENTURY_2000_OFFSET;
        }
        // Years between 1800 and 1899 use the 1800s century offset
        else if (year >= MIN_YEAR && year < YEAR_NINETEEN_HUNDRED)
        {
            total += CENTURY_1800_OFFSET;
        }

        // Apply leap year adjustment for January and February
        // In leap years, Jan and Feb need a special adjustment because of the extra day
        // (Feb 29) comes after these months in the calendar
        if (isLeapYear(year) && (month == JANUARY || month == FEBRUARY))
        {
            total += LEAP_YEAR_JAN_FEB_ADJUSTMENT;
        }

        // Extract the last two digits of the year (e.g., 2024 becomes 24)
        yy = year % YEARS_PER_CENTURY;

        // Add the number of complete years divided by 12
        // This accounts for the pattern shift every 12 years
        total += yy / MONTHS_PER_YEAR;

        // Add the remainder of years (the last two digits modulo 12)
        // This handles the remaining years in the current 12-year cycle
        total += yy % MONTHS_PER_YEAR;

        // Add the number of leap years within those remaining years
        // Dividing by 4 gives us how many leap years occurred
        total += (yy % MONTHS_PER_YEAR) / LEAP_YEAR_INTERVAL;

        // Add the day of the month
        total += day;

        // Add the month-specific code (each month has a unique offset value)
        total += getMonthCode(month);

        // Take modulo 7 to get a value between 0-6 representing days of the week
        total %= DAYS_PER_WEEK;

        // Map the calculated value to the corresponding day name
        if (total == SATURDAY)
        {
            return "Saturday";
        }
        else if (total == SUNDAY)
        {
            return "Sunday";
        }
        else if (total == MONDAY)
        {
            return "Monday";
        }
        else if (total == TUESDAY)
        {
            return "Tuesday";
        }
        else if (total == WEDNESDAY)
        {
            return "Wednesday";
        }
        else if (total == THURSDAY)
        {
            return "Thursday";
        }
        else if (total == FRIDAY)
        {
            return "Friday";
        }
        else
        {
            // If the total doesn't match any valid day (0-6), throw an error
            throw new IllegalArgumentException("Not a valid day.");
        }
    }

    /**
     * Determines whether a year is a leap year.
     *
     * @param year the year to check
     * @return true if leap year, false otherwise
     */
    public static boolean isLeapYear(final int year)
    {
        return (year % LEAP_CENTURY_INTERVAL == 0) ||
                ((year % LEAP_YEAR_INTERVAL    == 0) &&
                        (year % YEARS_PER_CENTURY     != 0));
    }

    /**
     * Returns the number of days in a given month.
     *
     * @param year the year
     * @param month the month
     * @return number of days in the month
     */
    private static int getDaysInMonth(final int year,
                                      final int month) {
        if(month == APRIL     ||
                month == JUNE      ||
                month == SEPTEMBER ||
                month == NOVEMBER)
        {
            return SHORT_MONTH;
        }
        else if(month == FEBRUARY)
        {
            if (isLeapYear(year))
            {
                return DAYS_IN_FEBRUARY_IF_LEAPYEAR;
            }
            else
            {
                return DAYS_IN_FEBRUARY;
            }
        }
        else if (month == JANUARY ||
                month == MARCH   ||
                month == MAY     ||
                month == JULY    ||
                month == AUGUST  ||
                month == OCTOBER ||
                month == DECEMBER)
        {
            return LONG_MONTH;
        }
        else
        {
            throw new IllegalArgumentException("Not a valid month");
        }
    }

    /**
     * Returns the month code used for day-of-week calculations.
     *
     * @param month the month
     * @return the month code
     */
    private int getMonthCode(final int month)
    {
        if (month == JANUARY)
        {
            return JAN_CODE;
        }
        else if (month == FEBRUARY)
        {
            return FEB_CODE;
        }
        else if (month == MARCH)
        {
            return MAR_CODE;
        }
        else if (month == APRIL)
        {
            return APR_CODE;
        }
        else if(month == MAY)
        {
            return MAY_CODE;
        }
        else if (month == JUNE)
        {
            return JUN_CODE;
        }
        if (month == JULY)
        {
            return JUL_CODE;
        }
        else if (month == AUGUST)
        {
            return AUG_CODE;
        }
        else if (month == SEPTEMBER)
        {
            return SEP_CODE;
        }
        else if (month == OCTOBER)
        {
            return OCT_CODE;
        }
        else if (month == NOVEMBER)
        {
            return NOV_CODE;
        }
        else if (month == DECEMBER)
        {
            return DEC_CODE;
        }
        else
        {
            throw new IllegalArgumentException("Cannot retrieve code, not a valid month");
        }
    }

    /**
     * Returns the name of the month.
     *
     * @return the month name
     */
    public String getMonthName()
    {
        int month;
        month = getMonthCode(getMonth());
        if (month == JANUARY)
        {
            return "January";
        }
        else if (month == FEBRUARY)
        {
            return "February";
        }
        else if (month == MARCH)
        {
            return "March";
        }
        else if (month == APRIL)
        {
            return "April";
        }
        else if (month == MAY)
        {
            return "May";
        }
        else if (month == JUNE)
        {
            return "June";
        }
        else if (month == JULY)
        {
            return "July";
        }
        else if (month == AUGUST)
        {
            return "August";
        }
        else if (month == SEPTEMBER)
        {
            return "September";
        }
        else if (month == OCTOBER)
        {
            return "October";
        }
        else if (month == NOVEMBER)
        {
            return "November";
        }
        else if (month == DECEMBER)
        {
            return "December";
        }
        else
        {
            throw new IllegalArgumentException("Not a valid month number");
        }
    }
}