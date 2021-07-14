package org.lql.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.lql.exception.PermissionException;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Title: JwtUtil <br>
 * ProjectName: spring-cloud-example <br>
 * description: JWT生成和验证解析工具类 <br>
 *
 * @author: leiql <br>
 * @version: 1.0 <br>
 * @since: 2021/7/14 13:54 <br>
 */
public class JwtUtil {

    public static final String SECRET = "qazwsx123444$#%#()*&& asdaswwi1235 ?;!@#kmmmpom in***xx**&";
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_AUTH = "Authorization";

    public static String generateToken(String user) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", new Random().nextInt());
        map.put("user", user);

        String jwt = Jwts.builder().setSubject("user info").setClaims(map)
                .signWith(SignatureAlgorithm.HS256, JwtUtil.SECRET)
                .compact();
        String finalJwt = JwtUtil.TOKEN_PREFIX + " " + jwt;
        return finalJwt;
    }

    public static Map<String, String> validateToken(String token) {
        if (token != null) {
            HashMap<String, String> map = new HashMap<>();
            Map<String, Object> body = Jwts.parser().setSigningKey(JwtUtil.SECRET)
                    .parseClaimsJws(token.replace(JwtUtil.TOKEN_PREFIX, ""))
                    .getBody();
            String id = String.valueOf(body.get("id"));
            String user = (String) (body.get("user"));
            map.put("id", id);
            map.put("user", user);
            if (StringUtils.isEmpty(user)) {
                throw new PermissionException("user is error, please check");
            }

            return map;
        }else {
            throw new PermissionException("token is error, please check");
        }
    }
}
