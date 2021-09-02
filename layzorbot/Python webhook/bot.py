
"""
Simple Bot to reply to Telegram messages taken from the python-telegram-bot examples.
Source: https://github.com/python-telegram-bot/python-telegram-bot/blob/master/examples/echobot2.py
"""

import logging
from typing import Dict
from telegram.ext import Updater, CommandHandler
import os
PORT = int(os.environ.get('PORT', 8443))
HOST = "localhost" # YOUR HOST HERE

# Enable logging
logging.basicConfig(format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
                    level=logging.INFO)

logger = logging.getLogger(__name__)
TOKEN = "" # YOUR TOKEN HERE
BOTNAME = "" # YOUR BOT NAME HERE

helpMsg = "Lasers all around!\n" + "/colors - List of available colors\n" \
		+ "/mono {color} {number} - Creates a pattern of color\n" \
		+ "/poly {color1} {color2} - Creates a pattern between colors\n" + "/rainbow - It's a 🌈RAINBOW🌈"
colorsMsg = "red\n" + "orange\n" + "yellow\n" + "lime\n" + "green\n" + "cyan\n" + "blue\n" + "navy\n" \
		+ "purple\n" + "pink"

#sticker id
RED1 = "CAACAgQAAxkBAAMdYJkejQeen0CbH8-9R7Zm7p_Acf8AAmIKAAP3sVBiMqllJicS4x8E"
RED2 = "CAACAgQAAxkBAAMfYJkelwHNVi7Rhl-lxF20_OiDTDEAAhQLAALx4LBQ0usCh5fiuocfBA"
ORANGE1 = "CAACAgQAAxkBAAMhYJkenz1-oI4Zk0N3ba_mL8aKsyoAAm4JAAKHEqhQ91vGn6hFB4wfBA"
ORANGE2 = "CAACAgQAAxkBAAMjYJker-qvxRqdn9oDf6eAIjF2t5YAAk0OAAI5GKlQ_0zLZUXwjQsfBA"
YELLOW1 = "CAACAgQAAxkBAAMlYJkeuC1_mf1gcSkWYrWkFat-CSQAAmUJAAKjd6lQ32RHrSVH-qofBA"
YELLOW2 = "CAACAgQAAxkBAAMnYJkevsvUHYK40WVRWNyoBSNg3GYAAjUKAALvF7FQno80Quk6EmcfBA"
LIME1 = "CAACAgQAAxkBAAMpYJkexaY7PdymznwQI1Z-xfkgs5IAAvcLAAJxx6hQ6f3LXzRMcTEfBA"
LIME2 = "CAACAgQAAxkBAAMrYJkeytDHVk_8Pts8252DslHiSXAAAloKAAIq3qhQQGkERslFFrMfBA"
GREEN1 = "CAACAgQAAxkBAAMtYJke0F2nyeZwUC8T7BFWTYLRwcIAAgEKAAL7qKhQpUee1Ij3VkMfBA"
GREEN2 = "CAACAgQAAxkBAAMvYJke1VDYpfxpkwElzmN8AiiMbYgAAlAKAAJ8tbFQ9TgPDp40cuEfBA"
CYAN1 = "CAACAgQAAxkBAAMxYJke42EWGw0ko488UcAwexQMThsAAqsIAAIo1KlQnC8sKzWpSjofBA"
CYAN2 = "CAACAgQAAxkBAAMzYJke8llLXk8k2JOLpHsTU6_fVZEAAhcKAAKvoKlQgSrlNNfXNXIfBA"
BLUE1 = "CAACAgQAAxkBAAM1YJke92_GUWfEvb6mxgkJhkkgmp8AAhYLAALIXahQjXpdbyiab3kfBA"
BLUE2 = "CAACAgQAAxkBAAM3YJke_bH9_Vqgu-bB69OKK3aq9UEAAtkJAAKIArFQvgVxjNc_elQfBA"
NAVY1 = "CAACAgQAAxkBAAM5YJkfCkVYlEwehLcQRkn78dzbXlIAAgoLAAK4z6hQw_2tvvOqojQfBA"
NAVY2 = "CAACAgQAAxkBAAM7YJkfD06Y2ntJkNEJVqKIgy8dnhIAAgYOAAKJ-bBQFn9z--GwcE8fBA"
PURPLE1 = "CAACAgQAAxkBAAM9YJkfFqOFt96zoEb5JCNvF0neOPMAAhIMAAJeF7BQYHtNtTAkV5EfBA"
PURPLE2 = "CAACAgQAAxkBAAM_YJkfGjvDruk73qBk_S45c5SfR1UAAgQJAAL9A7BQCcY3lpnHT74fBA"
PINK1 = "CAACAgQAAxkBAANBYJkfJVLu4cqCVn-GDYAWWgnB4XsAApoIAAJ1D7BQRJWb_LHFA_EfBA"
PINK2 = "CAACAgQAAxkBAANDYJkfLsFH7Bmh79rsrPslxDOfAAErAAI-CAACOz2pUPuNngQ5G81RHwQ"

