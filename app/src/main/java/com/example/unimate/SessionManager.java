package com.example.unimate;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    Context context;
    private SharedPreferences sp;
   private  SharedPreferences.Editor editor;
   private final String FILE_NAME ="unimate";
   private  final int MODE =0;
   private  final String NAME_KEY = "session_name_key";
   private final String EMAIL_KEY = "session_email_key";
   private  final String IF_LOGGED_IN ="if_session_log_in";

    public SessionManager(Context context)
    {
         this.context = context;
         sp = context.getSharedPreferences(FILE_NAME,MODE);
        /*
        getSharedPreferences is a method of the Context class in Android. It is used to get a handle
        to the shared preferences file that the system maintains. Shared preferences allow you to store
        and retrieve key-value pairs persistently.
         */
        editor = sp.edit();
        /*Get an Editor instance from the SharedPreferences using the edit() method.
         Use the Editor methods to make changes to the shared preferences (e.g., putString, putInt, remove, etc.).
         */
    }


    /* It checks if a certain key (IF_LOGGED_IN) exists in the shared preferences.
     */
    public boolean checkSession()
    {
        /*
        1.The contains method of SharedPreferences checks whether the shared preferences contain a specific
        key (IF_LOGGED_IN). If the key is present, it means that the user is considered to be logged in.

        2.The method returns true, indicating that a session is present (the user is considered logged in).
         The method returns false, indicating that there is no active session (the user is considered not
         logged in).
         */
        if(sp.contains(IF_LOGGED_IN))
        {
             return true;
        }
        else
            return false;
    }


    /*The createSession method, when called, effectively stores the user's name, email, and the information
    that the user is logged in, into the shared preferences. This information can be retrieved later to check
     if the user is logged in and to display personalized content based on their name and email.
     */
    public void createSession(String name, String email)
    {
       editor.putString(NAME_KEY,name);
       /* putString method of the SharedPreferences.Editor interface to store a string value (name) in
       the shared preferences under the key specified by NAME_KEY.
       SharedPreferences.Editor to persist the changes to the shared preferences. This is important because
        changes made using the editor are not applied immediately but are held in-memory until
        this method is called
        */
        editor.putString(EMAIL_KEY,email);
        editor.putBoolean(IF_LOGGED_IN, true); //indicating that the user is now logged in.
        editor.commit();
    }


    /* to retrieve a value from the SharedPreferences based on a given key.
     */
    public String getSessionDetails(String key)
    {
        /* The getString method of the SharedPreferences interface to retrieve a string value associated
        with the specified key. a default value to return if the key is not found. In this case,
        if the key is not found, it returns null.
         */
        String value = sp.getString(key, null);
        return  value;
    }

}
