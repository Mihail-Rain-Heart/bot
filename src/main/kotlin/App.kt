import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId

class App {
}

fun main() {
    println("hello")
    val bot = bot {
        token = "6619419904:AAGG56obGjsbO1WYVoJwnoAIDDYItrAR2tc"

        dispatch {
            text {
                bot.sendMessage(ChatId.fromId(message.chat.id), text = "from bot: $text")
            }
        }
    }
    bot.startPolling()
}