color_arr_1 = [
        RED1, ORANGE1, YELLOW1, LIME1, GREEN1, CYAN1, BLUE1, NAVY1, PURPLE1, PINK1]
color_arr_2 = [
        RED2, ORANGE2, YELLOW2, LIME2, GREEN2, CYAN2, BLUE2, NAVY2, PURPLE2, PINK2]
color_map_1 = {
        "red": RED1,
        "orange": ORANGE1,
        "yellow": YELLOW1,
        "lime": LIME1,
        "green": GREEN1,
        "cyan": CYAN1,
        "blue": BLUE1,
        "navy": NAVY1,
        "purple": PURPLE1,
        "pink": PINK1,}
color_map_2 = {
        "red": RED2,
        "orange": ORANGE2,
        "yellow": YELLOW2,
        "lime": LIME2,
        "green": GREEN2,
        "cyan": CYAN2,
        "blue": BLUE2,
        "navy": NAVY2,
        "purple": PURPLE2,
        "pink": PINK2,}

# Define a few command handlers. These usually take the two arguments update and
# context. Error handlers also receive the raised TelegramError object in error.
def start(update, context):
    """Send a message when the command /start is issued."""
    if update.message.chat.type == "private" or update.message.text.endswith("@" + BOTNAME):
        update.message.reply_text('Hi!\n/help')

def help(update, context):
    """Send a message when the command /help is issued."""
    if update.message.chat.type == "private" or update.message.text.endswith("@" + BOTNAME):
        update.message.reply_text(helpMsg)

def colors(update, context):
    """Send a message when the command /help is issued."""
    update.message.reply_text(colorsMsg)

def mono(update, context):
    """Send a message when the command /mono is issued."""
    input = update.message.text.split(" ", 4)

    if len(input) < 2 or color_map_1[input[1]] == None:
        return

    if len(input) == 2:
        context.bot.send_sticker(update.message.chat_id, color_map_1[input[1]])
        context.bot.send_sticker(update.message.chat_id, color_map_2[input[1]])
        context.bot.send_sticker(update.message.chat_id, color_map_1[input[1]])
    elif len(input) == 3:
        try:
            repeats = int(input[2])
        except:
            context.bot.send_message(update.message.chat_id, "Please enter a valid number", reply_to_message_id = update.message.message_id)
            return
        
        i = 0
        while i < repeats and i < 7:
            if i % 2 == 0:
                context.bot.send_sticker(update.message.chat_id, color_map_1[input[1]])
            else:
                context.bot.send_sticker(update.message.chat_id, color_map_2[input[1]])
            i += 1

def poly(update, context):
    """Send a message when the command /poly is issued."""
    input = update.message.text.split(" ", 4)

    if len(input) != 3 or input[1] == input[2] or color_map_1[input[1]] == None or color_map_1[input[2]] == None:
        return
    
    index1 = color_arr_1.index(color_map_1[input[1]])
    index2 = color_arr_1.index(color_map_1[input[2]])

    if index2 - index1 > 0:
        index2 += 1
    else:
        index2 -= 1
    
    for i in range(index1, index2, int((index2 - index1) / abs(index2 - index1))):
        if i % 2 == 0:
            context.bot.send_sticker(update.message.chat_id, color_arr_1[i])
        else:
            context.bot.send_sticker(update.message.chat_id, color_arr_2[i])
            
def rainbow(update, context):
    """Send a message when the command /rainbow is issued."""
    for i in range(len(color_arr_1)):
        if i % 2 == 0:
            context.bot.send_sticker(update.message.chat_id, color_arr_1[i])
        else: 
            context.bot.send_sticker(update.message.chat_id, color_arr_2[i])

def error(update, context):
    """Log Errors caused by Updates."""
    logger.warning('Update "%s" caused error "%s"', update, context.error)

def main():
    """Start the bot."""
    # Create the Updater and pass it your bot's token.
    # Make sure to set use_context=True to use the new context based callbacks
    # Post version 12 this will no longer be necessary
    updater = Updater(TOKEN, use_context=True)

    # Get the dispatcher to register handlers
    dp = updater.dispatcher

    # on different commands - answer in Telegram
    dp.add_handler(CommandHandler("start", start))
    dp.add_handler(CommandHandler("help", help))
    dp.add_handler(CommandHandler("mono", mono))
    dp.add_handler(CommandHandler("poly", poly))
    dp.add_handler(CommandHandler("rainbow", rainbow))
    dp.add_handler(CommandHandler("colors", colors))

    # on noncommand i.e message - echo the message on Telegram
    # dp.add_handler(MessageHandler(Filters.text, echo))

    # log all errors
    dp.add_error_handler(error)

    # Start the Bot
    updater.start_webhook(listen="0.0.0.0",
                          port=int(PORT),
                          url_path=TOKEN,
                          webhook_url=HOST + TOKEN)

    # updater.bot.setWebhook(HOST + TOKEN)

    # Run the bot until you press Ctrl-C or the process receives SIGINT,
    # SIGTERM or SIGABRT. This should be used most of the time, since
    # start_polling() is non-blocking and will stop the bot gracefully.
    updater.idle()

if __name__ == '__main__':
    main()


