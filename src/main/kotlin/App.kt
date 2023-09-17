import Config.BOT_TOKEN
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.text
import com.github.kotlintelegrambot.entities.ChatId

class App {
}

fun main() {
    println("hello")
    val bot = bot {
        token = BOT_TOKEN

        dispatch {
            text {
                bot.sendMessage(ChatId.fromId(message.chat.id), text = "from bot: $text")
            }
        }
    }
    bot.startPolling()
}