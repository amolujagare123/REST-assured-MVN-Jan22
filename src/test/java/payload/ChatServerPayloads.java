package payload;

public class ChatServerPayloads {


    public static String  createUserPayload()
    {
        return "{\n" +
                "  \"username\": \"vaishali19\",\n" +
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


    public static String  createUserPayload(String username,String password,
                                            String email,String name,String surname,
                                            String nickname)
    {
        return "{\n" +
                "  \"username\": \""+username+"\",\n" +
                "  \"password\": \""+password+"\",\n" +
                "  \"email\": \""+email+"\",\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"surname\": \""+surname+"\",\n" +
                "  \"chat_nickname\": \""+nickname+"\",\n" +
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
