import Config.BOT_TOKEN
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.*
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.payments.LabeledPrice
import com.github.kotlintelegrambot.entities.payments.PaymentInvoiceInfo
import com.github.kotlintelegrambot.logging.LogLevel
import java.math.BigInteger

class App {
}

fun main() {
    println("hello")
    val bot = bot {
        timeout = 60
        token = BOT_TOKEN
        logLevel = LogLevel.All(
            networkLogLevel = LogLevel.Network.Body
        )

        dispatch {
            text {
                bot.sendMessage(ChatId.fromId(message.chat.id), text = "from bot: $text")
            }
            message {
                bot.sendInvoice(
                    chatId = ChatId.fromId(message.chat.id),
                    paymentInvoiceInfo = PaymentInvoiceInfo(
                        title = "Какой-то товар",
                        description = "Какое-то описание",
                        payload = "payload",
                        providerToken = "381764678:TEST:66840",
                        startParameter = "start",
                        currency = "RUB",
                        prices = listOf(LabeledPrice(label = "\u20BD", amount = BigInteger.valueOf(10158L)))
                    ),
                    disableNotification = true,
                    replyToMessageId = message.messageId,
                    allowSendingWithoutReply = false,
                    replyMarkup = null
                )
            }

            preCheckoutQuery {
                println("callback: ${update.message} ${preCheckoutQuery}")
                bot.answerPreCheckoutQuery(
                    preCheckoutQueryId = preCheckoutQuery.id,
                    true
                )
            }
        }
    }
    bot.startPolling()
}