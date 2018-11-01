package Entity;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Day {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Brigade.class, cascade = CascadeType.ALL)
  private Brigade brigadeDay;
  @ManyToOne(fetch = FetchType.EAGER, targetEntity = Brigade.class, cascade = CascadeType.ALL)
  private Brigade brigadeNigth;
  //@Temporal(TemporalType.DATE)
  private LocalDate date;
  private boolean dayOff = false;


  public Day() {
  }

  public Day(Brigade brigadeDay, Brigade brigadeNigth, LocalDate date, boolean dayOff) {
    this.brigadeDay = brigadeDay;
    this.brigadeNigth = brigadeNigth;
    this.date = date;
    this.dayOff = dayOff;
  }

  public Brigade getBrigadeDay() {
    return brigadeDay;
  }

  public void setBrigadeDay(Brigade brigadeDay) {
    this.brigadeDay = brigadeDay;
  }

  public Brigade getBrigadeNigth() {
    return brigadeNigth;
  }

  public void setBrigadeNigth(Brigade brigadeNigth) {
    this.brigadeNigth = brigadeNigth;
  }

  public LocalDate getDate() {
    return date;
  }

  public boolean isDayOff() {
    return dayOff;
  }

  public void setDayOff(boolean dayOff) {
    this.dayOff = dayOff;
  }

  @Override
  public String toString() {
    return "Day{" +
        "brigadeDay=" + brigadeDay +
        ", brigadeNigth=" + brigadeNigth +
        ", date='" + date + '\'' +
        ", dayOff=" + dayOff +
        '}';
  }
}


