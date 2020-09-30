package com.example.SourceryAcademySpecialTask;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class SourceryAcademySpecialTaskApplication {
    private static List<String> listOfDates = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Please write starting year");
		int year1 = scanner.nextInt();

		System.out.println("please write finishing year");
		int year2 = scanner.nextInt();

        printBonusDatesBetween(year1, year2);

    }

    public static void printBonusDatesBetween(int fromYear, int toYear) {

        LocalDate startDate = getStartingDate(fromYear);
        LocalDate endDate = getEndingDate(toYear);

        while (!startDate.isAfter(endDate)) {
            checkBonusDates(startDate);
            startDate = startDate.plusDays(1);
        }

        listOfDates.forEach(date -> System.out.println(date));

    }

    //get starting local date in the format of (yyyy-MM-dd)
    public static LocalDate getStartingDate(int fromYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, fromYear);
        calendar.set(Calendar.DAY_OF_YEAR, 1);
        String formattedStartingDate = dateFormat.format(calendar.getTime());

        return LocalDate.parse(formattedStartingDate);
    }

    //get ending local date in the format of (yyyy-MM-dd)
    public static LocalDate getEndingDate(int toYear) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, toYear);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        String formattedEndingDate = dateFormat.format(calendar.getTime());

        return LocalDate.parse(formattedEndingDate);

    }

    //reverse number and check if it is equal to year
    public static void checkBonusDates(LocalDate date) {
        String day = Integer.toString(date.getDayOfMonth());
        if (date.getDayOfYear() < 10) {
            day = "0" + date.getMonthValue();
        }

        String month = Integer.toString(date.getMonthValue());
        if (date.getMonthValue() < 10) {
            month = "0" + date.getMonthValue();
        }

        String dayMonth = day + month;
        String reversedNumber = "";
        for (int i = dayMonth.length() - 1; i >= 0; i--) {
            reversedNumber = reversedNumber + dayMonth.charAt(i);
        }
        String year = Integer.toString(date.getYear());

        if (reversedNumber.equals(year)) {
            String requiredDate = year + "-" + day + "-" + month;
            listOfDates.add(requiredDate);
        }
    }
}
