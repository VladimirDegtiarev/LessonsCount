import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LessonsCount {
/*    Наши занятия закончатся 20 января 2020 года. Сколько занятий осталось, если они проходят 3 раза в неделю (пн, ср, пт).
      Праздничные дни не учитывать.
 */
public static void main (String[] args) {

    // LocalDate currentDate = LocalDate.of(2019, Month.NOVEMBER, 5);     // Можно указать любую дату
    LocalDate currentDate = LocalDate.now();

    LocalDate courseExpiredDate = LocalDate.of(2020, Month.JANUARY, 20);

    long weeksBetweenDates = ChronoUnit.WEEKS.between(currentDate, courseExpiredDate);
    long daysBetweenDates = ChronoUnit.DAYS.between(currentDate, courseExpiredDate);

    long additionalDays = daysBetweenDates - (7 * weeksBetweenDates);
    long additionalLesson = 0;

        if (additionalDays > 0 && additionalDays <= 2) { additionalLesson = 1;}
            else if (additionalDays > 2 && additionalDays <= 4) {additionalLesson = 2;}
            else if (additionalDays > 4) {additionalLesson = 3;}
            else {additionalLesson = 0;}

    long numberOfLessonsPerWeek = 3;

    long numberOfAdditionalDaysOff = 8;          // Указать общее кол-во праздничных дней, если они есть в указанном периоде времени

    long numberOfAdditionalWeeksOff = numberOfAdditionalDaysOff / 7;
         numberOfAdditionalDaysOff = numberOfAdditionalDaysOff - 7 * numberOfAdditionalWeeksOff;

    if (numberOfAdditionalWeeksOff != 0) { additionalLesson -= (numberOfAdditionalWeeksOff *3 );}

    if (numberOfAdditionalDaysOff > 0 && numberOfAdditionalDaysOff <= 2) { additionalLesson -= 1;}
    else if (numberOfAdditionalDaysOff > 2 && numberOfAdditionalDaysOff <= 4) {additionalLesson -= 2;}
    else if (numberOfAdditionalDaysOff > 4 && numberOfAdditionalDaysOff <= 7) {additionalLesson -= 3;}
    else {additionalLesson -= 0;}

    long totalNumberOfLessons =  weeksBetweenDates * numberOfLessonsPerWeek + additionalLesson;

    System.out.println("Сегодня: " +  currentDate);
    System.out.println("Дата окончания курса: " + courseExpiredDate);
    System.out.println("Всего полных недель межну этими датами: " + weeksBetweenDates);
    System.out.println("Общее кол-во дней межну этими датами: : " + daysBetweenDates);
    System.out.printf ("Всего лекций осталось (с учётом праздничных дней - %d): %d", (numberOfAdditionalDaysOff + 7 * numberOfAdditionalWeeksOff), totalNumberOfLessons);

    }
}
