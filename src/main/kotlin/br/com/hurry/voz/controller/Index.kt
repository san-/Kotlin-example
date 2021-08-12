package br.com.hurry.voz.controller

import br.com.hurry.voz.model.User
import br.com.hurry.voz.model.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping(path = ["/"])
class Index @Autowired constructor(
    val userRepository: UserRepository
) {

    @GetMapping
    fun index(): ResponseEntity<User> {
        val name = "%s %s".format(randomName(), randomName())
        val user = userRepository.save(User(name))
        return ResponseEntity.ok(user)
    }

    @GetMapping(path = ["/list"])
    fun list(): ResponseEntity<Iterable<User>>{
        val users = userRepository.findAll().sortedBy { it.name }
        return ResponseEntity.ok(users)
    }


    fun randomName(): String {
        val charPool: CharRange = ('a'..'z')
        val outputStrLength = (6..15).shuffled().first()

        return (1..outputStrLength)
            .map { kotlin.random.Random.nextInt(0, charPool.count()) }
            .map(charPool::elementAt)
            .joinToString("")
            .replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
            }
    }


}
