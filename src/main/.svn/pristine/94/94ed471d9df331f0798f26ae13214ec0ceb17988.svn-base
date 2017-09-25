package com.jielan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wang on 2017/1/3.
 */
public class EmojiFilter {

        public static String filterEmoji(String source) {
            if(source != null)
            {
                Pattern emoji = Pattern.compile ("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",Pattern.UNICODE_CASE | Pattern . CASE_INSENSITIVE ) ;
                Matcher emojiMatcher = emoji.matcher(source);
                if ( emojiMatcher.find())
                {
                    source = emojiMatcher.replaceAll("*");
                    return source ;
                }
                return source;
            }
            return source;
        }
    }
