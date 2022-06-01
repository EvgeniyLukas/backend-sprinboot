package com.example.backendsprinboot.entity;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "task", schema = "tasklist")
public class Task {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "title")
  private String title;
  @Basic
  @Column(name = "completed")
  private Integer completed;
  @Basic
  @Column(name = "date")
  private Date date;
  @ManyToOne
  @JoinColumn(name = "priority_id", referencedColumnName = "id")
  private Priority priority;
  @ManyToOne
  @JoinColumn(name = "category_id", referencedColumnName = "id")
  private Category category;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Integer getCompleted() {
    return completed;
  }

  public Date getDate() {
    return date;
  }

  public Priority getPriority() {
    return priority;
  }

  public Category getCategory() {
    return category;
  }

}
