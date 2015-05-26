package bsu.famcs.chat.util;

import bsu.famcs.chat.model.Message;
import bsu.famcs.chat.model.MessageStorage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class MessageUtil {

    public static final String TOKEN = "token";
    public static final String MESSAGES = "messages";
    private static final String TN = "TN";
    private static final String EN = "EN";
    private static final String USER = "user";
    private static final String TEXT = "text";

    private MessageUtil() {
    }

    public static String getToken(int index) {
        Integer number = index * 8 + 11;
        return TN + number + EN;
    }

    public static int getIndex(String token) {
        return (Integer.valueOf(token.substring(2, token.length() - 2)) - 11) / 8;
    }

    private static String generateId() {
        return String.valueOf(MessageStorage.getSize());
    }

    public static String generateCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/Minsk"));
        return dateFormat.format(new Date());
    }

    public static JSONObject stringToJson(String data) throws ParseException {
        JSONParser jsonParser = new JSONParser();
        return (JSONObject) jsonParser.parse(data.trim());
    }

    public static Message jsonToMessage(JSONObject json) {
        String user = (String)json.get(USER);
        String text = ((String)json.get(TEXT)).trim();
        if (user != null) {
            return new Message(generateId(), user, text, generateCurrentDate());
        }
        return null;
    }
}
