package org.example.instagramUserInfo;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

public class InstagramUserInfo {
    public String getInstagramUserInfo(String instagramUsername) {
        String msg="";
        try {
            Instagram4j instagram4j=Instagram4j.builder().username("_nodir_575_").password("20040727").build();
            instagram4j.setup();
            instagram4j.login();
            InstagramSearchUsernameResult usernameResult = instagram4j.sendRequest(new InstagramSearchUsernameRequest(instagramUsername));
            msg+=("biografiyasi : "+usernameResult.getUser().biography)+"\n";
            msg+=("username = "+usernameResult.getUser().username)+"\n";
            msg+=("obunachilari soni : "+usernameResult.getUser().getFollower_count())+"\n";
//  //   0      msg+="adress_street"+usernameResult.getUser().address_street+"\n";
//       1    msg+="category: "+usernameResult.getUser().category+"\n";
            msg+="business_contact_method: "+usernameResult.getUser().business_contact_method+"\n";
//  //   0      msg+="city_name: "+usernameResult.getUser().city_name+"\n";
//            msg+="public_email: "+usernameResult.getUser().public_email+"\n";
//            msg+="isHas_anonymous_profile_picture: "+usernameResult.getUser().isHas_anonymous_profile_picture()+"\n";
//            msg+="is_private: "+usernameResult.getUser().is_private+"\n";
//            msg+="direct_messaging: "+usernameResult.getUser().direct_messaging+"\n";
//            msg+="public_phone_country_code: "+usernameResult.getUser().public_phone_country_code+"\n";
//            msg+="public_phone_number: "+usernameResult.getUser().public_phone_number+"\n";
            msg+="following soni: "+usernameResult.getUser().following_count+"\n";
//            usernameResult.getUser().setDirect_messaging("salom jiyan");
        return msg;
        } catch (Exception e) {
            return ("tanimadim");
        }
    }
}
