package com.marketplace.security;

/**
 * @author salomao.marcos@gmail.com
 * @since 26/05/17
 */
public class GooglePrincipal {

    private String userId;
    private String email;
    private boolean emailVerified;
    private String name;
    private String pictureUrl;
    private String locale;
    private String familyName;
    private String givenName;

    private GooglePrincipal(Builder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.emailVerified = builder.emailVerified;
        this.name = builder.name;
        this.pictureUrl = builder.pictureUrl;
        this.locale = builder.locale;
        this.familyName = builder.familyName;
        this.givenName = builder.givenName;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getLocale() {
        return locale;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public static final class Builder {

        private String userId;
        private String email;
        private boolean emailVerified;
        private String name;
        private String pictureUrl;
        private String locale;
        private String familyName;
        private String givenName;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder emailVerified(boolean emailVerified) {
            this.emailVerified = emailVerified;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder pictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
            return this;
        }

        public Builder locale(String locale) {
            this.locale = locale;
            return this;
        }

        public Builder familyName(String familyName) {
            this.familyName = familyName;
            return this;
        }

        public Builder givenName(String givenName) {
            this.givenName = givenName;
            return this;
        }

        public GooglePrincipal build() {
            return new GooglePrincipal(this);
        }

    }

}
