package com.example.tourism;

//import com.yupaits.yutool.plugin.jwt.support.JwtHelper;
//import io.jsonwebtokentoken.Jwt;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class MetabaseController2 {
    private final String METABASE_SITE_URL = "http://localhost:3000";  //The IP address of your metabase, metabase default port number 3000
    private final String METABASE_SECRET_KEY = "3914be727f913c61c7b2bbccc4a50ba00a3cb8d1857ea860506884ae9199a979";


    @GetMapping("/dashurl")
    public DashboardParams dashAction() {
        int round = Math.round(System.currentTimeMillis() / 1000)+10*60; // 10 minute expiration
        String pyload = "{\n" +
                "  \"resource\": {\"dashboard\": 1},\n" +  //This place should write the number you share
                "  \"params\": {\n" +
                "    \n" +
                "  },\n" +
                "  \"exp\":"+ round + "\n" +   //If no expiration time is required, this line can be commented out
                "}";

        Jwt token = JwtHelper.encode(pyload, new MacSigner(METABASE_SECRET_KEY));
        //Note the difference between the sharing dashboard and question in the address below
        String url = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#bordered=true&titled=true";
        return new DashboardParams(url);
    }

    @GetMapping("/questionurl")
    public DashboardParams questionAction() {
        //Because the problem is shared, the question in the resource below is the question, not the dashboard, and pay attention to the change of the number
        Jwt token = JwtHelper.encode("{\"resource\": {\"question\": 65}, \"params\": {}}", new MacSigner(METABASE_SECRET_KEY));
        String url = METABASE_SITE_URL + "/embed/question/" + token.getEncoded() + "#bordered=true&titled=true";
        return new DashboardParams(url);
    }


    class DashboardParams {
        private String url;

        public DashboardParams(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}


