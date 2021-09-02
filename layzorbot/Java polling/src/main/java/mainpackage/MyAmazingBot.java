package mainpackage;

import java.util.HashMap;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendSticker;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyAmazingBot extends TelegramLongPollingBot {

	final String helpMsg = "Lasers all around!\n" + "/colors - List of available colors\n"
			+ "/mono {color} {number} - Creates a pattern of color\n"
			+ "/poly {color1} {color2} - Creates a pattern between colors\n" + "/rainbow - It's a 🌈RAINBOW🌈";
	final String colorsMsg = "red\n" + "orange\n" + "yellow\n" + "yellowgreen\n" + "cyan\n" + "blue\n" + "navy\n"
			+ "purple\n" + "pink";

	String RED1 = "CAACAgQAAxkBAAMdYJkejQeen0CbH8-9R7Zm7p_Acf8AAmIKAAP3sVBiMqllJicS4x8E";
	String RED2 = "CAACAgQAAxkBAAMfYJkelwHNVi7Rhl-lxF20_OiDTDEAAhQLAALx4LBQ0usCh5fiuocfBA";
	String ORANGE1 = "CAACAgQAAxkBAAMhYJkenz1-oI4Zk0N3ba_mL8aKsyoAAm4JAAKHEqhQ91vGn6hFB4wfBA";
	String ORANGE2 = "CAACAgQAAxkBAAMjYJker-qvxRqdn9oDf6eAIjF2t5YAAk0OAAI5GKlQ_0zLZUXwjQsfBA";
	String YELLOW1 = "CAACAgQAAxkBAAMlYJkeuC1_mf1gcSkWYrWkFat-CSQAAmUJAAKjd6lQ32RHrSVH-qofBA";
	String YELLOW2 = "CAACAgQAAxkBAAMnYJkevsvUHYK40WVRWNyoBSNg3GYAAjUKAALvF7FQno80Quk6EmcfBA";
	String YELLOWGREEN1 = "CAACAgQAAxkBAAMpYJkexaY7PdymznwQI1Z-xfkgs5IAAvcLAAJxx6hQ6f3LXzRMcTEfBA";
	String YELLOWGREEN2 = "CAACAgQAAxkBAAMrYJkeytDHVk_8Pts8252DslHiSXAAAloKAAIq3qhQQGkERslFFrMfBA";
	String GREEN1 = "CAACAgQAAxkBAAMtYJke0F2nyeZwUC8T7BFWTYLRwcIAAgEKAAL7qKhQpUee1Ij3VkMfBA";
	String GREEN2 = "CAACAgQAAxkBAAMvYJke1VDYpfxpkwElzmN8AiiMbYgAAlAKAAJ8tbFQ9TgPDp40cuEfBA";
	String CYAN1 = "CAACAgQAAxkBAAMxYJke42EWGw0ko488UcAwexQMThsAAqsIAAIo1KlQnC8sKzWpSjofBA";
	String CYAN2 = "CAACAgQAAxkBAAMzYJke8llLXk8k2JOLpHsTU6_fVZEAAhcKAAKvoKlQgSrlNNfXNXIfBA";
	String BLUE1 = "CAACAgQAAxkBAAM1YJke92_GUWfEvb6mxgkJhkkgmp8AAhYLAALIXahQjXpdbyiab3kfBA";
	String BLUE2 = "CAACAgQAAxkBAAM3YJke_bH9_Vqgu-bB69OKK3aq9UEAAtkJAAKIArFQvgVxjNc_elQfBA";
	String NAVY1 = "CAACAgQAAxkBAAM5YJkfCkVYlEwehLcQRkn78dzbXlIAAgoLAAK4z6hQw_2tvvOqojQfBA";
	String NAVY2 = "CAACAgQAAxkBAAM7YJkfD06Y2ntJkNEJVqKIgy8dnhIAAgYOAAKJ-bBQFn9z--GwcE8fBA";
	String PURPLE1 = "CAACAgQAAxkBAAM9YJkfFqOFt96zoEb5JCNvF0neOPMAAhIMAAJeF7BQYHtNtTAkV5EfBA";
	String PURPLE2 = "CAACAgQAAxkBAAM_YJkfGjvDruk73qBk_S45c5SfR1UAAgQJAAL9A7BQCcY3lpnHT74fBA";
	String PINK1 = "CAACAgQAAxkBAANBYJkfJVLu4cqCVn-GDYAWWgnB4XsAApoIAAJ1D7BQRJWb_LHFA_EfBA";
	String PINK2 = "CAACAgQAAxkBAANDYJkfLsFH7Bmh79rsrPslxDOfAAErAAI-CAACOz2pUPuNngQ5G81RHwQ";

	String[] color_arr_1 = { RED1, ORANGE1, YELLOW1, YELLOWGREEN1, GREEN1, CYAN1, BLUE1, NAVY1, PURPLE1, PINK1 };
	String[] color_arr_2 = { RED2, ORANGE2, YELLOW2, YELLOWGREEN2, GREEN2, CYAN2, BLUE2, NAVY2, PURPLE2, PINK2 };

	HashMap<String, String> color_map_1 = new HashMap<>();
	HashMap<String, String> color_map_2 = new HashMap<>();

	MyAmazingBot() {
		color_map_1.put("red", RED1);
		color_map_1.put("orange", ORANGE1);
		color_map_1.put("yellow", YELLOW1);
		color_map_1.put("yellowgreen", YELLOWGREEN1);
		color_map_1.put("green", GREEN1);
		color_map_1.put("cyan", CYAN1);
		color_map_1.put("blue", BLUE1);
		color_map_1.put("navy", NAVY1);
		color_map_1.put("purple", PURPLE1);
		color_map_1.put("pink", PINK1);

		color_map_2.put("red", RED2);
		color_map_2.put("orange", ORANGE2);
		color_map_2.put("yellow", YELLOW2);
		color_map_2.put("yellowgreen", YELLOWGREEN2);
		color_map_2.put("green", GREEN2);
		color_map_1.put("cyan", CYAN1);
		color_map_2.put("blue", BLUE2);
		color_map_2.put("navy", NAVY2);
		color_map_2.put("purple", PURPLE2);
		color_map_2.put("pink", PINK2);

	}

	public void sendMsg(String chatId, String text) {
		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText(text);
		message.disableNotification();
		try {
			execute(message);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	public void sendStckr(String chatId, String stickerId) {
		InputFile file = new InputFile();
		file.setMedia(stickerId);

		SendSticker sticker = new SendSticker();
		sticker.setChatId(chatId);
		sticker.setSticker(file);
		sticker.disableNotification();

		try {
			execute(sticker);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onUpdateReceived(Update update) {
		String command;
		String chatId;
		if (update.hasMessage() && update.getMessage().hasText()) {
			command = update.getMessage().getText();
			chatId = update.getMessage().getChatId().toString();

			///////////////////
			try {
				System.out.println(update.getMessage().isGroupMessage() + update.getMessage().getFrom().getFirstName()
						+ update.getMessage().getFrom().getLastName() + command);
			} catch (Exception e) {

			}
			///////////////////
		} else {
			return;
		}

		if ((!update.getMessage().isGroupMessage() && command.equals("/help"))
				|| command.equals("/help@" + getBotUsername())) {
			sendMsg(chatId, helpMsg);
		} else if (command.equals("/colors") || command.equals("/colors@" + getBotUsername())) {
			sendMsg(chatId, colorsMsg);
		} else if (command.startsWith("/mono ")) {
			String[] input = command.split(" ", 4);
			if (input.length == 2 && color_map_1.containsKey(input[1])) {
				for (int i = 0; i < 3; i++) {
					if (i % 2 == 0) {
						sendStckr(chatId, color_map_1.get(input[1]));
					} else {
						sendStckr(chatId, color_map_2.get(input[1]));
					}
				}
			} else if (input.length == 3 && color_map_1.containsKey(input[1])) {
				Integer repeats;
				try {
					repeats = Integer.parseInt(input[2]);
				} catch (NumberFormatException e) {
					sendMsg(chatId, "Please enter a valid number!");
					return;
				}
				for (int i = 0; i < repeats && i < 7; i++) {
					if (i % 2 == 0) {
						sendStckr(chatId, color_map_1.get(input[1]));
					} else {
						sendStckr(chatId, color_map_2.get(input[1]));
					}
				}
			}
		} else if (command.startsWith("/poly ")) {
			String[] input = command.split(" ", 4);
			if (input.length == 3 && !input[1].equals(input[2]) && color_map_1.containsKey(input[1])
					&& color_map_1.containsKey(input[2])) {

				Integer index1 = 0;
				Integer index2 = 0;

				while (color_arr_1[index1] != color_map_1.get(input[1]))
					index1++;
				while (color_arr_1[index2] != color_map_1.get(input[2]))
					index2++;

				if (index1 < index2) {
					for (int i = index1; i <= index2; i++) {
						if (i % 2 == 0) {
							sendStckr(chatId, color_arr_1[i]);
						} else {
							sendStckr(chatId, color_arr_2[i]);
						}
					}
				} else {
					for (int i = index1; i >= index2; i--) {
						if (i % 2 == 0) {
							sendStckr(chatId, color_arr_1[i]);
						} else {
							sendStckr(chatId, color_arr_2[i]);
						}
					}
				}
			}
		} else if (command.equals("/rainbow") || command.equals("/rainbow@" + getBotUsername())) {
			for (int i = 0; i < color_arr_1.length; i++) {
				if (i % 2 == 0) {
					sendStckr(chatId, color_arr_1[i]);
				} else {
					sendStckr(chatId, color_arr_2[i]);
				}
			}
		}

	}

	@Override
	public String getBotUsername() {
		return BOT_NAME;
	}

	@Override
	public String getBotToken() {
		return BOT_TOKEN;
	}
}