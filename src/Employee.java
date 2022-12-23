import java.util.Date;
import java.time.YearMonth;

public class Employee {
    String name;
    double salary;
    int workHours;
    int hireYear;

    Employee(String name, double salary, int workHours, int hireYear){
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public double tax(){
        if (this.salary<1000){
            System.out.println("Vergi yok");
            return 0;
        }
        else{
            System.out.println("Vergi: " + (this.salary*3/100));
            return (this.salary*3/100);
        }
    }

    public double bonus(){
        double bonus;
        if (this.workHours>40){
            bonus=(this.workHours-40)*30;
            System.out.println("Bonus : "+bonus);
            return bonus;
        }
        else
            return 0;
    }

    public double raiseSalary(){
        Date today = new Date();
        double raise=0;
        int yearsWorked =  (YearMonth.now().getYear())-this.hireYear;
        if (yearsWorked<10){
            raise+= this.salary*5/100;
            System.out.println("Maaş Artışı : "+raise);
        }
        else if(yearsWorked>9 && yearsWorked<20){
            raise+= this.salary*10/100;
            System.out.println("Maaş Artışı : "+raise);
        }
        else if (yearsWorked>19){
            raise+= this.salary*15/100;
            System.out.println("Maaş Artışı : "+raise);
        }
        return raise;
    }
    public void printEmployee(){
        System.out.println("Adı : "+this.name);
        System.out.println("Maaşı : "+this.salary);
        System.out.println("Çalışma Saati : "+this.workHours);
        System.out.println("Başlangıç Yılı : "+this.hireYear);
        double tax = this.tax();
        double bonus = this.bonus();
        double raise = this.raiseSalary();

        System.out.println("Vergi ve Bonuslar ile birlikte maaş : " +(-tax+bonus+this.salary));
        System.out.println("Toplam Maaş : "+(raise+this.salary));
    }
}
