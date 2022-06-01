package com.example.backendsprinboot.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode
@Setter
@NoArgsConstructor
@Table(name = "stat", schema = "tasklist")
public class Stat {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "completed_total")
  private Long completedTotal;
  @Basic
  @Column(name = "uncompleted_total")
  private Long uncompletedTotal;

  public Long getId() {
    return id;
  }

  public Long getCompletedTotal() {
    return completedTotal;
  }

  public Long getUncompletedTotal() {
    return uncompletedTotal;
  }



}
