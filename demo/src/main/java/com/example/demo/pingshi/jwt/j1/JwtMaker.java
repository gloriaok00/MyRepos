package com.example.demo.pingshi.jwt.j1;

import io.jsonwebtoken.impl.TextCodec;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *  @description 自制jwt
 *  @date  2022/5/14 01:20
 */

public class JwtMaker {
    //   SECRET KEY
    private final static String secret_key = "iotKey";

    private static String sha256_HMAC(String message, String secret) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bs = sha256_HMAC.doFinal(message.getBytes());
            //这里用的是去除掉后面的=号后的形式
            return TextCodec.BASE64URL.encode(bs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception{
        //手动形成jwt
        String s="{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
        String header = Base64.getUrlEncoder().encodeToString(s.getBytes(StandardCharsets.US_ASCII));
        System.out.println("header:"+header);

      /*payload这里后面有可能会有=号 jjwt里的源码我看就是用TextCodec这种把所有的补位=号去掉
        了这种的, 这种的直接放在bejson是解析不了的。而java8源生的Base64那种的是含有=号的,
        可以在bejson上解析,但jwt里直接用不好使。可能是因为jwt里就要这种去掉=号后的吧。而且只有
        去掉=号后的,才能在jwt.io上解析出来,目前的理解是jwt里就是固定用这种去掉=号的*/
        String s2="{\"password\":\"super_admin\",\"auth\":[\"VIEW_SERVER_INFO\",\"REST\",\"ADMIN_CONSOLE\",\"ADMINISTER_USERS\",\"ADMINISTER_USER_SELF\",\"ADMINISTER_TENANTS\",\"ADMINISTER_TENANT_SELF\",\"ADMINISTER_SCHEDULES\",\"SCHEDULE_COMMANDS\"],\"user_name\":\"super_admin\",\"scope\":[\"app\"],\"tenantId\":1,\"exp\":1652585456,\"authorities\":[\"86:/areatypes/delete/*\",\"41:/technology/technology/delete/*\",\"39:/technology/technology/create\",\"27:/devices/v2/devices\",\"40:/technology/technology/update/*\",\"107:/dept/update\",\"95:/production/update/task/*\",\"29:/devices/update/*\",\"83:/areatypes/create\",\"70:/devicetypes/update/*/commands/*\",\"19:/role/assign/permissions\",\"34:/assets/create\",\"76:/devicetypes/delete/*/statuses/*\",\"58:/devicetypes/create\",\"59:/devicetypes/v2/devicetypes\",\"79:/technology/templates\",\"102:/production/formula/*/split\",\"21:/role/delete\",\"16:/user/delete\",\"63:/devicetypes/create/*/attributes\",\"98:/production/tasks2formula/merge\",\"28:/devices/create\",\"74:/statuses\",\"11:/role/list\",\"18:/role/assign/menus\",\"13:/user/assign/roles\",\"32:/sl/gatewaylist\",\"75:/devicetypes/update/*/statuses/*\",\"44:/technology/formula/create\",\"73:/devicetypes/create/*/statuses\",\"96:/production/delete/task/*\",\"56:/assettypes/delete/*\",\"64:/devicetypes/*/attributes\",\"46:/technology/formula/delete/*\",\"66:/devicetypes/delete/*/attribute/*\",\"93:/production/create/task\",\"99:/devices/*/invocations\",\"14:/user/list\",\"55:/assettypes/update/*\",\"30:/devices/delete/*\",\"105:/dept/create\",\"85:/areatypes/update/*\",\"36:/assets/delete/*\",\"94:/production/tasks\",\"20:/role/update\",\"88:/areas/create\",\"84:/areatypes\",\"10:/role/create\",\"15:/user/update\",\"78:/technology/create/template\",\"101:/production/formulas\",\"108:/dept/delete\",\"89:/areas\",\"80:/technology/update/template/*\",\"68:/devicetypes/create/*/commands\",\"38:/technology/technologys\",\"65:/devicetypes/update/*/attribute/*\",\"81:/technology/delete/template/*\",\"35:/assets/update/*\",\"91:/areas/delete/*\",\"43:/technology/formulas\",\"60:/devicetypes/update/*\",\"53:/assettypes/create\",\"24:/menu/list\",\"45:/technology/formula/update/*\",\"51:/assignments/*/end\",\"106:/dept/list\",\"69:/commands\",\"61:/devicetypes/delete/*\",\"22:/permission/list\",\"71:/devicetypes/delete/*/commands/*\",\"90:/areas/update/*\",\"31:/assignments/create\",\"12:/user/create\",\"17:/user/reset/password\",\"54:/assettypes\",\"103:/production/formula/deviceAssignment\"],\"jti\":\"6f117af5-24d1-414c-a527-7c843a1d90d2\",\"client_id\":\"iot_web\"}";
        String payload=TextCodec.BASE64URL.encode(s2.getBytes(StandardCharsets.US_ASCII));
        System.out.println("payload:"+payload);
        System.out.println("signature:"+sha256_HMAC(header+"."+payload, secret_key));

    }
}
