package com.greenfox.webtodo.model;


import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  long id;
  Timestamp timestamp;
  String text;
  boolean urgent;
  boolean done;

  public Todo(String text, boolean urgent, boolean done) {
    this.timestamp  = new Timestamp(System.currentTimeMillis());
    this.text = text;
    this.urgent = urgent;
    this.done = done;
  }

  public Todo() {
  }
}
