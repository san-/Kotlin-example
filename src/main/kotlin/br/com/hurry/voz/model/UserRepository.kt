package br.com.hurry.voz.model

import org.springframework.data.repository.CrudRepository

interface UserRepository:CrudRepository<User, Long> {
}
