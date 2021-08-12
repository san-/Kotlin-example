package br.com.hurry.voz.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User(userName: String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id = 0;
    var name = userName;

}
