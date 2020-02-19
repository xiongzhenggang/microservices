package cmiov.oauth.constant;

public interface SecurityConstants {
    String USER_SPLIT = ":";
    String USER_HEADER = "x-user-header";
    String USER_ID_HEADER = "x-userid-header";
    String ROLE_HEADER = "x-role-header";
    String TENANT_HEADER = "x-tenant-header";
    String TOKEN_HEADER = "Authorization";
    String BASE_ROLE = "ROLE_USER";
    String AUTHORIZATION_CODE = "authorization_code";
    String PASSWORD = "password";
    String REFRESH_TOKEN = "refresh_token";
    String OAUTH_TOKEN_URL = "/oauth/token";
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/validata/code";
    String MOBILE_VALIDATE_CODE_URL_PREFIX = "/validata/smsCode";
    String DEFAULT_IMAGE_WIDTH = "100";
    String DEFAULT_IMAGE_HEIGHT = "35";
    String DEFAULT_IMAGE_LENGTH = "4";
    int DEFAULT_IMAGE_EXPIRE = 60;
    String DEFAULT_COLOR_FONT = "blue";
    String DEFAULT_IMAGE_BORDER = "no";
    String DEFAULT_CHAR_SPACE = "5";
    String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY";
    String DEFAULT_IMAGE_FONT_SIZE = "30";
    String CACHE_CLIENT_KEY = "oauth_client_details";
    String OAUTH_LOGIN_PRO_URL = "/user/login";
    String PASSWORD_LOGIN_PRO_URL = "/oauth/user/token";
    String AUTH_CODE_URL = "/oauth/authorize";
    String LOGIN_PAGE = "/login.html";
    String OPENID_TOKEN_URL = "/oauth/openId/token";
    String MOBILE_TOKEN_URL = "/oauth/mobile/token";
    String LOGOUT_URL = "/oauth/remove/token";
    Integer ACCESS_TOKEN_VALIDITY_SECONDS = 3600;
    String REDIS_TOKEN_AUTH = "auth:";
    String REDIS_CLIENT_ID_TO_ACCESS = "client_id_to_access:";
    String REDIS_UNAME_TO_ACCESS = "uname_to_access:";
}

