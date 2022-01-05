package payload;

public class ChatServerPayloads {


    public static String  createUserPayload()
    {
        return "{\n" +
                "  \"username\": \"vaishali99\",\n" +
                "  \"password\": \"vaishali123\",\n" +
                "  \"email\": \"vaishali@example.org\",\n" +
                "  \"name\": \"vaishali\",\n" +
                "  \"surname\": \"xyz\",\n" +
                "  \"chat_nickname\": \"v-xyz\",\n" +
                "  \"departments\": [\n" +
                "    1,\n" +
                "    2\n" +
                "  ],\n" +
                "  \"departments_read\": [\n" +
                "    2\n" +
                "  ],\n" +
                "  \"department_groups\": [\n" +
                "    1\n" +
                "  ],\n" +
                "  \"user_groups\": [\n" +
                "    1\n" +
                "  ]\n" +
                "}";
    }

}
