package ru.hh.school.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Vacancy {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "vacancy_id")
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "employer_id", nullable = false)
  private Employer employer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "area_id")
  private Area area;

  @NotNull
  @Column(length = 100)
  private String title;

  @Column(columnDefinition = "varchar(255) default null")
  private String description;

  @Column(name = "compensation_from")
  private Integer compensationFrom;

  @Column(name = "compensation_to")
  private Integer  compensationTo;

  @Column(name = "compensation_gross")
  private Boolean compensationGross;

  @Column(name = "creation_time")
  private LocalDateTime creationTime;

  @Column(name = "archiving_time", columnDefinition = "timestamp default null")
  private LocalDateTime archivingTime;

  public Vacancy() {}

  public Vacancy(Employer employer) {
    this.employer = employer;
  }

  public void setArea(Area area) {
    this.area = area;
  }

  public Area getArea() { return area; }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Employer getEmployer() {
    return employer;
  }

  public void setEmployer(Employer employer) {
    this.employer = employer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setCompensationFrom(Integer compensationFrom) {
    this.compensationFrom = compensationFrom;
  }

  public void setCompensationTo(Integer compensationTo) {
    this.compensationTo = compensationTo;
  }

  public LocalDateTime getCreationTime() { return creationTime; }

  public void setCreationTime(LocalDateTime creationTime) { this.creationTime = creationTime; }

  public Boolean getCompensationGross() { return compensationGross; }

  public void setCompensationGross(Boolean compensationGross) { this.compensationGross = compensationGross; }

  public Integer getCompensationTo() { return compensationTo; }

  public Integer getCompensationFrom() { return compensationFrom; }

  public String getDescription() { return description; }

  public LocalDateTime getArchivingTime() {
    return archivingTime;
  }

  public void setArchivingTime(LocalDateTime archivingTime) {
    this.archivingTime = archivingTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Vacancy vacancy = (Vacancy) o;
    return Objects.equals(id, vacancy.id);
  }

  @Override
  public int hashCode() {
    return 17;
  }

}
