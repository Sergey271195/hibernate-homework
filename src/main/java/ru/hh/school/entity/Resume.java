package ru.hh.school.entity;

import javax.persistence.*;

//TODO: оформите entity
@Entity
public class Resume {
  // TODO: сделать так, чтобы id брался из sequence-а
  // таким образом, мы сможем отправлять в бд запросы батчами.
  // нужно учитывать, что описание sequence при создании таблицы также должно соответствовать
  // хиберовской сущности (см. create_resume.sql)
  //
  // Подробнее:
  // https://vladmihalcea.com/how-to-batch-insert-and-update-statements-with-hibernate/
  // https://vladmihalcea.com/from-jpa-to-hibernates-legacy-and-enhanced-identifier-generators/

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resume_generator")
  @SequenceGenerator(name = "resume_generator", sequenceName = "resume_id_seq")
  private Integer id;

  @Column(columnDefinition="TEXT")
  private String description;

  Resume() {}

  public Resume(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
