
package magazine;
import java.util.Calendar;

/**
 * Class to compute the number of weeks in the present month
 * @author Faiz
 */
public class Dates 
{
    /**
     * 
     * @param theDay Day
     * @param theMonth Month
     * @param theYear Year
     * @return numOfWeeksInMonth Number of weeks in a given month
     * https://www.roseindia.net/answers/viewqa/Java-Beginners/12012-How-to-calculate-number-of-weeks-in-a-specified-month.html
     */   
    public int Week_Of_Month(int theDay, int theMonth, int theYear)
    {
        Calendar calendar = Calendar.getInstance(); 
        int year = theYear; 
        int month = getMonth(theMonth); 
        int day = theDay; 
        calendar.set(year, month, day); 

        int numOfWeeksInMonth = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);

        System.out.println("Number of Weeks In Month: " + numOfWeeksInMonth);
        
        return numOfWeeksInMonth;
    }
    
    /**
     * Returns month value in the format used by the Calender package
     * @param theMonth MONTH
     * @return Month in the right format
     */
    public int getMonth(int theMonth)
    {
        int month = 0;
        switch(theMonth)
        {
            case 1: 
                month = Calendar.JANUARY;
                break;
            case 2:
                month = Calendar.FEBRUARY;
                break;
            case 3: 
                month = Calendar.MARCH;
                break;
            case 4:
                month = Calendar.APRIL;
                break;
            case 5: 
                month = Calendar.MAY;
                break;
            case 6:
                month = Calendar.JUNE;
                break;
            case 7: 
                month = Calendar.JULY;
                break;
            case 8: 
                month = Calendar.AUGUST;
                break;
            case 9: 
                month = Calendar.SEPTEMBER;
                break;
            case 10: 
                month = Calendar.OCTOBER;
                break;
            case 11: 
                month = Calendar.NOVEMBER;
                break;
            case 12: 
                month = Calendar.DECEMBER;
                break;
            default:
                
                        
        }
        return month;
        
    }
    
}
