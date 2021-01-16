package ru.hh.school.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Area {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id")
  private Integer id;

  @NotNull
  @Column(length = 100, nullable = false)
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Area area = (Area) o;
    return Objects.equals(id, area.id);
  }

  @Override
  public int hashCode() { return 27; }

  @Override
  public String toString() {
    return "Area {id=" + id + ", name='" + name +"'}";
  }

  public Area() {}

}
