package com.kelurahankepuharjo.atry;

import android.content.Context;
import android.content.SharedPreferences;

public class UserSessions {
        private SharedPreferences prefs;

        public UserSessions(Context context) {
            prefs = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        }

        public boolean isUserLoggedIn() {
            return prefs.getBoolean("userlogin", false);
        }

        public void setUserLoggedIn(boolean isLoggedIn) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("userlogin", isLoggedIn);
            editor.apply();
        }

        public String getUsername() {
            return prefs.getString("Username", "");
        }

        public void setUsername(String username) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("Username", username);
            editor.apply();
        }
    }

